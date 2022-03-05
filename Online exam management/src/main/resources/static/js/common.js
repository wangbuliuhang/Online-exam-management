/**
 * 读取分页面的HTML，加载到index.html的对应的id的块中
 */
var loadHtml = function(url,id){
	$.ajax({
		type:"get",
		url:"./" + url, //需要获取的页面
		async:true,
		success:function(data){
			$('#'+id).html(data)
		}
	});
}

/*
公共加载修改页
参数是一个json，以下是参数示例
{
    "id" : id, // 第一个ajax的请求参数值
    "url" : "/menu/getById", // 第一个ajax的请求url
    "loadHtmlPath" : "menu-add.html", // 第二个ajax的请求url
    "hiddenId" : "menuId", // 修改页面的隐藏域的id
    "ids" : ["menuCode","menuName","menuUrl","menuLevel","parentId","sort"], // 修改页的表单元素的id数组
    "fn" : function(object, htmlData){ // 除了通用的加载页面回填数据之外的，其他需要执行的特殊逻辑
        // object:第一个ajax根据id查询的实体类对象
        // htmlData:第二个ajax加载页面返回的页面jQuery对象
        loadPMenus($("#menuLevel")); // 加载父菜单下拉选项
        $("#parentId").val(object.parentId); // 设置父菜单下拉选项的选中
    }
}
*/
var loadUpdatePage = function(updateJson){
    $.ajax({
        type : "post",
        url : updateJson.url,
        data : {
            "id" : updateJson.id
        },
        dataType : "json",
        success : function(menu) {// 后端的返回值


            // 后端返回了查询的要修改的menu对象，加载menu-add页面，并且加载完成后给menu-add页面回填数据
            $.ajax({
                type:"get",
                url:"./" + updateJson.loadHtmlPath, //需要获取的页面
                async:true,
                success:function(data){
                    // 加载menu-add页面
                    $('#content').html(data); //将获取到的内容放到当前页面的.content-wrapper中

                    // 加载完成后给menu-add页面回填数据
                    //$("#menuId").val(menu.id);
                    $("#" + updateJson.hiddenId).val(menu.id);
                    /*$("#menuCode").val(menu.menuCode);
                    $("#menuName").val(menu.menuName);
                    $("#menuUrl").val(menu.menuUrl);
                    $("#menuLevel").val(menu.menuLevel);
                    $("#parentId").val(menu.parentId);
                    $("#sort").val(menu.sort);*/

                    //var ids = ["menuCode","menuName","menuUrl","menuLevel","parentId","sort"];
                    $.each(updateJson.ids, function(index, inputId){
                        $("#" + inputId).val(menu[inputId]);
                    });

                    // menu-update页面需要特殊处理的地方
                    //loadPMenus($("#menuLevel")); // 加载父菜单下拉选项
                    //$("#parentId").val(menu.parentId); // 设置父菜单下拉选项的选中
                    updateJson.fn(menu, data);
                }
            });
        }
    });
}

/**
根据元素id值生成对应ajax的data参数
参数，ids，是id的数组
*/
var createJsonParams = function(ids){
    var jsonParams = {};
    $.each(ids, function(index, id){
        jsonParams[id] = $("#" + id).val();
    });
    return jsonParams;
}

/*
删除公共函数
*/
var del = function(id, myUrl){
    $.ajax({
        type : "post",
        url : myUrl,
        data : {
            "id" : id
        },
        dataType : "json",
        success : function(data) {// 后端的返回值
            alert(data.msg);
        }
    });
}

/*
通用的新增修改函数
参数是json，以下示例
{
    "hiddenId" : "menuId", // 隐藏域id
    "url" : "/menu/", // 新增或者修改的ajax的url的一级路径
    "ids" : ["menuCode","menuName","menuUrl","menuLevel","parentId","sort"]
}
*/
var addOrUpdate = function(addOrUpdateJson){
    //var ids = ["menuCode","menuName","menuUrl","menuLevel","parentId","sort"];
    var jsonParams = createJsonParams(addOrUpdateJson.ids);

    //var myUrl = "/menu/add";
    //hiddenId使用户看不到的id（显示上多余），但可以利用它来判断是添加还是更新
    var id = $("#" + addOrUpdateJson.hiddenId).val();
    if(id != ""){ // 有值，是update
        //myUrl = "/menu/update";
        addOrUpdateJson.url += "update";
        jsonParams["id"] = id;
    }else{
        addOrUpdateJson.url += "add";
    }

    $.ajax({
        type : "post",
        url : addOrUpdateJson.url,
        data : jsonParams,
        dataType : "json",
        success : function(data) {// 后端的返回值
            alert(data.msg);
        }
    });
}

/*
通用的加载数据列表函数
参数json，以下是示例
{
"jsGridId" : "jsGrid1", // jsGrid所在的div的id
"searchId" : "queryParam", // 查询输入框的id
"url" : "/menu/list", // 加载数据的url
"pageIndex" : 1,
"pageSize" : 3,
"pageButtonCount" : 10,
"fields" : [
             { title: "id", name: "id", type: "text", width: 40 },
             { title: "菜单编码", name: "menuCode", type: "text", width: 150 },
             { title: "菜单名称", name: "menuName", type: "text", width: 150 },
             { title: "菜单级别", name: "menuLevel", type: "text", width: 80 },
             { title: "菜单url", name: "menuUrl", type: "text", width: 150 },
             { title: "父级菜单", name: "parentMenu", type: "text", width: 150 },
             { title: "排序", name: "sort", type: "text", width: 50 },
             {
               title: "操作", name: "id", type: "text", width: 150, align: "center",
               itemTemplate: function(value, item){
                   return "<a href='javascript:void(0);' onclick='del(" + value + ", \"/menu/del\")'>删除</a>"
                       + "&nbsp;&nbsp;&nbsp;&nbsp;"
                       + "<a href='javascript:void(0);' onclick='update(" + value + ")'>修改</a>";

               }
             }
         ]
}
*/
var loadPageList = function(pageJson){
  $("#" + pageJson.jsGridId).jsGrid({
      //height: "100%",
      height: "auto",
      width: "100%",

      sorting: true, // 支持排序
      paging: true, // 支持分页的底部的页数加载计算
      pageLoading: true, //启动后台加载分页数据
      autoload: true, //自动加载
      controller:{
        loadData: function(filter){
            /*
            filter本身就是一个json
            filter[key] = value
            */
            filter[pageJson.searchId] = $("#" + pageJson.searchId).val(); // 查询条件
            return $.ajax({
             type: "post",
             url: pageJson.url,
             dataType: "json",
             data: filter
             });
        }
      },
      pageIndex: pageJson.pageIndex, // 当前页数，是第几页
      pageSize: pageJson.pageSize, // 每页数据条数
      pageButtonCount: pageJson.pageButtonCount, // 展示可选页码数量
      pagePrevText: "上一页",
      pageNextText: "下一页",
      pageFirstText: "首页",
      pageLastText: "尾页",

      //data: db.clients,

      fields: pageJson.fields
  });
}
$(function () {
    menuList();
});

var menuList = function(){
  loadPageList({
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
  });

}

//修改
var update = function(id){
    /*
    var updateJson = {
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
    };

    loadUpdatePage(updateJson);
    */

    loadUpdatePage({
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
    });
}
/*
下拉列表二级联动，根据选择的菜单级别加载父菜单列表的选项
参数obj，是菜单级别下拉列表对象
*/
var loadPMenus = function(obj){
    var menuLevel = $(obj).val(); // 菜单级别

    // 判断菜单级别，如果是一级菜单就不去数据库查询
    if(menuLevel == "1"){ // 选择一级菜单时
        var opt = '<option value="0">默认父菜单</option>';
        $("#parentId").html(opt);
        return false;
    }

    // 选择二级菜单时，根据菜单级别查询父菜单列表
    $.ajax({
        type : "post",
        url : "/menu/loadPMenus",
        async : false, // 同步ajax
        dataType : "json",
        success : function(data) {// 后端的返回值
            var opt = "<option value=''>--请选择--</option>";
            $.each(data, function(index, menu){
                opt += "<option value='" + menu.id + "'>" + menu.menuName + "</option>";
            });
            $("#parentId").html(opt);
        }
    });
}

/*
新增或者修改菜单
*/
var menuAdd = function(){
    /*
    var addOrUpdateJson = {
        "hiddenId" : "menuId", // 隐藏域id
        "url" : "/menu/add", // 新增或者修改的ajax的url
        "ids" : ["menuCode","menuName","menuUrl","menuLevel","parentId","sort"]
    };
    addOrUpdate(addOrUpdateJson);
    */

    addOrUpdate({
        "hiddenId" : "menuId", // 隐藏域id
        "url" : "/menu/", // 新增或者修改的ajax的url的一级路径
        "ids" : ["menuCode","menuName","menuUrl","menuLevel","parentId","sort"]
    });
}
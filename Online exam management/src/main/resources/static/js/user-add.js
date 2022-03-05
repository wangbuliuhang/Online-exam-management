/*
下拉列表二级联动，根据选择的菜单级别加载父菜单列表的选项
参数obj，是菜单级别下拉列表对象
*/
//页面一加载先加载所有专业 专业一切换就加载学科
var facultyId;

$(function () {
    $.ajax({
            type : "post",
            url : "/faculty/loadFaculty",
            async : true, // 同步ajax
            dataType : "json",
            success : function(data) {// 后端的返回值
                var opt = "<option value=''>--请选择--</option>";
                $.each(data, function(index, faculty){
                    opt += "<option value='" + faculty.id + "'>" + faculty.facultyName + "</option>";
                });
                $("#facultyId").html(opt);
            }
        });

    loadAllRole();
});

var loadPMenus1 = function(obj){  //查询二级角色菜单
    facultyId = $(obj).val(); // 菜单级别

    // 判断菜单级别，如果是一级菜单就不去数据库查询
    if(facultyId == ""){
        var opt = '<option value="0">默认父菜单</option>';
        $("#majorId").html(opt);
        return false;
    }

    // 选择二级菜单时，根据菜单级别查询父菜单列表
    $.ajax({
        type : "post",
        url : "/major/loadPMenus1",
        async : true, // 异步
        data : {
            "facultyId":facultyId,
        },
        dataType : "json",
        success : function(data) {// 后端的返回值
            var opt = "<option value=''>--请选择--</option>";
            $.each(data, function(index, major){
                opt += "<option value='" + major.id + "'>" + major.majorName + "</option>";
            });
            $("#majorId").html(opt);
        }
    });
}

var loadPMenus2 = function(obj){  //查询3级角色菜单
    var majorId = $(obj).val(); // 菜单级别

    // 判断菜单级别，如果是一级菜单就不去数据库查询
    if(majorId == ""){
        var opt = '<option value="0">默认父菜单</option>';
        $("#classId").html(opt);
        return false;
    }

    // 选择二级菜单时，根据菜单级别查询父菜单列表
    $.ajax({
        type : "post",
        url : "/class/loadPMenus2",
        async : true, // 同步ajax
        data : {
            "facultyId":facultyId,
            "majorId":majorId
        },
        dataType : "json",
        success : function(data) {// 后端的返回值
            var opt = "<option value=''>--请选择--</option>";
            $.each(data, function(index, class1){
                opt += "<option value='" + class1.id + "'>" + class1.className + "</option>";
            });
            $("#classId").html(opt);
        }
    });
}

var loadAllRole = function(obj){  //查询3级角色菜单
    // 选择二级菜单时，根据菜单级别查询父菜单列表
    $.ajax({
        type : "post",
        url : "/role/loadAllRole",
        async : true, // 同步ajax
        data : {},
        dataType : "json",
        success : function(data) {// 后端的返回值
            var opt = "<option value=''>--请选择--</option>";
            $.each(data, function(index, role){
                opt += "<option value='" + role.id + "'>" + role.roleName + "</option>";
            });
            $("#roleId").html(opt);
        }
    });
}

/*
新增或者修改菜单
*/

var userAdd = function(){
    addOrUpdate({
        "hiddenId" : "userId", // 隐藏域id
        "url" : "/user/", // 新增或者修改的ajax的url的一级路径
        "ids" : ["username","password","realName","sex","sno","facultyId","majorId","classId","roleId"]
    });
}


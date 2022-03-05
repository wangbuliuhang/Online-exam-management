$(function(){
    userList();
})

var userList = function(){
  loadPageList({
      "jsGridId" : "jsGrid1", // jsGrid所在的div的id
      "searchId" : "queryParam", // 查询输入框的id
      "url" : "/user/list", // 加载数据的url
      "pageIndex" : 1,
      "pageSize" : 3,
      "pageButtonCount" : 10,
      "fields" : [
                   { title: "id", name: "id", type: "text", width: 40 },
                   { title: "用户名称", name: "username", type: "text", width: 150 },
                   { title: "真实姓名", name: "realName", type: "text", width: 150 },
                   { title: "性别", name: "sex", type: "text", width: 150 },
                   { title: "学号", name: "sno", type: "text", width: 150 },
                   { title: "学院id", name: "facultyId", type: "text", width: 150 },
                   { title: "专业id", name: "majorId", type: "text", width: 150 },
                   { title: "班级id", name: "classId", type: "text", width: 150 },
                   { title: "角色id", name: "roleId", type: "text", width: 150 },

                   {
                     title: "操作", name: "id", type: "text", width: 150, align: "center",
                     itemTemplate: function(value, item){
                         return "<a href='javascript:void(0);' onclick='del(" + value + ", \"/user/del\")'>删除</a>"
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
        "url" : "/user/getById", // 第一个ajax的请求url
        "loadHtmlPath" : "user-add.html", // 第二个ajax的请求url
        "hiddenId" : "userId", // 修改页面的隐藏域的id
        "ids" : ["username","realName","sex","sno","facultyId","classId","roleId"], // 修改页的表单元素的id数组
        "fn" : function(object, htmlData){ // 除了通用的加载页面回填数据之外的，其他需要执行的特殊逻辑
            alert(htmlData);
            // object:第一个ajax根据id查询的实体类对象
            // htmlData:第二个ajax加载页面返回的页面jQuery对象
           /* loadPMenus($("#menuLevel")); // 加载父菜单下拉选项
            $("#parentId").val(object.parentId); // 设置父菜单下拉选项的选中*/
            loadPMenus1($("#facultyId"));
            $("#facultyId").val(object.facultyId);
            loadPMenus2($("#majorId"));
            $("#majorId").val(object.majorId);
            $("#classId").val(object.classId);
            loadAllRole("#roleId");
        }
    });
}
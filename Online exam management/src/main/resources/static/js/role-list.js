$(function(){
    roleList();
})

var roleList = function(){
  loadPageList({
      "jsGridId" : "jsGrid1", // jsGrid所在的div的id
      "searchId" : "queryParam", // 查询输入框的id
      "url" : "/role/list", // 加载数据的url
      "pageIndex" : 1,
      "pageSize" : 3,
      "pageButtonCount" : 10,
      "fields" : [
                   { title: "id", name: "id", type: "text", width: 40 },
                   { title: "角色编码", name: "roleCode", type: "text", width: 150 },
                   { title: "角色名称", name: "roleName", type: "text", width: 150 },
                   {
                     title: "操作", name: "id", type: "text", width: 150, align: "center",
                     itemTemplate: function(value, item){
                         return "<a href='javascript:void(0);' onclick='del(" + value + ", \"/role/del\")'>删除</a>"
                             + "&nbsp;&nbsp;&nbsp;&nbsp;"
                             + "<a href='javascript:void(0);' onclick='update(" + value + ")'>修改</a>";

                     }
                   }
               ]
  });
}


//修改
var update = function(id){
    loadUpdatePage({
        "id" : id, // 第一个ajax的请求参数值
        "url" : "/role/getById", // 第一个ajax的请求url
        "loadHtmlPath" : "role-add.html", // 第二个ajax的请求url
        "hiddenId" : "roleId", // 修改页面的隐藏域的id
        "ids" : ["roleCode","roleName"], // 修改页的表单元素的id数组
        "fn" : function(object, htmlData){ // 除了通用的加载页面回填数据之外的，其他需要执行的特殊逻辑
            // object:第一个ajax根据id查询的实体类对象
            // htmlData:第二个ajax加载页面返回的页面jQuery对象
            loadZNodes(object); //加载菜单树
        }
    });
}
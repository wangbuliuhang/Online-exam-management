var login=function(){
    var username=$("#username").val();
    var password=$("#password").val();
     $.ajax({
            type : "post",
            url : "/user/login",
            data : { //前面是类名属性（数据库属性名）  后面对应的是username变量
                "username" : username,
                "password" : password
            },
            dataType : "json",
            success : function(data) {// 后端的返回值
                //alert(data);
                if(data.code==="999"){
                    alert(data.msg);
                    return false; //登陆失败，中断程序左边不显示
                    //可能会被有意者绕过，但即使绕过，不是注册特定用户，index
                }
                location.href="index.html";
            }
        });
}
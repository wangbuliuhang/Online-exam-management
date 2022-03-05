$(function(){ // 页面加载完成之后自动运行
    test2();
});

var test = function(){
    var html = $("div:eq(1) > div:eq(1) > div:eq(0)").html();
    alert(html);
}

var test1 = function(){
    var html = $("div:eq(1) > div:eq(0)").html();
    $("div:eq(0)").append(html);
}

var test2 = function(){
    $("tr:gt(0) > td").dblclick(function(){
//        alert($(this).html());
        changeText(this); // 这里的this是指的当前的td对象
        myOnBlur(this);
    });
}

// 参数是要给文本框的元素对象
var changeText = function(obj){
    var oldVal = $(obj).html();
    $(obj).attr("oldVal", oldVal);
    $(obj).html('<input type="text">');
    $(obj).find("input").focus(); // 加载到文本框之后，使文本框获得焦点
}

// 当前元素对象中的input失去焦点事件
var myOnBlur = function(obj){
    $(obj).find("input").blur(function(){
//        alert($(this).val());// 这里的this是指的当前的input对象
        var tmpVal = $(this).val();
        if(tmpVal == ""){// 如果文本框没有输入值，把原来的值填回去
            $(obj).html($(obj).attr("oldVal"));
        }else{
            $(obj).html(tmpVal); // 把文本框的值覆盖掉文本框
        }
    });
}
function test(){
    document.getElementById("h0").innerHTML = "修改h1的内容!!!!!!!!!";
}

function test1(){
    //$("#h0").html("jQuery修改内容");
//    alert($(".t0").length);
//    alert($(".t0,.t1").length);
//    alert($("h1").html());
//    alert($("h1").length);
//    alert($("h1:first").html());
    /*
    $("tr:first td:first-child")
    分成2段
    第1段，找到父元素对象，就是要获取谁的子元素
    第2段，获取的子元素的标签，和获取第几个子元素
    */
//    alert($("tr:first td:first-child").html());

//    alert($("table tr:first-of-type").html());
//    alert($("#d0 > div").length);
//    $("#d0 > div").each(function(){
//        alert($(this).html());
//    });
//    $("#d0 div").each(function(){
//        alert($(this).html());
//    });

//      alert($("input[type='button']").length);
//      alert($("td[abc='test']").html());
//      alert($("input[type='checkbox']:checked").length);

//      $("input[type='button']:last").click(function(){
//        alert("测试点击");
//      });
//
//      $("input[type='button']:last").click(function(){
//          alert("测试点击1");
//        });

//        $("select:last").change(function(){
//            alert($(this).val());
//        });

//    $("select").hide();
//    $("select:last").show();
//    $("select:last").toggle();

//    $("#s3").append("<option value=\"1\">张三1</option>");
//    $("#s3").append("<option value='2'>张三2</option>");
//    $("#s3").append('<option value="3">张三3</option>');

//    var attr = $("input[type='text']").attr("hello");
//    $("input[type='text']").attr("hello", attr + "!!!!!");
    // 某些时候，可以把某个标签元素看做是map集合，属性名-属性值就是kv
//    $("input[type='text']").attr("hello123", attr + "!!!!!");
//    alert(attr);

//    alert($("#s3").text()); // 得到标签下的所有文本内容，不包括html标签
//    alert($("#s3").html()); // 得到标签下的所有内容，包括html标签

//    $("div:first").html('<input type="file">'); // 给标签元素设置内容，html标签会被解析
//    $("div:first").text('<input type="file">'); // 给标签元素设置文本内容，html标签作为普通字符串

//    alert($("input[type='text']").val()); // 获取表单元素值
//    $("input[type='text']:first").val("张三"); // 设置表单元素值

//    $("select:first").val(3); // 通过给下拉列表设置值的方式，设置选中的选项


//    alert($("input:eq(1)").val());
//    alert($("#tab0").find("tr").eq(1).find("td").eq(1).html());

//    $("#tab0 td").filter(function(){
//        if($(this).html() == "男"){
//            $(this).html("男123");
//        }
//    });

//    $("#tab0 td").filter("[abc='test']").html("李四1234");

//    var arr = ["a", 1, "b", 2];
//
//    $.each(arr, function(index, value){
//        alert(index + "  " + value);
//    });

    /*
    kv，
    {}一个json对象
    []一个json数组
    */
    var person = {
        "name" : "张三",
        "age" : 12,
        "sex" : "男",
        "school" : {
            "name" : "第1中学",
            "addr" : "xxx大街xxx号"
        },
        "family" : [
            {},
            {}
        ]
    };

//    alert(person.name + " " + person["age"]);
//    alert(person.school.name);

    $.each(person, function(k, v){
        alert(k + " : " + v);
    });

}

// 这个是最常用的函数声明方式
var test2 = function(){
    $("#h0").html("12222334444");
}

var test3 = function(){
    alert($("select").val());
}

var ajaxDemo = function(){
    $.ajax({
        type : "post",
        url : "test/demo2",
        data : {
            "name" : "李四",
            "age" : 14
        },
//        dataType : "json",
        success : function(data) {// 后端的返回值
            alert(data);
        }
    });
}
var m = 120;
var s = 0;

var myTimmer = setInterval(function(){
    if(s < 10){
     //如果秒数少于10在前面加上0
        $('#timespan').html(m+' 分 0'+s+' 秒');
    }else{
        $('#timespan').html(m+' 分 '+s+' 秒');
    }
    s--;
    if(s < 0){
     //如果秒数少于0就变成59秒
        s = 59;
        m--;
        if(m < 0){
          $('#timespan').html('0 分 00 秒');
          $('#sub-test').attr("disabled",true);
          // todo 调用交卷的函数
          clearInterval(myTimmer);
        }
    }
},1000);

myTimmer();
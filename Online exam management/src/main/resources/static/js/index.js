// 加载页面之后自动执行的js
$(function(){
    loadHtml("header.html", "header"); // 向index.html的id为header的块中加载header.html
    loadHtml("footer.html", "footer"); // 向index.html的id为footer的块中加载footer.html
    loadHtml("left-menu.html", "left-menu"); // 向index.html的id为left-menu的块中加载left-menu.html
    loadHtml("welcome.html", "content"); // 向index.html的id为content的块中加载welcome.html
});
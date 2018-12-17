 // 手动进行初始化
(function($, window, undefined) {
    window.scrollTo(0,0);
    $('#myPager').pager({
        linkCreator: function(page, pager) {
            // alert(window.location.href);
            // alert("1");
            var url = window.location.href;
            url = url.split("#")[0];
            // alert(url+'#page='+ page +'?page=' + page);
            return url+'#page='+ page +'?page=' + page;
        } 
    });
}(jQuery))
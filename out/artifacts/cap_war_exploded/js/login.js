function getContextPath() {
    var contextPath = document.location.pathname;
    var index = contextPath.substr(1).indexOf("/");
    contextPath = contextPath.substr(0, index + 1);
    delete index;
    return contextPath;
}
layui.define(['element'],function(exports){
    var $ = layui.$;
    $('.input-field').on('change',function(){
        var $this = $(this),
            value = $.trim($this.val()),
            $parent = $this.parent();

        if(value !== '' && !$parent.hasClass('field-focus')){
            $parent.addClass('field-focus');
        }else{
            $parent.removeClass('field-focus');
        }
    })
    exports('login');
});
layui.use(['form','jquery','layer'],function(){
    var form  = layui.form,
        $ = layui.$,
        layer = layui.layer;
    form.on('submit(submitBtn)',function(obj){
        $.ajax({
            url:getContextPath()+'/LoginServlet/login',
            type:'POST',
            data:$(".usertext").serialize(), // 取得表单的所有数据内
            success:function(data){
                // alert(data);
                if(data =="success"){//
                    layer.msg('User Login Success',{time:2000,icon:1,end:function(){
                        location.href=getContextPath()+"/pages/back/index.jsp";
                        }})
                }else if (data == "lock") {
                    layer.msg('User Login Lock',{time:2000,icon:2})
                }else{
                    layer.msg('User Login Error',{time:2000,icon:2})
                }
            }
        });
    });
})
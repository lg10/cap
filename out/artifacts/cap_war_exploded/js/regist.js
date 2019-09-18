function getContextPath() {
    var contextPath = document.location.pathname;
    var index = contextPath.substr(1).indexOf("/");
    contextPath = contextPath.substr(0, index + 1);
    delete index;
    return contextPath;
}

layui.use(['form','jquery','layer'],function (){
    var form = layui.form,
        $ = layui.$,
        layer = layui.layer;
    form.on('submit(submitBtn)',function (obj) {
        $.ajax({
            url: getContextPath() + '/LoginServlet/Register',
            type: 'POST',
            data: $('.layui-form').serialize(),//��ȡ������
            success: function (data) {
                if (data == "success") {
                    layer.msg('Register Success', {
                        time: 2000, icon: 1, end: function () {
                            location.reload();
                        }
                    })
                } else {
                    layer.msg('Error��', {
                        time: 2000, icon: 2, end: function () {
                            location.reload();
                        }
                    })
                }
            }

        })
    })
})
layui.define(['element'], function (exports) {


    exports('login');


});
$('.input-field').on('change', function () {
    var $this = $(this),
        value = $.trim($this.val()),
        $parent = $this.parent();
    if (value == '') {
        $parent.removeClass('field-focus');
    } else {
        if (!$parent.hasClass('field-focus')) {
            $parent.addClass('field-focus');
        }
    }
})

layui.use(['form'], function () {
    var form = layui.form;
    var $ = layui.$;
    form.on('submit(login)', function (data) {
        var username = $('#username').val();
        var password = $('#password').val();
        var loginInfo = {username: username, password: password}
        Data_POST(USER_LOGIN, loginInfo, function (data) {
            $('#password').val("");
            $('#username').val("");
            if (isSuccess(data)) {
                //传递cookie
                sessionStorage.setItem('loginName', data.data.loginName);
                window.location.href = "index.html"
            } else {
                layer.msg(data.msg);
            }
        })

        return false;
    });

});
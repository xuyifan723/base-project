layui.define(['element'], function (exports) {
    var $ = layui.$;
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

    exports('login');


});

layui.use(['form',], function () {
    var form = layui.form;
    var $ = layui.$;
    form.on('submit(login)', function (data) {
        var username = $('#username').val();
        var password = $('#password').val();
        var loginInfo = {username: username, password: password}
        Data_GET(USER_LOGIN, loginInfo, function (data) {
            if (isSuccess(data)) {
                //传递cookie
                setCookie('userName', loginInfo.username, 7)
                setCookie('password', loginInfo.password, 7);
                window.location.href = "index.html"
            } else {
                layer.msg(data.msg);
            }
        })

        return false;
    });

});
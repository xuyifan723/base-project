layui.define(['element', 'jquery', 'layer'], function (exports) { //提示：模块也可以依赖其它模块，如：layui.define('layer', callback);
    var el = layui.element;
    var $ = layui.$;
    var layer = layui.layer;
    function getUrl(url,params) {
        var flag=false;
       if (url.indexOf('?')<0){
           flag=true;
       }
        for (var key in params) {
           if (flag){
               url+="?"
               flag=false;
           }else {
               url+="&"
           }
            url=url+key+"="+params[key]
        }
        return url;
    }




    var obj ={
        success:2000,
        edit:'edit',
        add:'add',
        view:'view',
        //获取list数据
        handleListData:function (res) {
            var code = 0;
            var count = 0;
            var data = [];
            if (res.code != 2000) {
                layer.msg(res.msg, {
                    time: 10000, //20s后自动关闭
                    btn: ['知道']
                });
            } else {
                count = res.count;
                data = res.data;
            }
            return {
                "code": code, //解析接口状态
                "msg": "", //解析提示文本
                "count": count, //解析数据长度
                "data": data //解析数据列表
            };
        },
        //通过post的接口调用数据
        post:function (url,data) {
            var result;
            $.ajax({
                type: 'POST',
                contentType: "application/json;charset=UTF-8",
                url: url,
                async: false,
                data: JSON.stringify(data),
                dataType: "JSON",
                success:function (res) {
                    result=res;
                }
            });
            return result;
        },
        //通过get方法参数为
        HandleData:function (url,params) {
            var result;
            $.ajax({
                type: 'GET',
                contentType: "application/json;charset=UTF-8",
                url:getUrl(url,params),
                async: false,
                dataType: "JSON",
                success:function (res) {
                    result=res;
                }
            });
            return result;
        },
        getParamValue:function (param){
        var query = window.location.search.substring(1);
        var vars = query.split("&");
        for (var i=0;i<vars.length;i++) {
            var pair = vars[i].split("=");
            if(pair[0] == param){return pair[1];}
        }
        return(false);
    }






    }


    //输出test接口
    exports('layuiCommon', obj);
});
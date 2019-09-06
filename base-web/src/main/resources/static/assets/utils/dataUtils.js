var ERROR_CODE=5000;
var SUCCESS_CODE=2000;
function isSuccess(data) {
    if (data.code==2000){
        return true;
    }else {
        return false;
    }
}
var new_element=document.createElement("script");
new_element.setAttribute("type","text/javascript");
new_element.setAttribute("src","/data_manager/assets/utils/Apiservice.js");
document.body.appendChild(new_element);
var userTokenName='authCode';
function Data_POST(url,params,func){
    $.ajax({
        type:"post",
        url:url,
        contentType:'application/json',
        headers:{'authCode': sessionStorage.getItem(userTokenName)},
        data:JSON.stringify(params),
        dataType:"json",
        success:function (data, textStatus, request) {
           var code = request.getResponseHeader(userTokenName);
            sessionStorage.setItem(userTokenName,code);
           func(data)
        },
        error:function (XMLHttpRequest, textStatus, errorThrown) {
            alert("请求失败！");
        }
    });
}
function Data_GET(url,params,func){
    var paramsName = Object.keys(params);
    if (url.search("\\?") != -1) {
        params.forEach(function (item) {
            url+=("&"+item+"="+params[item])
        })
    }else {
        var flag=true;
        paramsName.forEach(function (item) {
            if (flag){
                url+=("?"+item+"="+params[item])
                flag=false;
            }else {
                url += ("&" + item + "=" + params[item])
            }
        })
    }
    $.ajax({
        type:"get",
        url:url,
        dataType:"json",
        headers:{'authCode':  sessionStorage.getItem(userTokenName)},
        success:function (data, textStatus, request){
            var code = request.getResponseHeader(userTokenName);
            sessionStorage.setItem(userTokenName,code);
            func(data)
        },
        error:function (XMLHttpRequest, textStatus, errorThrown) {
            alert("请求失败！");
        }
    });
}

//设置cookie
var setCookie = function (name, value, min) {
    //分钟
    //当设置的时间等于0时，不设置expires属性，cookie在浏览器关闭后删除
    var expires = min  * 60 * 1000;
    var exp = new Date();
    exp.setTime(exp.getTime() + expires);
    document.cookie = name + "=" + value + ";expires=" + exp.toUTCString();
};
//删除cookie
var delCookie = function (name) {
    setCookie(name, ' ', -1);
};

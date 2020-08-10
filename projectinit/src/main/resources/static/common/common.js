
function handleData(res) {
    var code=0;
    var count=0;
    var data=[];
    if (res.code!=2000){
        layer.msg(res.msg, {
            time: 10000, //20s后自动关闭
            btn: ['知道']
        });
    }else {
        count=10000;
        data=res.data;
    }
    return {
        "code": code, //解析接口状态
        "msg": "", //解析提示文本
        "count": count, //解析数据长度
        "data": data //解析数据列表
    };
}
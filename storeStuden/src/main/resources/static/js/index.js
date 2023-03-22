var hotListUrl="/products/hotList";
var v;
$(function (){
    v = new Vue({
        el:"#hot",
        data:{
            hots:[]
        }
    })
    listHot()
})

function listHot(){
    $.get(hotListUrl,function (result){
        if (result.state=1000){
            v.hots = result.data
        }else {
            alert(result.msg)
        }
    })
}
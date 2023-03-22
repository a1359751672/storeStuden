$(function () {
//    获取地址信息
    var path = window.location.href;
    var index = path.lastIndexOf("?")
    var id;
    if (index!=1){
        var params = path.substring(index+1) //获取参数信息
    //    获取多个参数信息
        var array = params.split("&")
        if (array[0].startsWith("id=")){
            id = array[0].split("=")[1]
        }
        var productUrl = "../products/"+id+"/get"
        $.get(productUrl,function (result){
            if (result.state == 1000){
                new Vue({
                    el:"#product-detail",
                    data:result.data
                })
                initButton();
                initCartButton(id);
            }else {
                alert(result.msg)
            }
        })
    }
})

function initButton(){
    /*商品小图片加鼠标移入加边框、移出移除边框*/
    $(".img-small").hover(function() {
            $(this).css("border", "1px solid #4288c3");
        },
        function() {
            $(this).css("border", "");
        })
    //点击时变化大图片
    $(".img-small").click(function() {
        //获得点击的小图片数据
        var n = $(this).attr("data");
        //所有大图隐藏
        $(".img-big").hide();
        //显示点击的小图对应的大图
        $(".img-big[data='" + n + "']").show();
    })
    //购物数量加1
    $("#numUp").click(function() {
        var n = parseInt($("#num").val());
        $("#num").val(n + 1);
    })
    //购物数量-1
    $("#numDown").click(function() {
        var n = parseInt($("#num").val());
        if (n == 1) {
            return;
        }
        $("#num").val(n - 1);
    })
    // //点购物车跳页面
    // $(".go-cart").click(function() {
    //     location.href = "cart.html";
    // });
    $(".img-big:eq(0)").show();
}

function initCartButton(product_id){
    var addCart = "/carts/create"
    $("#addCart").click(function (){
        var num = $("#num").val(); //获取数量
        var params= {
            productId:product_id,
            num:num,
        }
        $.post(addCart,params,function (result){
            if (result.state=1000){
                alert("成功添加到购物车")
            }else {
                alert(result.msg)
            }
        })
    })
}
var modifiedAddressUrl="/address/update"
var districtUrl="/districts/"

//页面加载事件
$(function () {
    //发送请求获取省级信息
    addDistrict("86","province-list")
    //当选中省级信息时根据省级编号查询市级信息
    $("province-list").change(function () {
        var code = $("#province-list").val();
        addDistrict(code,"city-list")
    })
    //当选中市级信息时根据市级编号查询区域信息
    $("city-list").change(function () {
        var code = $("#city-list").val();
        addDistrict(code,"area-list")
    })
    let id = location.search.split("=")[1];
    // //获取表单数据
    // var name = $("#name").val();
    // var provinceList=$("#province-list");
    // var cityList=$("#city-list");
    // var areaLsit=$("#area-list");
    // var zip = $("#zip");
    // var address = $("#address");
    // var phone = $("#phone");
    // var tel = $("#tel");
    // var tag = $("#tag");
    //为提交按钮添加点击事件
    $("#btnSubmit").click(function () {
        var params = $("#addAddressForm").serialize()
        var Did={
            id:id,
        }
        $.post(modifiedAddressUrl,params,function (result) {
            if (result.state==1000){
                alert("地址修改成功！")
                window.location.href="address.html"
            }else{
                alert(result.msg)
            }
        })
    })
    })


//定义请求获取子级信息的方法
function addDistrict(parent,sid) {
    $.post(districtUrl,parent,function (result) {
        if (result.state==1000){
            var list = result.data;
            for(var i=0;i<list.length;i++){
                var option = "<option value='"+list[i].code+"'>"+list[i].name+"</option>"
                $("#"+sid).append(option)
            }
        }else{
            alert(result.msg)
        }
    })
}

var districtUrl="/districts/"
var addAddressUrl="/address/createAddress"
//页面加载事件
$(function () {
    var defaultOption = "<option value='0'>----请选择----</option>"
    //为三个选择框添加默认选项
    $("#province-list").append(defaultOption)
    $("#city-list").append(defaultOption)
    $("#area-list").append(defaultOption)
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
    //为提交按钮添加点击事件
    $("#btnSubmit").click(function () {
        var params = $("#addAddressForm").serialize()
        console.log(params);
        $.post(addAddressUrl,params,function (result) {
            if (result.state == 1000){
                alert("地址添加成功！")
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

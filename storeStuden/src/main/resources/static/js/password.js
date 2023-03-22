var modifyPasswordUrl="/users/modifyPassword"
$(function (){
//    添加失去焦点事件
    //    为老密码输入框添加失去焦点事件
    $("#oldPassword").blur(function (){
        checkEmpty("oldPassword","原密码不能为空")
    })
    //    为新密码输入框添加失去焦点事件
    $("#newPassword").blur(function (){
        checkOldPwd("oldPassword","newPassword","原密码与新密码不能一致")
    })
    //    为重复密码输入框添加失去焦点事件
    $("#rePassword").blur(function (){
        checkRePwd("newPassword","rePassword","确认密码与新密码应该一致")
    })

    //为提交按钮添加点击事件
    $("#btn-Submit").click(function () {
        //    获取表单数据
        var oldPassword = $("#oldPassword").val();
        var newPassword = $("#newPassword").val();
        var rePassword = $("#rePassword").val();

        //    判断页面中的input是否都进行了验证
        var divArr = $("div.has-success");
        if (divArr.length != 3){
            return;
        }
        //    提交表单
        var params = { //提交参数，请求参数属性名=属性值（属性名需和后端一致）
            oldPassword:oldPassword,
            newPassword:newPassword,
            rePassword:rePassword,
        }
        //    发送AJAX请求
        $.post(modifyPasswordUrl,params,function (result) {
            //    处理相应数据
            if (result.state == 1000){ //相应成功状态
                alert("修改密码成功");
                //清空表单数据
                $("#newPassword").val("");
                $("#rePassword").val("");
            }else {
                alert(result.msg)
            }
        })
    })
})
//    定义验证是否为空方法
function checkEmpty(name,msg){
    if ($("#"+name).val() ==""){
        $("#"+name).parents(".form-group").addClass("has-error").removeClass("has-success");
        //    给span标签添加错误提示信息
        $("#"+name).next("span").text(msg);
        return false;
    }else {
        $("#"+name).parents(".form-group").removeClass("has-error").addClass("has-success");
        //
        $("#"+name).next("span").text("");
        return true;
    }
}
//    定义是否一致
function checkRePwd(name1,name2,msg){
    if ($("#"+name1).val() !=$("#"+name2).val()){
        $("#"+name2).parents(".form-group").addClass("has-error").removeClass("has-success");
        //    给span标签添加错误提示信息
        $("#"+name2).next("span").text(msg);
        return false;
    }else {
        $("#"+name2).parents(".form-group").removeClass("has-error").addClass("has-success");
        //
        $("#"+name2).next("span").text("");
        return true;
    }
}
//    定义是否不一致
function checkOldPwd(name1,name2,msg){
    if ($("#"+name1).val() ==$("#"+name2).val()){
        $("#"+name2).parents(".form-group").addClass("has-error").removeClass("has-success");
        //    给span标签添加错误提示信息
        $("#"+name2).next("span").text(msg);
        return false;
    }else {
        $("#"+name2).parents(".form-group").removeClass("has-error").addClass("has-success");
        //
        $("#"+name2).next("span").text("");
        return true;
    }
}
var template = "<tr>" +
    "<td>[tag]</td>" +
    "<td>[name]</td>" +
    "<td>[provinceName][cityName][areaName][address]</td>" +
    "<td>[phone]</td>" +
    "<td><a aid='[aid]'  id='modifiedContent' href='modifiedAddress.html?id=[aid]' class='btn btn-xs btn-info'><span class='fa fa-edit'></span> 修改</a></td>" +
    "<td><a aid='[aid]' class='btn btn-xs add-del btn-info btn-delete'><span class='fa fa-trash-o'></span> 删除</a></td>" +
    "<td><a aid='[aid]' class='btn btn-xs add-def btn-default'>设为默认</a></td>" +
    "</tr>"
var addressUrl ="/address/list"
var deleteUrl ="/address/remove"
$(function (){
    listAddress();
})

//查询用户地址信息
function  listAddress(){
    $.get(addressUrl,function (result){
        if (result.state==1000){
            for (var index in result.data){
                var addr = result.data[index]
                var td = template.replace("[tag]",addr.tag)
                    .replace("[name]",addr.name)
                    .replace("[provinceName]",addr.provinceName)
                    .replace("[cityName]",addr.cityName)
                    .replace("[areaName]",addr.areaName)
                    .replace("[address]",addr.address)
                    .replace("[phone]",addr.phone)
                    .replace(/\[aid\]/g,addr.id)
                var tobj = $(td)
                var btnDefault = tobj.find(".btn-default")
                if (addr.isDefault == 1){
                    btnDefault.remove()
                }
                $("#tbody").append(tobj)
            }
        }else {
            alert(result.msg)
        }
        //为删除按钮添加点击事件
        $(".btn-delete").bind("click",function (){
            var flag = confirm("确定要删除此地址吗?")
            if (flag == false){
                return
            }
//    获取地址id
            var id= $(this).attr("aid");
            params={
                id:id,
            }
//    发送请求
            $.post(deleteUrl,params,function (result){
                if (result.state == 1000){
                    alert("删除成功")
                    window.location.reload();
                }else {
                    alert(result.msg)
                }
            })
        })
        // function changid(id){
        //     //    点击修改按钮事件
        //     $("#modifiedContent").bind("click",params,function () {
        //         if (confirm("确认修改地址吗？")) {
        //             location.href = "modifiedAddress.html?id=" +id;
        //         }
        //     })
        // }

    })
}





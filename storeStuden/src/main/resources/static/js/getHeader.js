var checkLoginUrl = "/users/findUserInfo"
var headerSubPagePath = ""
var userData;

$.get(checkLoginUrl,function (result){
    if (result.state == 2004){
        headerSubPagePath="topTemplate_notLoggedIn.html"
    }else {
        headerSubPagePath="topTemplate_loggedIn.html"
        userData = result.data;
    }
    $("#header").load(headerSubPagePath,function (){
        if (userData!=undefined){
            username = userData.username;
            if (username!=undefined){
                if (username.length>6){
                    username = username.substring(0,6)+"..."
                }
            }
            $("#username").html(username)
        }
    //    显示头像

    })
})

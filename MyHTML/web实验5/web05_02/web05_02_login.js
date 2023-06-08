// 登录

document.querySelector("input[type='submit']").onclick = function () {
    var usernameVal = document.getElementById("username").value;
    var passwordVal = document.getElementById("password").value;
    if (usernameVal === "root" && passwordVal === "123456") {
        alert("hello world !");
    }
    else {
        alert("username or password is incorrect !!");
    }
}

// 复选与禁用

var isAgree = document.querySelectorAll("input[type='checkbox']");
var submitButton = document.querySelector("input[type='submit']");

function showDisabled() {
    for (let i = 0; i < isAgree.length; i++) {
        if(isAgree[i].checked == false) {
            submitButton.disabled = true;
            return;
        }
    }
    submitButton.disabled = false;
}

for (let i = 0; i < isAgree.length; i++) {
    isAgree[i].addEventListener("change", showDisabled);
}

// 页面跳转

document.querySelector("#enrollInterface").onclick = function () {
    window.location.href = "web05_02_enroll.html";
}




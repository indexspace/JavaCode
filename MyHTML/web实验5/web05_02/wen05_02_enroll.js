// 注册

document.querySelector("input[type='submit']").onclick = function () {
    var usernameVal = document.getElementById("username").value;
    var passwordVal = document.getElementById("password").value;
    var passwordAgainVal = document.getElementById("passwordAgain").value;
    if (passwordVal === passwordAgainVal && usernameVal !== "root") {
        alert("hello world !");
    }
    else if (usernameVal === "root") {
        alert("The account is already registered");
    }
    else if (passwordVal !== passwordAgainVal) {
        alert("The passwords entered twice do not match");
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

document.querySelector("#loginInterface").onclick = function () {
    window.location.href = "web05_02_login.html";
}
document.getElementById("submitButton").onclick = function () {
    var usernameVal = document.getElementById("username").value;
    var passwordVal = document.getElementById("password").value;
    if (usernameVal === "root" && passwordVal === "123456") {
        window.location.href = "introduce.html";
    }
    else {
        alert("username or password is incorrect !!");
    }
}
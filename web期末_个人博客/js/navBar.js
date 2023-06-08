var timer = document.getElementById("timer");

var showTime = function () {
    var nowTime = new Date();
    var month = nowTime.getMonth() + 1;
    var day = nowTime.getDate();
    var hour = nowTime.getHours();
    var minute = nowTime.getMinutes();
    var second = nowTime.getSeconds();
    timer.innerText = month + "月" + day + "日 " + hour + ":" + minute + ":" + second;
}
showTime();
setInterval(showTime, 1000);

document.getElementsByName("index")[0].onclick = function() {
    window.location.href="index.html";
}

document.getElementsByName("introduce")[0].onclick = function() {
    window.location.href="introduce.html";
}

document.getElementsByName("notes")[0].onclick = function() {
    window.location.href="notes.html";
}

document.getElementsByName("login")[0].onclick = function() {
    window.location.href="login.html";
}
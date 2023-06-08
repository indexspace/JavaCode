var buttonList = document.querySelectorAll("button");

for (var i = 0; i < buttonList.length; i++) {
    buttonList[i].onclick = function () {
        prompt("请输入你的支付密码","******");
    }
}

var deadline = new Date(2023, 5, 18, 23, 59, 59);
var timeNote = document.getElementById("time");

setInterval(function () {
    var timeDiff = deadline - new Date();
    timeDiff = parseInt(timeDiff / 1000);
    var sec = timeDiff % 60;
    timeDiff = parseInt(timeDiff / 60);
    var min = timeDiff % 60;
    timeDiff = parseInt(timeDiff / 60);
    var hour = timeDiff % 24;
    timeDiff = parseInt(timeDiff / 24);
    var day = timeDiff;
    timeNote.innerHTML = day + "日 " + hour + "时 " + min + "分 " + sec + "秒 ";
}, 1000);
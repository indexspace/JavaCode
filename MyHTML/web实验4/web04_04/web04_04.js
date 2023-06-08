var nameInput = document.querySelector("input[name='name']");
var passInput = document.querySelector("input[name='pass']");
var allHobby = document.querySelector("input[name='allhobby']");
var hobbyList = document.querySelectorAll("input[name='hobby']");
var submitButton = document.querySelector("input[name='submit']");

nameInput.onblur = function() {
    if (nameInput.value == "") {
        var pNote1 = document.createElement("p");
        pNote1.appendChild(document.createTextNode("用户名不能为空"));
        pNote1.style.color = "red";
        document.getElementById("nameNote").appendChild(pNote1);
    }
}

passInput.onblur = function() {
    if (passInput.value == "") {
        var pNote2 = document.createElement("p");
        pNote2.appendChild(document.createTextNode("密码不能为空"));
        pNote2.style.color = "red";
        document.getElementById("passNote").appendChild(pNote2);
    }
    if (passInput.value.length<8 || 12<passInput.value.length) {
        var pNote3 = document.createElement("p");
        pNote3.appendChild(document.createTextNode("密码应该在8~12位之间"));
        pNote3.style.color = "red";
        document.getElementById("passNote").appendChild(pNote3);
    }
}

allHobby.onchange = function() {
    for (var i=0; i < hobbyList.length; i++) {
        hobbyList[i].checked = this.checked;
    }
}

submitButton.onclick = function() {
    if(nameInput.value == "" || passInput.value == "") {
        alert("用户名或密码不能为空");
    }
    else {
        alert("提交成功");
    }
}


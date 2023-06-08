var lis = document.querySelectorAll("ul.tab li");
var box = document.querySelector("div#imgbox img");

for (var i = 0; i < lis.length; i++) {
    lis[i].setAttribute("index", i+1);
    lis[i].onclick = function() {
        box.src = "img/panda" + this.getAttribute("index") + ".jpg";
    }
}
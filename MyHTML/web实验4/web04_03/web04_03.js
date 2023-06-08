var element = document.querySelector("div#content");

document.querySelector("select#bgSelector").onchange = function(){
    element.style.backgroundColor = this.value;
}

document.querySelector("select#txtSelector").onchange = function(){
    element.style.color = this.value;
}

document.querySelector("select#fontSelector").onchange = function(){
    element.style.fontFamily = this.value;
}
var grades = prompt("请输入成绩(0~100):","");
var evaluation;
if (90<=grades && grades<=100){
    evaluation = "优秀";
}
else if (80<=grades && grades<90){
    evaluation = "良好";
}
else if (70<=grades && grades<80){
    evaluation = "中等";
}
else if (60<=grades && grades<70){
    evaluation = "及格";
}
else if (0<=grades && grades<60){
    evaluation = "不及格";
}
else{
    evaluation = "错误!!!";
}
alert(evaluation);

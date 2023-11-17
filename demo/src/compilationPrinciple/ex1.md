# 任务描述
本关任务：加深对词法分析器的工作过程的理解；加强对词法分析方法的掌握；能够采用一种编程语言实现简单的词法分析程序；能够使用自己编写的分析程序对简单的程序段进行词法分析。

# 相关知识
为了完成本关任务，你需要掌握：**词法分析**程序设计与实现。

## 词法分析的基本知识
词法分析程序( Lexical analyzer，简称 Lexer )，负责从左到右逐个字符地对源程序进行扫描和分解，根据语言的词法规则识别出一个个的单词符号。

因此一个词法分析程序应具备如下功能：

从左至右扫描构成源程序的字符流

识别出有词法意义的单词

返回单词记录，或词法错误信息

由上可知词法分析中的一个重要环节为识别单词符号类型，为了便于语法分析，通常将单词符号分为五类。

+ 标识符
用来命名程序中出现的变量、数组、函数、过程、标号等，通常是一个字母开头的字母数字串，如 length，nextch 等。

+ 基本字
也可以成为关键字或保留字。如 if，while，for，do，goto 等。他们具有标识符的形式，但他们不是由用户而是由语言定义的，其意义是约定的。多数语言中规定，他们不能作为标识符或者标识符的前缀，即用户不能使用它们来定义用户使用的名字，故我们称它为保留字，这些语言如 Pascal 和 C 等。但也有的语言允许将基本字作为标识符或者标识符的前缀，这类语言如 Fortran 等。

+ 常数
包括各种类型的常数，如整型、实型、字符型、布尔型等。如：5、3.1415926、a、TRUE等都是常数。

+ 运算符
算术运算符+、-、×、÷；关系运算符<,<=,>,>=,==,!=以及逻辑运算符&&，()，||或者!等。

+ 界符
如`，`、`；`等单字界符和`/`,`/`,`//`等双字界符，空白符等。

在进行词法分析后，识别出来的单词应该采用某种中间表示形式，以便为编译后续阶段方便地引用。通常一个单词用一个二元式来表示：
（单词类别，单词的属性）
其中，第一元用于区分单词所属的类别，以整数编码表示。第二元用于区分该类别中的哪一个单词符号，即单词符号的值。

## 实验步骤
由一个词法分析程序应具备的功能来看，我们的程序具有如下要求：

对单词的构词规则有明确的定义；
编写的分析程序能够正确识别源程序中的单词符号；
识别出的单词以<种别码，值>的形式保存在符号表中，正确设计和维护符号表；
对于源程序中的词法错误，能够做出简单的错误处理，给出简单的错误提示，保证顺利完成整个源程序的词法分析；
下面我们进行实验代码的步骤分析。

1. 定义目标语言的可用符号表和构词规则。
我们需要对五种单词符号进行识别分析，这里将单词符号分为三大块进行识别。首先判断字符是否为关键字或者标识符，并与已定义好的关键字进行比较，从而判断为关键字或者标识符；然后是数字的识别；最后是其他字符的判断，它们被一一定义好的判断进行识别，这样所有的字符便被识别出来了。标示符和关键字的判断
```java
     String token= String.valueOf(str.charAt(p++));
     char ch;
     for (;p<str.length();p++){
         ch=str.charAt(p);
         if (!Character.isLetterOrDigit(ch)&&ch!='_'){
             break;
         }else{
             token+=ch;
         }
     }  //可能是标示符或者关键字 
```
字符与关键字的区别通过对比得出：
```java
         if (keyWords.contains(token)){
         System.out.println("("+1+","+token+")");
     }else {
         System.out.println("("+2+","+token+")");
     }
```
对于数字的识别：
```java
     String token= String.valueOf(str.charAt(p++));
     int flag=0;
     boolean err=false;
     char ch;
     for (;p<str.length();p++) {
         ch = str.charAt(p);
         if (ch==' '||(!Character.isLetterOrDigit(ch)&&ch!='.')) {
             break;
         }else if (err){
             token+=ch;
         }
         else {
             token+=ch;
             if (ch == '.') {
                 if (flag == 1) {
                     err = true;
                 } else {
                     flag++;
                 }
             }else if (Character.isLetter(ch)){
                 err=true;
             }
         }
     } 
```
其他字符的识别,可以根据初始化中，对他们的定义一一比对进行识别。

2. 依次读入源程序符号，对源程序进行单词切分和识别，直到源程序结束。
字符的输入我们使用读取文件逐行进行获取：
```java
     init();
     File file=new File("/data/workspace/myshixun/input.txt");
     lines=1;
     try(Scanner input=new Scanner(file)) {
         while (input.hasNextLine()){
             String str=input.nextLine();
             analyze(str);
             lines++;
         }
     } 
```
3. 对正确的单词，按照它的种别以<种别码，值>的形式保存在符号表中；

4. 对不正确的单词，做出错误处理。
单词识别后，我们对返回的符号按3，4的规则进行输出，此处以识别常数为例：
```java
     if (err){
         System.out.println(lines+"line"+": "+token+" is wrong");
     }else {
         System.out.println("("+3+","+token+")");
```
# 编程要求
根据提示，在右侧编辑器Beign和End 之间依次补充标示符关键字 letterCheck、数字符digitCheck及其他字符符号symbolCheck的识别程序，点击评测,运行程序，系统会自动进行结果对比。

## 测试说明
平台会对你编写的代码进行测试：

测试输入：
```java
public class Hello{
public static void main(String args[]){
System.out.println("Hello World");
}
}
```
开始你的任务吧，祝你成功！
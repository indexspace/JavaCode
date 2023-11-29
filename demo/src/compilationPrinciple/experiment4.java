package compilationPrinciple;

import java.util.ArrayList;
import java.util.Scanner;

public class experiment4 {
    public static final char[] T = { '+', '*', '^', 'i', '(', ')', '#' }; // 终结符
    public static int sizeOfTerminal = T.length; // 终结符的数目
    public static final char[] N = { 'E', 'T', 'F', 'P' }; // 非终结符
    public static int sizeOfNotTerminal = N.length; // 非终结符的数目
    public static String previousGrammar; // 前一个候选式
    public static String backGrammar; // 后一个候选式
    public static ArrayList normativeGrammar; // 存放规范文法的列表
    public static int sizeOfGrammar; // 文法的大小
    public static String inputString; // 用户输入的要分析的串
    public static int lengthOfInputString; // 输入串的长度
    public static Character[] stack = new Character[100]; // 存储终结符合非终结符的分析栈
    public static boolean[][] firstvt; // 存储FIRSTVT的二维数组
    public static boolean[][] lastvt; // 存储LASTVT的二维数组
    public static Character[][] priorityTables; // 存放算符优先文法的优先表
    public static int count = 0; // 用于判断步骤
    public static void main(String[] args) {
        getGrammar();
        getFirstVT();
        getPriorityTables();
        getInputString();
        parsingProcess();
    }
    /********Beign********/
    /*构造算符优先表*/
    public static void getPriorityTables() {
        priorityTables = new Character[sizeOfTerminal][sizeOfTerminal];
        for (int m = 0; m < sizeOfGrammar; m++) {
            String string = (String) normativeGrammar.get(m);
            for (int i = 2; i <= string.length() - 2; i++) {
                // 情形1
                if (judgeCharType(string.charAt(i)) == 'T' && judgeCharType(string.charAt(i + 1)) == 'T') {
                    // 首先分别获取这两个字符在终结符数组中的位置-----------
                    int pisition1 = 0, pisition2 = 0;
                    for (; pisition1 < sizeOfTerminal; pisition1++) {
                        if (string.charAt(i) == T[pisition1])
                            break;
                    }
                    for (; pisition2 < sizeOfTerminal; pisition2++) {
                        if (string.charAt(i + 1) == T[pisition2])
                            break;
                    }
                    priorityTables[pisition1][pisition2] = '=';
                }
                // 情形2
                if (i <= string.length() - 3 && judgeCharType(string.charAt(i)) == 'T'
                        && judgeCharType(string.charAt(i + 2)) == 'T' && judgeCharType(string.charAt(i + 1)) == 'N') {
                    // 首先分别获取这两个字符在终结符数组中的位置-----------
                    int pisition1 = 0, pisition2 = 0;
                    for (; pisition1 < sizeOfTerminal; pisition1++) {
                        if (string.charAt(i) == T[pisition1])
                            break;
                    }
                    for (; pisition2 < sizeOfTerminal; pisition2++) {
                        if (string.charAt(i + 2) == T[pisition2])
                            break;
                    }
                    priorityTables[pisition1][pisition2] = '=';
                }
                // 情形3
                if (judgeCharType(string.charAt(i)) == 'T' && judgeCharType(string.charAt(i + 1)) == 'N') {
                    // 首先分别获取非终结符在firstvt中的位置的位置-----------
                    int pisition = 0;
                    for (; pisition < sizeOfNotTerminal; pisition++) {
                        if (string.charAt(i + 1) == N[pisition])
                            break;
                    }
                    // 获取此时的终结符Xi的位置
                    int pisition1 = 0;
                    for (; pisition1 < sizeOfTerminal; pisition1++) {
                        if (string.charAt(i) == T[pisition1])
                            break;
                    }
                    // 再循环firstvt这一行，把所有的true加入
                    for (int j = 0; j < sizeOfTerminal; j++) {
                        if (firstvt[pisition][j]) {
                            priorityTables[pisition1][j] = '<';
                        }
                    }
                }
                // 情形4
                if (judgeCharType(string.charAt(i)) == 'N' && judgeCharType(string.charAt(i + 1)) == 'T') {
                    // 首先分别获取非终结符在firstvt中的位置的位置-----------
                    int pisition = 0;
                    for (; pisition < sizeOfNotTerminal; pisition++) {
                        if (string.charAt(i) == N[pisition])
                            break;
                    }
                    // 获取此时的终结符Xi的位置
                    int pisition1 = 0;
                    for (; pisition1 < sizeOfTerminal; pisition1++) {
                        if (string.charAt(i + 1) == T[pisition1])
                            break;
                    }
                    // 再循环lastvt这一行，把所有的true加入
                    for (int j = 0; j < sizeOfTerminal; j++) {
                        if (lastvt[pisition][j]) {
                            priorityTables[j][pisition1] = '>';
                        }
                    }
                }
            }
        }
        // 最后把有关‘#’号的加上，首先获得‘（’‘）’的位置
        int pisition1 = 0, pisition2 = 0;
        for (; pisition1 < sizeOfTerminal; pisition1++) {
            if ('(' == T[pisition1])
                break;
        }
        for (; pisition2 < sizeOfTerminal; pisition2++) {
            if (')' == T[pisition2])
                break;
        }
        // 所有的除了‘（’以外的都是高于关系
        for (int i = 0; i < sizeOfTerminal; i++) {
            if (i != pisition1)
                priorityTables[i][sizeOfTerminal - 1] = '>';
        }
        // 所有的除了‘）’以外的都是低于关系
        for (int i = 0; i < sizeOfTerminal; i++) {
            if (i != pisition2)
                priorityTables[sizeOfTerminal - 1][i] = '<';
        }
        // 最后 ‘#’‘#’是等于关系
        priorityTables[sizeOfTerminal - 1][sizeOfTerminal - 1] = '>';
    }
    /********End********/

    /********Beign********/
    /*构造firstvt,lastvt*/
    public static void getFirstVT() {
        firstvt = new boolean[sizeOfNotTerminal][sizeOfTerminal]; // 初始化firstvt
        lastvt = new boolean[sizeOfNotTerminal][sizeOfTerminal]; // 初始化lastvt
        for (int i = 0; i < sizeOfNotTerminal; i++) {
            for (int j = 0; j < sizeOfTerminal; j++) {
                firstvt[i][j] = false;
                lastvt[i][j] = false;
            }
        }
        for (int i = 0; i < sizeOfGrammar; i++) { // 情形1
            String string = (String) normativeGrammar.get(i);
            for (int j = 2; j < string.length(); j++) {
                if (judgeCharType(string.charAt(j)) == 'T') {
                    changeState(string.charAt(0), string.charAt(j), firstvt);
                    break;
                }
            }
        }
        for (int i = 0; i < sizeOfGrammar; i++) { // 情形1
            String string = (String) normativeGrammar.get(i);
            for (int j = string.length() - 1; j > 1; j--) {
                if (judgeCharType(string.charAt(j)) == 'T') {
                    changeState(string.charAt(0), string.charAt(j), lastvt);
                    break;
                }
            }
        }
        boolean flag;
        // flag用来判断firstvt内容是否改动，若改动，还需继续循环；反之，不用循环
        do {
            flag = false;
            for (int i = 0; i < sizeOfGrammar; i++) { // 情形2
                String string = (String) normativeGrammar.get(i);
                if (judgeCharType(string.charAt(2)) == 'N' && string.charAt(0) != string.charAt(2)) {
                    // 就要把string.charAt(2)中所有的true加入到string.charAt(0)中
                    // 首先先获得行数----------------------------------------------
                    int rowOfFirst = 0, rowOfSecond = 0;
                    for (; rowOfFirst < sizeOfNotTerminal; rowOfFirst++) {
                        if (string.charAt(0) == N[rowOfFirst])
                            break;
                    }
                    for (; rowOfSecond < sizeOfNotTerminal; rowOfSecond++) {
                        if (string.charAt(2) == N[rowOfSecond])
                            break;
                    }
                    // -----------------------------------------------------------
                    // 然后开始替换----------------------------------
                    for (int j = 0; j < sizeOfTerminal; j++) {
                        if (firstvt[rowOfFirst][j])
                            continue;
                        else {
                            if (firstvt[rowOfSecond][j]) {
                                firstvt[rowOfFirst][j] = true;
                                flag = true;
                            }
                        }
                    }
                    // ----------------------------------------------
                }
            }
        } while (flag);
        boolean flag1;
        // flag1用来判断lastvt内容是否改动，若改动，还需继续循环；反之，不用循环
        do {
            flag1 = false;
            for (int i = 0; i < sizeOfGrammar; i++) { // 情形2
                String string = (String) normativeGrammar.get(i);
                if (judgeCharType(string.charAt(string.length() - 1)) == 'N'
                        && string.charAt(0) != string.charAt(string.length() - 1)) {
                    // 就要把string.charAt(string.length()-1)中所有的true加入到string.charAt(0)中
                    // 首先先获得行数----------------------------------------------
                    int rowOfFirst = 0, rowOfSecond = 0;
                    for (; rowOfFirst < sizeOfNotTerminal; rowOfFirst++) {
                        if (string.charAt(0) == N[rowOfFirst])
                            break;
                    }
                    for (; rowOfSecond < sizeOfNotTerminal; rowOfSecond++) {
                        if (string.charAt(string.length() - 1) == N[rowOfSecond])
                            break;
                    }
                    // -----------------------------------------------------------
                    // 然后开始替换----------------------------------
                    for (int j = 0; j < sizeOfTerminal; j++) {
                        if (lastvt[rowOfFirst][j])
                            continue;
                        else {
                            if (lastvt[rowOfSecond][j]) {
                                lastvt[rowOfFirst][j] = true;
                                flag1 = true;
                            }
                        }
                    }
                    // ----------------------------------------------
                }
            }
        } while (flag1);
    }
    /********End********/
    public static void changeState(char chn, char cht, boolean[][] a) {
        // 根据传过来的非终结符chn和终结符cht修改first的表
        int i = 0, j = 0;
        for (; i < sizeOfNotTerminal; i++) {
            if (chn == N[i])
                break;
        }
        for (; j < sizeOfTerminal; j++) {
            if (cht == T[j])
                break;
        }
        a[i][j] = true;
    }
    public static void getGrammar() {
        // 从控制台读取用户输入的多行文法,并且将文法化为规范文法
        // System.out.println("请输入要分析的文法：");
        // Scanner input = new Scanner(System.in);
        ArrayList <String> list = new ArrayList <String> ();
        // String string = null;
        // while (!(string = input.nextLine()).equals("")) {
        //     list.add(string);
        // }
        list.add("E→E+T|T");
        list.add("T→T*F|F");
        list.add("F→P^F|P");
        list.add("P→(E)|i");
        // 获取规则化的文法
        normativeGrammar = getRegularGrammar(list);
        sizeOfGrammar = normativeGrammar.size();
    }
    public static ArrayList getRegularGrammar(ArrayList list) {
        // 把原来有‘|’号的文法规范成没有‘|’的文法
        // tempList 用来存储临时字符串数组，flag判断是否有‘|’
        ArrayList <String> tempList = new ArrayList <String> ();
        Boolean flag = false;
        // String produceBlaskString = "";
        for (int i = 0; i < list.size(); i++) {
            flag = false;
            String string = (String) list.get(i);
            for (int j = 0; j < string.length(); j++) {
                char ch = string.charAt(j);
                if (ch == '|') {
                    // 获取‘|’前后的两个产生式，j表示‘|’的位置
                    String fixedString = string.substring(0, 2);
                    previousGrammar = fixedString + string.substring(2, j);
                    backGrammar = fixedString + string.substring(j + 1);
                    tempList.add(previousGrammar);
                    tempList.add(backGrammar);
                    flag = true;
                }
            }
            if (!flag)
                tempList.add(string);
        }
        // produceBlack = produceBlaskString.toCharArray();
        return tempList;
    }
    public static String getInputString() {
        // 创建输入对象
        Scanner input = new Scanner(System.in);
        // 获取用户输入的字符串
        // System.out.print("请输入要判断的字符串:");
        inputString = input.nextLine();
        lengthOfInputString = inputString.length();
        return inputString;
    }
    public static void parsingProcess() {
        System.out.printf("%-10s", "步骤");
        System.out.printf("%-10s", "栈");
        System.out.printf("%-10s", "输入串");
        System.out.printf("%-10s", "动作");
        System.out.println();
        // -----------------------控制打印-------------------------------------
        System.out.printf("%-10d", count++);
        System.out.printf("%-10s", '#');
        System.out.printf("%10s", inputString);
        System.out.print("     准备");
        System.out.println();
        // -------------------------------------------------------------
        int k = 1; // k表示符号栈stack的使用深度
        stack[k - 1] = '#';
        int i = 0; // i表示表示当前输入符号的位置
        int j; // j用来往下判断
        char a, Q, R;
        do {
            try {
                a = inputString.charAt(i);
            } catch (Exception e) {
                System.out.println("输入串不合法");
                return;
            }
            if (judgeCharType(stack[k - 1]) == 'T')
                j = k;
            else
                j = k - 1;
            while (j-1>=0&&getPriority(getElement(stack, j - 1), a) == '>') {
                // 当stack[j]的优先级大于a时
                do {
                    Q = getElement(stack, j - 1); // Q = stack[j]
                    // 如果s[j-1]是终结符,j = j - 1
                    if (j - 2 >= 0 && judgeCharType(getElement(stack, j - 2)) == 'T')
                        j = j - 1;
                    else
                        j = j - 2;
                } while (j - 1 >= 0 && getPriority(getElement(stack, j - 1), Q) != '<');
                // -----进行归约-----------
                R = reduct(j + 1, k, i);
                for (int m = j + 1; m <= k; m++) {
                    k--;
                }
                k = j + 1;
                if (k - 1 >= 0) {
                    stack[k - 1] = R;
                }
                // ------------------------
            }
            if(j-1>=0){
                if (getPriority(getElement(stack, j - 1), a) == '<' || getPriority(getElement(stack, j - 1), a) == '=') {
                    k = k + 1;
                    stack[k - 1] = a;
                    i = i + 1; // 表示移进入
                    // -----------------------控制打印--------------------------------------
                    System.out.printf("%-10d", count++);
                    String stringOfStack = "";
                    for (int m = 0; m < k; m++) {
                        stringOfStack = stringOfStack + stack[m];
                    }
                    System.out.printf("%-10s", stringOfStack);
                    System.out.printf("%10s", inputString.substring(i));
                    if (stringOfStack.equals("#E#")) {
                        System.out.print("     接受");
                    } else {
                        System.out.print("     移进");
                    }
                    System.out.println();
                    // -------------------------------------------------------------
                } else {
                    System.out.println("输入串不合法");
                }
            }else if(j-1==-2){
                System.out.printf("%-10d", count++);
                String stringOfStack = "#E#";
                for (int m = 0; m < k; m++) {
                    stringOfStack = stringOfStack + stack[m];
                }
                System.out.printf("%-10s", stringOfStack);
                System.out.printf("%10s", inputString.substring(i));
                if (stringOfStack.equals("#E#")) {
                    System.out.print("     接受");
                } else {
                    System.out.print("     移进");
                }
                System.out.println();
            }
        } while (a != '#');
    }
    public static char judgeCharType(char ch) {
        // 判断ch是否是终止符，如果是终止符，返回'T'；
        // 如果ch不是终止符，再判断是否是非终止符，如果是，则返回'N'；
        // 若都不是，则返回' '，输出“输入串不合法”
        for (int i = 0; i < sizeOfTerminal; i++) {
            if (ch == T[i])
                return 'T';
        }
        for (int i = 0; i < sizeOfNotTerminal; i++) {
            if (ch == N[i])
                return 'N';
        }
        System.out.println("输入串不合法");
        return ' ';
    }
    public static Character getPriority(char c1, char c2) {
        // 先分别用i，j获得终结符cht、非终结符chn的下标
        // 再返回对应分析表中的值
        int i = 0, j = 0;
        for (; i < sizeOfTerminal; i++) {
            if (c1 == T[i])
                break;
        }
        for (; j < sizeOfTerminal; j++) {
            if (c2 == T[j])
                break;
        }
        return priorityTables[i][j];
    }
    public static char getElement(Character[] stack, int position) {
        // 获取栈中任意元素的位置，position表示元素位置，从1开始
        // 由于日常习惯栈中元素个数从1到n
        // 而事实上从0开始，使用的时候要注意在原有的基础上-1
        return stack[position];
    }
    public static Character reduct(int j, int k, int index) {
        Character reduction = ' ';
        if (j == k) {
            // j==k 说明要归约的只有一项
            Character ch = getElement(stack, k - 1);
            for (int i = 0; i < sizeOfGrammar; i++) {
                String string = (String) normativeGrammar.get(i);
                if (string.length() == 3 && string.charAt(2) == ch) {
                    // -----------------------控制打印--------------------------------------
                    System.out.printf("%-10d", count++);
                    String stringOfStack = "";
                    for (int m = 0; m < k; m++) {
                        stringOfStack = stringOfStack + stack[m];
                    }
                    System.out.printf("%-10s", stringOfStack);
                    System.out.printf("%10s", inputString.substring(index));
                    System.out.print("     归约，");
                    System.out.println(string);
                    // -------------------------------------------------------------
                    return string.charAt(0);
                }
            }
        }
        String str = "";
        for (int i = j; i <= k; i++) {
            // System.out.println(i-1);
            if (i - 1 >= 0) {
                Character ch = getElement(stack, i - 1);
                str = str + String.valueOf(ch);
            }
        }
        for (int i = 0; i < sizeOfGrammar; i++) {
            String string = (String) normativeGrammar.get(i);
            if (string.length() > 3) {
                if (str.charAt(1) == string.charAt(3) && str.charAt(1) == '+') {
                    reduction = 'E';
                    // -----------------------控制打印--------------------------------------
                    System.out.printf("%-10d", count++);
                    String stringOfStack = "";
                    for (int m = 0; m < k; m++) {
                        stringOfStack = stringOfStack + stack[m];
                    }
                    System.out.printf("%-10s", stringOfStack);
                    System.out.printf("%10s", inputString.substring(index));
                    System.out.print("     归约，");
                    System.out.println(string);
                    // -------------------------------------------------------------
                } else if (str.charAt(1) == string.charAt(3) && str.charAt(1) == '*') {
                    reduction = 'T';
                    // -----------------------控制打印--------------------------------------
                    System.out.printf("%-10d", count++);
                    String stringOfStack = "";
                    for (int m = 0; m < k; m++) {
                        stringOfStack = stringOfStack + stack[m];
                    }
                    System.out.printf("%-10s", stringOfStack);
                    System.out.printf("%10s", inputString.substring(index));
                    System.out.print("     归约，");
                    System.out.println(string);
                    // -------------------------------------------------------------
                } else if (str.charAt(1) == string.charAt(3) && str.charAt(1) == '^') {
                    reduction = 'F';
                    // -----------------------控制打印--------------------------------------
                    System.out.printf("%-10d", count++);
                    String stringOfStack = "";
                    for (int m = 0; m < k; m++) {
                        stringOfStack = stringOfStack + stack[m];
                    }
                    System.out.printf("%-10s", stringOfStack);
                    System.out.printf("%10s", inputString.substring(index));
                    System.out.print("     归约，");
                    System.out.println(string);
                    // -------------------------------------------------------------
                } else if (str.charAt(0) == string.charAt(2) && str.charAt(1) == '(') {
                    reduction = 'P';
                    // -----------------------控制打印--------------------------------------
                    System.out.printf("%-10d", count++);
                    String stringOfStack = "";
                    for (int m = 0; m < k; m++) {
                        stringOfStack = stringOfStack + stack[m];
                    }
                    System.out.printf("%-10s", stringOfStack);
                    System.out.printf("%10s", inputString.substring(index));
                    System.out.print("     归约，");
                    System.out.println(string);
                    // -------------------------------------------------------------
                }
            }
        }
        return reduction;
    }
}

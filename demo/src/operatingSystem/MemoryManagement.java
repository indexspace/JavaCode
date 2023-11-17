package operatingSystem;

import java.util.Arrays;
import java.util.Scanner;

enum MAlgorithms {
    FIFO, //先进先出
    LRU //最近最久未使用
}

public class MemoryManagement {

    static int PAGE_NUMBER_MAX_SIZE = 1024;

    static Scanner scan = new Scanner(System.in);
    static int[] pageNumber = new int[PAGE_NUMBER_MAX_SIZE];
    static int[] physicalBlock;
    static int[] age;
    static MAlgorithms option;
    static int missPageNumber;
    static int pageNumberSize;

    // input()
    // 键入 页面号 存入数组A
    // 键入 物理块号 作为数组B的size  init-1
    //      分配一个age数组(未缺页可更新可不更新, 看具体算法)
    // 创建算法枚举类, 键入算法选择
    public static void inputAndInit() {
        System.out.print("请输入页面号(-1终止):");
        int index = 0;
        pageNumberSize = 0;
        while (true) {
            int i = scan.nextInt();
            pageNumber[index++] = i;
            if (i == -1) break;
            pageNumberSize++;
        }

        System.out.print("请输入物理块的数量:");
        int size = scan.nextInt();
        physicalBlock = new int[size];
        age = new int[size];
        Arrays.fill(physicalBlock, -1);
        Arrays.fill(age, -1);

    }

    // output()
    // 遍历A:
    //      遍历B,
    //          if(-1)赋值break  if(存在,不用赋值)break,
    //      else 遍历age找出目标索引,赋值(根据算法情况来决定是否需要更新age), 维护缺页数
    //      print()
    public static void computeAndOutput() {
        Arrays.fill(age, -1);
        Arrays.fill(physicalBlock, -1);
        missPageNumber = 0;

        //维护 age && 缺页数
        for(int num: pageNumber) {
            if(num == -1) break;

            boolean isInit = false;
            boolean isExist = false;
            for (int i = 0; i < physicalBlock.length; i++) {
                if(physicalBlock[i] == num) {
                    if(option == MAlgorithms.LRU) age[i] = 0;
                    isExist = true;
                    break;
                }
                else if(physicalBlock[i] == -1) {
                    physicalBlock[i] = num;
                    age[i] = 0;
                    missPageNumber++;
                    isInit = true;
                    break;
                }
            }
            if(isInit || isExist) {
                for (int i = 0; i < age.length; i++) age[i]++;
            }
            else{
                int priorityVal = -1;
                int priorityIndex = -1;

                for (int i = 0; i < age.length; i++) {
                    if(age[i] > priorityVal) {
                        priorityIndex = i;
                        priorityVal = age[i];
                    }
                }
                //目标 index = priorityIndex
                physicalBlock[priorityIndex] = num;
                age[priorityIndex] = 0;
                for (int i = 0; i < age.length; i++) age[i]++;
                missPageNumber++;
            }

            if(isExist) {
                System.out.println("Y");
                continue;
            }
            for (int j : physicalBlock) {
                if(j != -1) System.out.print(j + " ");
                else break;
            }
            System.out.println();
        }
        double missPageRate = (double)missPageNumber/pageNumberSize;
        System.out.println("缺页数为:" + missPageNumber + "缺页率为:" + missPageRate*100 + "%");

    }

    public static void main(String[] args) {

        inputAndInit();

        while (true) {
            System.out.print("选择你的算法(键入对应的序号即可: 0.退出  1. FIFO   2. LRU):");
            int opt = scan.nextInt();
            if (opt == 0) break;
            else if (opt == 1) option = MAlgorithms.FIFO;
            else if (opt == 2) option = MAlgorithms.LRU;

            computeAndOutput();
        }

    }
}

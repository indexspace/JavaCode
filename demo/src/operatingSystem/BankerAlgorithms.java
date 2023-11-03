package operatingSystem;

import java.util.Scanner;

public class BankerAlgorithms {
    static Scanner scanner = new Scanner(System.in);
    static int processCount;
    static int resourceCount;
    static int[] available;
    static int[][] max;
    static int [][] allocation;
    static int [] request;
    static int processId;
    static boolean [] finished;
    static int[] work;

    public static void init() {
        // io_init:  resource available  max allocation
        System.out.println("分别键入进程数和资源数(空格隔开):");
        processCount = scanner.nextInt();
        resourceCount = scanner.nextInt();

        available = new int[resourceCount];
        max = new int[processCount][resourceCount];
        allocation = new int[processCount][resourceCount];
        request = new int[resourceCount];
        finished = new boolean[processCount];
        work = new int[resourceCount];

        System.out.println("键入max[][] (空格隔开):");
        for (int i = 0; i < processCount; i++)
            for (int j = 0; j < resourceCount; j++)
                max[i][j] = scanner.nextInt();

        System.out.println("键入allocation[][] (空格隔开):");
        for (int i = 0; i < processCount; i++)
            for (int j = 0; j < resourceCount; j++)
                allocation[i][j] = scanner.nextInt();

        System.out.println("键入available[] (空格隔开):");
        for (int i = 0; i < resourceCount; i++) available[i] = scanner.nextInt();
    }

    public static void getSecureSequence() {
        boolean signA = false;
        boolean signB = false;
        StringBuffer sb = new StringBuffer();

        // 1
        for (int i = 0; i < resourceCount; i++) {
            work[i] = available[i];
            finished[i] = false;
        }

        // 2
        for (int i = 0; i < processCount; i++) {
            signB = false;
            // 找符合要求的进程
            for (int j = 0; j < processCount; j++) { // 进程ID为 j
                // 如finished[j]不符合要求, continue下一个
                if (finished[j]) continue;

                // 如need[i,*] <= work[*] 不符合要求, continue下一个
                signA = true;
                for (int k = 0; k < resourceCount; k++) {
                    if (max[j][k] - allocation[j][k] > work[k]) {
                        signA = false;
                        break;
                    }
                }
                if (!signA) continue;

                // 3 success
                for (int k = 0; k < resourceCount; k++) {
                    work[k] += allocation[j][k];
                }
                finished[j] = true;

                if (!sb.toString().equals("")) sb.append(" -> ");
                sb.append("P").append(j);

                signB = true;
            }
            if (!signB) break;
        }

        // 打印资源情况
        System.out.println("此刻资源分配情况如下:");
        System.out.println("进程号\tmax\t\t\tallocation\t\t\tneed");
        for (int i = 0; i < processCount; i++) {
            System.out.print("P" + i + "\t");
            for (int j = 0; j < resourceCount; j++) System.out.print(max[i][j] + "\t");
            System.out.print("\t");
            for (int j = 0; j < resourceCount; j++) System.out.print(allocation[i][j] + "\t");
            System.out.print("\t");
            for (int j = 0; j < resourceCount; j++) System.out.print(max[i][j] - allocation[i][j] + "\t");
            System.out.println("\t");
        }
        System.out.print("各类资源的可利用数为:  ");
        for (int i = 0; i < resourceCount; i++) System.out.print(available[i] + " ");
        System.out.println();

        // 4
        for (int i = 0; i < resourceCount; i++) {
            if(!finished[i]) {
                System.out.println("当前系统不安全!!");
                return;
            }
        }
        System.out.print("系统当前安全, 安全序列为: " + sb);
        System.out.println();
    }

    public static void main(String[] args){

        init();

        getSecureSequence();

        int n = 0;  // 是否继续循环 1表示继续
        do {
            processId = -1;
            for (int i = 0; i < resourceCount; i++) request[i] = 0;
            boolean exit = false;

            System.out.println("键入需要获取请求的进程索引:");
            processId = scanner.nextInt();

            System.out.println("输入请求数组request[]:");
            for (int i = 0; i < resourceCount; i++) {
                request[i] = scanner.nextInt();
            }

            for (int i = 0; i < resourceCount; i++) {
                if (request[i] + allocation[processId][i] > max[processId][i]) {
                    System.out.println("请求的资源超出进程需求");
                    exit = true;
                    break;
                }
            }
            for (int i = 0; i < resourceCount; i++) {
                if (request[i] > available[i]) {
                    System.out.println("没有足够的资源分配!");
                    exit = true;
                    break;
                }
            }
            if (!exit) {
                getSecureSequence();
            }
            System.out.println("是否继续? (1表示继续 0表示不继续)");
            n = scanner.nextInt();
        } while (n == 1);
    }
}

package operatingSystem;

import java.util.ArrayList;
import java.util.Scanner;

enum Algorithms {
    FCFS,SJF
}

class Process {
    // 参数
    static float lastEndTime = 0;
    private Boolean isExecuted= false;
    private String name;
    private float arriveTime;   //到达时间
    private float serviceTime;  //服务时间
    private float startTime;    //开始时间
    private float endTime;   //完成时间
    private float cycleTime;    //周转时间
    private float weiCycleTime;   //带权周转时间

    // 构造器
    public Process(String name, float arriveTime, float serviceTime) {
        this.name = name;
        this.arriveTime = arriveTime;
        this.serviceTime = serviceTime;
    }

    // 包含计算的set
    public void setStartTime(float startTime) {
        this.startTime = startTime;
        setEndTime(startTime+serviceTime);
        setCycleTime(endTime-arriveTime);
        setWeiCycleTime(cycleTime/serviceTime);

        setExecuted(true);
        lastEndTime = endTime;
    }

    public Boolean isExecutable() {
        if(!this.isExecuted && this.arriveTime <= lastEndTime) return true;
        return false;
    }

    // 普通的setter getter toString
    public void setEndTime(float endTime) {
        this.endTime = endTime;
    }
    public void setCycleTime(float cycleTime) {
        this.cycleTime = cycleTime;
    }
    public void setWeiCycleTime(float weiCycleTime) {
        this.weiCycleTime = weiCycleTime;
    }
    public void setExecuted(Boolean executed) {
        this.isExecuted = executed;
    }
    public String getName() {
        return name;
    }
    public float getArriveTime() {
        return arriveTime;
    }
    public float getServiceTime() {
        return serviceTime;
    }
    public float getStartTime() {
        return startTime;
    }
    public float getEndTime() {
        return endTime;
    }
    public float getCycleTime() {
        return cycleTime;
    }
    public float getWeiCycleTime() {
        return weiCycleTime;
    }
    public Boolean getExecuted() {
        return isExecuted;
    }
    @Override
    public String toString() {
        return "operatingSystem.Process{" +
                "name='" + name + '\'' +
                ", arriveTime=" + arriveTime +
                ", serviceTime=" + serviceTime +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", cycleTime=" + cycleTime +
                ", weiCycleTime=" + weiCycleTime +
                '}';
    }
}

public class ProcessScheduling {

    static ArrayList<Process> processes = new ArrayList<Process>();
    static Algorithms opt;
    static int priorityIndex = -1;
    static float priorityValue = -1;
    static float time;
    public static void init() {
        String name;
        float arrive;
        float service;
        int goOn;

        Scanner input = new Scanner(System.in);

        System.out.println("选择调度算法(键入序号即可): 1. FCFS  2.SJF");
        int var1 = input.nextInt();
        if(var1 == 1) opt = Algorithms.SJF;
        else if(var1 == 2) opt = Algorithms.FCFS;

        do {
            input.nextLine();
            System.out.println("输入进程名称:");
            name = input.nextLine();

            System.out.println("输入进程到达时间和服务时间(空格隔开):");
            arrive = input.nextFloat();
            service = input.nextFloat();

            processes.add(new Process(name, arrive, service));

            System.out.println("还要输入其他进程吗?(键入数字即可) 1.继续 2.结束");
            goOn = input.nextInt();

        } while (goOn == 1);
    }

    public static void main(String[] args) {
        init();
        for (int i = 0; i < processes.size(); i++) {
            priorityIndex = -1;
            priorityValue = -1;
            for (int j = 0; j < processes.size(); j++) {
                Process process = processes.get(j);
                if(opt == Algorithms.SJF) time = process.getServiceTime();
                else if(opt == Algorithms.FCFS) time = process.getArriveTime();
                if (process.isExecutable()  &&(priorityValue == -1 || time < priorityValue)) {
                    priorityValue = time;
                    priorityIndex = j;
                }
            }
            processes.get(priorityIndex).setStartTime(Process.lastEndTime);
        }
        processes.forEach(System.out::println);
    }
}

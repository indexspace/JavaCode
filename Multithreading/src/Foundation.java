package src;

import src.threadObj.*;

import java.util.concurrent.FutureTask;

public class Foundation {
    public static void main(String[] args) throws Exception {

        // B =================
        /*new Thread(new B(3)).start();
        new Thread(new B(4)).start();*/

        // C =================
        FutureTask<Integer> task1 = new FutureTask<>(new C(5));
        Thread thread1 = new Thread(task1);
        thread1.start();
        //System.out.println(task1.get());

        FutureTask<Integer> task2 = new FutureTask<>(new C(6));
        Thread thread2 = new Thread(task2);
        thread2.start();
        //System.out.println(task2.get());

        // A =================
        A  a1 = new A(1);
        a1.start();

        A a2 = new A(2);
        // a2.start();

        Thread[] threads = {thread1, thread2, a1, a2};

        System.out.println("指定数组内的线程存活量 " + Thread.enumerate(threads));  // 指定数组内的线程存活量
        System.out.println("全局线程存活量 " + Thread.activeCount());  // 全局线程存活量

        System.out.println("thread1是守护线程吗? " + thread1.isDaemon());

        /*System.out.println("============001");
        thread1.join();
        thread2.join();
        System.out.println("============002");*/

        // 失败
        /*thread1.wait();
        System.out.println("thread1.wait()");
        for (int i = 0; i < 100; i++) {
            System.out.print(i + " ");
        }
        thread1.notify();
        System.out.println("thread1.notify()");*/

        System.out.println("中断否? " + Thread.interrupted());
    }

}



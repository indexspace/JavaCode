package src;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Foundation {
    public static void main(String[] args) throws Exception {

        /*new A(1).start();
        new A(2).start();*/

        /*new Thread(new B(3)).start();
        new Thread(new B(4)).start();*/

        FutureTask<Integer> task1 = new FutureTask<>(new C(5));
        Thread thread1 = new Thread(task1);
        thread1.start();
        // System.out.println(task1.get());

        FutureTask<Integer> task2 = new FutureTask<>(new C(6));
        Thread thread2 = new Thread(task2);
        thread2.start();
        // System.out.println(task2.get());

    }

}


class A extends Thread {
    private final int nums;

    public A(int nums) {
        this.nums = nums;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 100; i+=5) {
            System.out.println("A : " + nums + " - " + i);
        }
    }
}

class B implements Runnable {
    private final int nums;

    public B(int nums) {
        this.nums = nums;
    }
    @Override
    public void run() {
        for (int i = 0; i <= 100; i += 10) {
            System.out.println("B : " + nums + " - " + i);
        }
    }
}

class C implements Callable<Integer> {
    private final int nums;

    public C(int nums) {
        this.nums = nums;
    }
    @Override
    public Integer call() throws Exception {
        for (int i = 0; i <= 100; i += 20) {
            System.out.println("C : " + nums + " - " + i);
        }
        return nums;
    }

}
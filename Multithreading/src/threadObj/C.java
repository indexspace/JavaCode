package src.threadObj;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class C implements Callable<Integer> {
    private final int nums;
    private final Condition condition;

    public C(int nums, Condition condition) {
        this.nums = nums;
        this.condition = condition;
    }

    public C(int nums) {
        this.nums = nums;
        this.condition = new ReentrantLock().newCondition();
    }

    @Override
    public Integer call() throws Exception {
        if (nums == 5) {
            System.out.println("start condition.await();");
            condition.await();
            System.out.println("end condition.await();");
        }
        else {
            System.out.println("start condition.signal();");
            condition.signalAll();
            System.out.println("end condition.signal();");
        }

        for (int i = 0; i <= 100; i += 20) {
            System.out.println("C : " + nums + " - " + i);
        }
        System.out.println("start yield()");
        Thread.yield();
        System.out.println("end yield()");

        return nums;
    }

}

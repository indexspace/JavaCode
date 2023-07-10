package src.threadObj;

import java.util.concurrent.locks.ReentrantLock;

public class B implements Runnable {
    private final int nums;

    private static ReentrantLock lock = new ReentrantLock();

    public B(int nums) {
        this.nums = nums;
    }

    @Override
    public void run() {
        lock.lock();
        System.out.println("上锁了");
        for (int i = 0; i <= 100; i += 10) {
            System.out.println("B : " + nums + " - " + i);
        }
        lock.unlock();
        System.out.println("解锁了");
    }
}

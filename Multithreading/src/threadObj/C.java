package src.threadObj;

import java.util.concurrent.Callable;

public class C implements Callable<Integer> {
    private final int nums;

    public C(int nums) {
        this.nums = nums;
    }

    @Override
    public Integer call() throws Exception {
        for (int i = 0; i <= 100; i += 20) {
            System.out.println("C : " + nums + " - " + i);
        }
        System.out.println("start yield()");
        Thread.yield();
        System.out.println("end yield()");
        return nums;
    }

}

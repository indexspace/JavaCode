package src.threadObj;

public class A extends Thread {
    private final int nums;

    public A(int nums) {
        this.nums = nums;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i+=5) {
            System.out.println("A : " + nums + " - " + i);
        }

        System.out.println("start sleep 1000 s");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("end sleep 1000 s");

        for (int i = 50; i <= 100; i+=5) {
            System.out.println("A : " + nums + " - " + i);
        }
    }
}

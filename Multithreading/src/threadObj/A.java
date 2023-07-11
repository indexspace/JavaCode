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
    }
}

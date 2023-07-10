package src;

import src.threadObj.B;
import src.threadObj.C;

import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.ReentrantLock;

public class Lock {
    public static void main(String[] args) {

        new Thread(new B(3)).start();
        new Thread(new B(4)).start();

        FutureTask<Integer> task1 = new FutureTask<>(new C(5));
        Thread thread1 = new Thread(task1);
        thread1.start();

        FutureTask<Integer> task2 = new FutureTask<>(new C(6));
        Thread thread2 = new Thread(task2);
        thread2.start();

        // TODO: new ReentrantLock().newCondition();
        
    }
}

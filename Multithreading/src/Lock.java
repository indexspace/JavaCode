package src;

import src.threadObj.B;
import src.threadObj.C;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Lock {
    public static void main(String[] args) {

        new Thread(new B(3)).start();
        new Thread(new B(4)).start();


        Condition condition = new ReentrantLock().newCondition();

        FutureTask<Integer> task1 = new FutureTask<>(new C(5,condition));
        Thread thread1 = new Thread(task1);
        thread1.start();

        FutureTask<Integer> task2 = new FutureTask<>(new C(6, condition));
        Thread thread2 = new Thread(task2);
        thread2.start();

    }
}

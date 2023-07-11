package src;

import src.threadObj.B;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        service.submit(new Thread(new B(7)));
        service.submit(new Thread(new B(8)));
        service.shutdown();
    }
}

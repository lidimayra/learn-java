package concurrency.threads;

import static java.lang.Thread.currentThread;

public class MyRunnable implements Runnable {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();

        Thread thread = new Thread(myRunnable, "My new thread");
        thread.start();
    }

    @Override
    public void run() {
        String threadName = currentThread().getName();
        System.out.printf("%s is running...", threadName);
    }
}

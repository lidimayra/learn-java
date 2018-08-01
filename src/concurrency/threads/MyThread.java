package concurrency.threads;

public class MyThread extends Thread {
    public static void main(String[] args) {
        System.out.println("Start of main method");

        MyThread mt1 = new MyThread();
        MyThread mt2 = new MyThread();
        MyThread mt3 = new MyThread();
        MyThread mt4 = new MyThread();
        MyThread mt5 = new MyThread();

        mt1.start();
        mt2.start();
        mt3.start();
        mt4.start();
        mt5.start();

        System.out.println("End of main method");
    }

    @Override
    public void run() {
        System.out.printf("\tStart: %s\n\n", getName());

        for (int i = 0; i < 5; i++) {
            System.out.printf("\t%d %s\n", i, getName());
        }

        System.out.printf("\n\tEnd: %s\n\n", getName());
    }
}

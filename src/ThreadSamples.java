import javax.swing.*;

import static java.lang.Thread.sleep;

public class ThreadSamples extends JFrame {

    private class MyThread extends Thread {
        public MyThread(String name) {
            super(name);
        }


        @Override
        public void run() {
            System.out.println("Started Thread "+Thread.currentThread().getName());
            while (!isInterrupted()) {
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
//                    break;
                }
                System.out.println("Thread "+Thread.currentThread().getName()+" works isInterrupted()="+isInterrupted());
            }
            System.out.println("Ended Thread "+Thread.currentThread().getName());
        }
    }

    public ThreadSamples() {
        setTitle("ThreadSamples");
        setBounds(100, 100, 1000, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        init();
        setVisible(true);
    }

    private void init() {
        MyThread thread = new MyThread("New thread");
        thread.start();
        System.out.println("Stsrted thread " + Thread.currentThread().getName());

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {


                System.out.println("Hello from " + Thread.currentThread().getName());
            }
        }, "Thread1");
        thread1.start();

        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
        System.out.println("Ended thread " + Thread.currentThread().getName());
//        Thread thread = Thread.currentThread();
//        thread.setName("renamedThread");
//        System.out.println("Current thread name = "+thread.getName());


    }
}

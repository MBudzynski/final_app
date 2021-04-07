package pl.sda.threads;

import org.junit.jupiter.api.Test;

public class ThreadExample {


    @Test
     void basicThreads(){
        Runnable runnableLambda = () -> System.out.println(Thread.currentThread().getName() + " lambda");
        Runnable runnableAnonymous = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " anonymous");
            }
        };
        Runnable runnableClass = new OurRunnable();

        Thread t1 = new Thread(runnableLambda);
        Thread t2 = new Thread(runnableAnonymous);
        Thread t3 = new Thread(runnableClass);

//        t1.run();
        t1.start();
        t2.start();
        t3.start();
    }
}

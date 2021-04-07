package pl.sda.threads;

import java.util.concurrent.atomic.AtomicInteger;

public class Bank {

    private static AtomicInteger balance = new AtomicInteger(1000);
    private static AtomicInteger counter = new AtomicInteger(0);

    public /*synchronized*/ static void withdraw(Integer amount){
        balance.addAndGet(-amount);
        System.out.println(Thread.currentThread().getName() + "current balance after withdraw: " + balance);
    }

    public /*synchronized*/ static void deposit(Integer amount){
        balance.addAndGet(+amount);
        counter.incrementAndGet();
        System.out.println(Thread.currentThread().getName() + "current balance after deposit: " + balance);
    }

    public static Integer getBalance() {
        return balance.get();
    }

    public static Integer getCounter() {
        return counter.get();
    }
}

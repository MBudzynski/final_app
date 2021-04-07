package pl.sda.threads;

import java.util.Random;

public class ClientAction implements Runnable{


    @Override
    public void run() {
        Integer amount = new Random().nextInt(100);
        Bank.withdraw(amount);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Bank.deposit(amount);
    }
}

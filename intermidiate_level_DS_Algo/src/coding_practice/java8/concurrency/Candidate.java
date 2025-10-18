package coding_practice.java8.concurrency;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Candidate extends Thread{
    private final int id;
    private final Semaphore cabins;
    private final Random random = new Random();

    public Candidate (int id, Semaphore cabins){
        this.id = id;
        this.cabins = cabins;
    }

    @Override
    public void run() {
        try {
            cabins.acquire();
            System.out.println("Candidate "+id+" is now in Cabin with : "+ Thread.currentThread().getName());
            int milliseconds = 1+random.nextInt(5);
            Thread.sleep(milliseconds * 1000L);
            System.out.println("Candidate "+id + " finished interviewed in : "+milliseconds + "seconds");

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }finally {
            cabins.release();
        }

    }
}

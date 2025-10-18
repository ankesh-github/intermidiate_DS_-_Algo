package coding_practice.java8.concurrency;

import java.util.concurrent.Semaphore;

public class InterviewProcessMain {
    private static final int numberOfCabins = 5;
    private static final int candidateList = 200;

    public static void main(String [] args){
        Semaphore cabins = new Semaphore(numberOfCabins);

        System.out.println("Interview process has started: ");
        for(int i=1; i<=candidateList; i++){
            new Candidate(i, cabins).start();
        }
    }
}

package intro_to_problem_solving;

import java.util.Scanner;

public class SumOfNaturalNumbers {
    public static void main(String [] args){
        System.out.println("Enter your input :");
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        sc.close();
        // summation of n natural numbers : n * (n+1)/2;
        System.out.println("sum : "+ n*(n+1)/2);
    }
}

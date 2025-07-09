package intro_to_problem_solving;

import java.util.Scanner;

public class CheckPrimeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        sc.close();
        boolean isPrime = isPrimeNumber(input);
        System.out.println("isPrime: " + isPrime);
    }

    private static boolean isPrimeNumber(int n) {
        int count = 0;
        for (int i = 1; i * i <= n; i++) {
            if (i * i == n) {
                count++;
            } else if (n % i == 0) {
                count = count + 2;
            }
        }
        System.out.println("count: " + count);
        return count == 2;
    }
}

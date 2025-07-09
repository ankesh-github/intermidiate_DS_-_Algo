package intro_to_problem_solving;

import java.util.Scanner;

public class CheckPerfectNumber {
    public static void main(String[] args) {
        System.out.println("Number of Inputs :");
        Scanner sc = new Scanner(System.in);
        int inputSize = sc.nextInt();
        while (inputSize != 0) {
            int n = sc.nextInt();
            boolean isPerfect = checkPerfectNumber(n);
            System.out.println("isPerfect : " + isPerfect);
            inputSize--;
        }
        sc.close();

    }

    private static boolean checkPerfectNumber(int n) {
        if (n <= 1) {
            return false;
        }

        int sum = 1;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                sum = sum + i;
                if (i != n / i) {
                    sum = sum + n / i;
                }
            }
        }
        System.out.println("sum :" + sum);
        return sum == n;
    }
}

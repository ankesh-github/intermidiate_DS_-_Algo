package intro_to_problem_solving;

import java.util.Scanner;

public class FindSquareRootOfNumber {
    public static void main(String[] args) {
        System.out.println("Enter a number : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        int squareRoot = findSquareRoot(n);
        System.out.println("result : " + squareRoot);
    }

    private static int findSquareRoot(int n) {
        int low = 0;
        int high = n;
        while (low <= high) {
            int mid = low + (high - low)/2;
            long midSquare = (long)mid*mid; // avoid overflow
            if (midSquare == n) {
                return mid;
            } else if (midSquare > n) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;


    }
}

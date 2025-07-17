package prefix_sum;

public class EquilibriumIndex {
    public static void main(String[] args) {
        int[] arr = {-7, 1, 5, 2, -4, 3, 0};
        System.out.println("Original Array: ");
        print(arr);
        // approach 1: Brute Force
        //Integer equilibriumIndex = findEquilibriumIndex(arr);
        // approach 2: Prefix Sum
        Integer equilibriumIndex = findEquilibriumIndexUsingPrefixSum(arr);
        System.out.println("\nEquilibrium index is: " + equilibriumIndex);
    }

    private static Integer findEquilibriumIndexUsingPrefixSum(int[] arr) {
        int[] prefixSum = new int[arr.length];
        prefixSum[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }
        System.out.print("\nPrefix Sum Array: ");
        print(prefixSum);
        for (int i = 1; i < arr.length - 1; i++) {
            int leftSum = prefixSum[i - 1];
            int rightSum = prefixSum[arr.length - 1] - prefixSum[i];
            if (leftSum == rightSum) {
                System.out.println("\nEquilibrium index is: " + i);
                return i;
            }
        }
        return null;
    }

    private static Integer findEquilibriumIndex(int[] arr) {
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }
        int leftSum = 0;
        int rightSum = totalSum;
        for (int i = 0; i < arr.length; i++) {
            rightSum -= arr[i];
            if (leftSum == rightSum) {
                System.out.println("\nEquilibrium index is: " + i);
                return i;
            }
            leftSum += arr[i];
        }
        return null;
    }

    private static void print(int[] arr) {
        System.out.print("{");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i != arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("}");
    }
}

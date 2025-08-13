package leetcode.array;

public class MaxProductSubArray {
    public static void main(String[] args) {
        int[] arr = {2, 3, -2, 4};
        int result = maxProduct(arr);
        System.out.println("Maximum Product Subarray: " + result);
    }

    public static int maxProduct(int[] nums) {
        int minSum = nums[0];
        int maxSum = nums[0];
        int max_so_for = maxSum;

        for(int i=1; i<nums.length; i++){
            int cur = nums[i];
            int temp = Math.max(cur, Math.max( minSum*cur, maxSum*cur));
            minSum = Math.min(cur, Math.min(minSum*cur, maxSum*cur));
            maxSum = temp;

            max_so_for = Math.max(max_so_for, maxSum);
        }
        return max_so_for;
    }
}

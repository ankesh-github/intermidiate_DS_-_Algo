package leetcode.array;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = {6,7,8,9,1,2,3,4,5};
        int target = 2;
        int index = search(arr, target);
        System.out.println("Index of target " + target + ": " + index);
    }

    private static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1; // or throw an exception
        }
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // Determine which side is sorted
            if (nums[left] <= nums[mid]) { // Left side is sorted
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1; // Target is in the left sorted part
                } else {
                    left = mid + 1; // Target is in the right part
                }
            } else { // Right side is sorted
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1; // Target is in the right sorted part
                } else {
                    right = mid - 1; // Target is in the left part
                }
            }
        }
        return -1; // Target not found
    }
}

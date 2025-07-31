package coding_practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4, 4, 5, 6, 8, 2, 4};
        printArray(arr);

        // approach 1: using brute force
        // time complexity: O(n^2), space complexity: O(n)
        removeDuplicatesWithExtraSpace(arr);

        // approach 2: using brute force with no extra space
        // time complexity: O(n^2), space complexity: O(1)
        int[] arr2 = {1, 2, 2, 3, 4, 4, 5, 6, 8, 2, 4};
        removeDuplicatesWithoutExtraSpace(arr2);

        // approach 3: using sorting and two pointers
        // time complexity: O(n log n), space complexity: O(1)
        int[] arr3 = {1, 2, 2, 3, 4, 4, 5, 6, 8, 2, 4};
        removeDuplicatesWithSorting(arr3);

        // approach 4: using HashSet
        // time complexity: O(n), space complexity: O(n)
        int[] arr4 = {1, 2, 2, 3, 4, 4, 5, 6, 8, 2, 4};
        removeDuplicatesWithHashSet(arr4);


    }

    private static void removeDuplicatesWithHashSet(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        Set<Integer> set = new HashSet<>();
        int index = 0;
        for (int num : arr) {
            if (set.add(num)) {
                arr[index] = num;
                index++;
            }
        }

        while (index < arr.length) {
            arr[index] = Integer.MIN_VALUE; // fill remaining elements with a placeholder
            index++;
        }

    }

    private static void removeDuplicatesWithSorting(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        // Sort the array first
        Arrays.sort(arr);
        int index = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                arr[index] = arr[i];
                index++;
            }
        }

        while (index < arr.length) {
            arr[index] = Integer.MIN_VALUE; // fill remaining elements with a placeholder
            index++;
        }
        printArray(arr);
    }

    private static void removeDuplicatesWithoutExtraSpace(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            boolean isDuplicate = false;

            for (int j = 0; j < index; j++) {
                if (arr[i] == arr[j]) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                arr[index] = arr[i];
                index++;
            }
        }
        while (index < arr.length) {
            arr[index] = Integer.MIN_VALUE; // fill remaining elements with a placeholder
            index++;

        }
        printArray(arr);

    }

    private static void removeDuplicatesWithExtraSpace(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        int[] newArr = new int[arr.length];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            boolean isDuplicate = false;
            for (int j = 0; j <= index; j++) {
                if (arr[i] == newArr[j]) {
                    isDuplicate = true;
                    break;
                }
            }

            if (!isDuplicate) {
                newArr[index] = arr[i];
                index++;
            }

        }
        while (index < newArr.length) {
            newArr[index] = Integer.MIN_VALUE; // fill remaining elements with a placeholder
            index++;

        }
        printArray(newArr);
    }

    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}

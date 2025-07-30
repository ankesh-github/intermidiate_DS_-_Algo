package coding_practice;

public class ExtractZeros {
    public static void main(String[] args) {
        int[] arr = {1, 0, 3, 6, 0, 0, 8, 0, 6};
        printArray(arr);

         /*approach 1 : using two pointers
         time complexity : O(n), space complexity : O(1)
         this approach is efficient as if the requirement is to not maintain the order of non-zero elements*/
        moveZerosToEnd(arr);
        printArray(arr);

        /*
         approach 2 : using single pointers
         time complexity : O(n), space complexity : O(1)
         this approach will maintain the order of non zeros element also
         */

        int[] arr2 = {1, 0, 3, 6, 0, 0, 8, 0, 6};
        moveZerosToEndPreserveOrder(arr2);
        printArray(arr2);
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

    private static void moveZerosToEnd(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int left = 0, right = arr.length - 1;
        while (left < right) {
            while (left < right && arr[left] != 0) {
                left++;
            }
            while (left < right && arr[right] == 0) {
                right--;
            }
            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
    }

    private static void moveZerosToEndPreserveOrder(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int index = 0;
        for (int num : arr) {
            if (num != 0) {
                arr[index++] = num;
            }
        }

        while (index < arr.length) {
            arr[index++] = 0;

        }

    }
}
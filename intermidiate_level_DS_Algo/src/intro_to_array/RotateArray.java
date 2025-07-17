package intro_to_array;

public class RotateArray {
    public static void main(String [] args){
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        int k = 12; // number of positions to rotate
        System.out.println("Original Array: ");
        print(arr);
        // approach-1 with brute force
       // rotate(arr, k);
        // Time complexity: O(n*k) and Space complexity: O(1)
        // approach-2
        rotateElement(arr, k);
        // Time complexity: O(n) and Space complexity: O(1)
        System.out.println("\nRotated Array: ");
        print(arr);
    }

    private static void rotateElement(int[] arr, int k) {
        k = k % arr.length; // to handle cases where k > arr.length
        reverse(arr, 0, arr.length - 1); // reverse the entire array
        reverse(arr, 0, k - 1); // reverse the first k elements
        reverse(arr, k, arr.length - 1); // reverse the remaining elements
    }

    private static void reverse(int[] arr, int start, int end){
        while(start < end){
            int temp = arr[start];
            arr[start] = arr [end];
            arr[end] = temp;
            start++;
            end--;
        }

    }

    private static void print(int[] arr) {
        System.out.print("{ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i != arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print(" }");
    }

    public static void rotate(int[] arr, int k){
        k = k % arr.length;
        while(k > 0){
            int temp = arr[arr.length - 1];
            for(int i = arr.length -1 ; i> 0; i--){
                arr[i] = arr[i-1];
            }
        arr[0] = temp;
            k--;
        }

    }
}

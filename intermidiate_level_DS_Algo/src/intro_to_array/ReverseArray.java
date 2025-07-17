package intro_to_array;

public class ReverseArray {
    public static void main(String[] args) {
        int[] arr = {-1, 4, 7, 6, -2, 12, 8, 10};
        System.out.println("Original Array: ");
        print(arr);
        reverse(arr);
        System.out.println("\nReversed Array: ");
        print(arr);
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

    private static void reverse(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            //swapTheElementsWithTempVariable(i, arr.length - 1 - i, arr);
            swapTheElementsWithoutTempVariable(i, arr.length - 1 - i, arr);
        }
    }

    private static void swapTheElementsWithTempVariable(int first, int last, int[] arr) {
        int temp = arr[first];
        arr[first] = arr[last];
        arr[last] = temp;
    }

    private static void swapTheElementsWithoutTempVariable(int first, int last, int[] arr) {
        arr[first] = arr[first] + arr[last];
        arr[last] = arr[first] - arr[last];
        arr[first] = arr[first] - arr[last];
    }

}

package carry_forward;

public class LeftMax {
    public static void main(String[] args) {
        int[] arr = {-3, 6, 2, 4, 5, 2, 8, -9, 3, 1};
        int index = 5;
        int leftMax = findLeftMax(arr, index);
        if (leftMax == -1) {
            System.out.println("Invalid input");
        } else {
            System.out.println("Left max of index " + index + " is : " + leftMax);
        }

        // approach 2 usingPrefix sum
        int max = findLeftMaxUsingPrefixSum(arr, index);

    }

    private static int findLeftMaxUsingPrefixSum(int[] arr, int index){
        if(arr == null ||  arr.length == 0 || index <=0 || index >= arr.length){
            return -1;
        }

        int[] prefixMax = new int[arr.length];
        prefixMax[0] = arr[0];
        for(int i = 1; i< arr.length; i++){
            prefixMax[i] =  prefixMax[i-1] > arr[i] ? prefixMax[i-1] : arr[i];

        }
        System.out.println("prefixMax : " +prefixMax[index-1]);
        print(prefixMax);
        return prefixMax[index-1];

    }

    private static void print(int [] arr){
        System.out.print("[");
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]);
            if(i < arr.length - 1){
                System.out.print(", ");
            }
        }
        System.out.println("]");

    }

    private static int findLeftMax(int[] arr, int index) {
        if (arr == null || arr.length == 0 || index <= 0 || index >= arr.length) {
            return -1;

        }
        int leftMax = arr[0];
        for (int i = 1; i < index; i++) {
            if (arr[i] > leftMax) {
                leftMax = arr[i];
            }

        }
        return leftMax;


    }
}

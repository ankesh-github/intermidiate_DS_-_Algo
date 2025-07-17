package prefix_sum;

public class SumOfElement {
    public static void main (String [] args){
        int [] arr = {1, 2, 3, 4, 5};
        int start = 2;
        int end = 4;
        System.out.println("Original Array: ");
        print(arr);
        Integer sum = sumOfElements(arr, start, end);
        System.out.println("\nSum of elements from index " + start + " to " + end + " is: " + sum);
    }

    private static Integer sumOfElements(int[] arr, int start, int end) {
        int sum=0;
        while(start<=end){
            sum += arr[start];
            start++;
        }
        return sum;
    }

    private static void print(int[] arr){
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

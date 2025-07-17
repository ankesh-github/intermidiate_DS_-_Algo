package intro_to_array;

public class PrintArray {
    public static void main(String[] args) {
        int[] arr = {5, -4, 8, 9, 10};
        print(arr);
    }

    private static void print(int[] arr) {
        System.out.println("{ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if(i != arr.length - 1){
                System.out.print(", ");
            }
        }
        System.out.print(" }");

    }
}

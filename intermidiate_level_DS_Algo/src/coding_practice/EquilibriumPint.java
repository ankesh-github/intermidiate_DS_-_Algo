package coding_practice;

public class EquilibriumPint {
    public static void main(String [] args){
        int []  arr = {1, 3, 5, 2, 2};
        int index = findEquilibrium(arr);
        System.out.println(index);

    }

    public static int findEquilibrium(int[] arr) {
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }

        int leftSum = 0;
        for (int i = 0; i < arr.length; i++) {
            totalSum = totalSum - arr[i];
            if (leftSum == totalSum ) {
                return i;
            }
            leftSum += arr[i];
        }
        return -1;
    }
}

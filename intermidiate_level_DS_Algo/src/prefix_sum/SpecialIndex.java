package prefix_sum;

public class SpecialIndex {
    public static void main(String [] args){
        int [] arr = {2,3,1,4,0,-1,2,-2,10,8};
        System.out.println("Original Array: ");
        print(arr);
        Integer specialIndex = findSpecialIndex(arr);

    }

    private static Integer findSpecialIndex(int[] arr) {
        int result = 0;
        int[] prefixEvenSum = new int[arr.length];
        int[] prefixOddSum = new int[arr.length];
        prefixEvenSum[0] = arr[0];
        prefixOddSum[0] = arr[0];
        for(int i=1; i< arr.length; i++){
            if(i%2 ==0){
                prefixEvenSum[i] = prefixEvenSum[i-1] + arr[i];
                prefixOddSum[i] = prefixOddSum[i-1];
            } else {
                prefixOddSum[i] = prefixOddSum[i-1] + arr[i];
                prefixEvenSum[i] = prefixEvenSum[i-1];
            }
        }
        System.out.print("\nPrefix Even Sum Array: ");
        print(prefixEvenSum);
        System.out.print("\nPrefix Odd Sum Array: ");
        print(prefixOddSum);

        for(int i=0; i< arr.length; i++){
            if(i == 0){
                // for first index, left sum is 0
                if(prefixEvenSum[arr.length-1] - prefixEvenSum[i] == prefixOddSum[arr.length-1] - prefixOddSum[i]){
                    System.out.println("\nSpecial index is: " + i);
                    result++;
                }
                continue;
            }
            int leftEvenSum = prefixEvenSum[i-1] + prefixOddSum[arr.length-1] - prefixOddSum[i];
            int leftOddSum = prefixOddSum[i-1] + prefixEvenSum[arr.length-1] - prefixEvenSum[i];
            if(leftEvenSum == leftOddSum){
                System.out.println("\nSpecial index is: " + i);
                result++;
            }


        }
        return result == 0 ? null : result;

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

package intro_to_array;

import java.util.HashSet;

public class FindThePair {
    public static void main(String[] args) {
        int[] arr = {3, -2, -1, 4, 3, 6, 8};
        int k=10;
        //approach-1 with brute force
        //Time complexity: O(n^2) and Space complexity: O(1)
        boolean isPresent = hasPairWithSum(arr, k);
        System.out.println("isPairExists : " + isPresent);
        //approach-2 with HashSet
        //Time complexity: O(n) and Space complexity: O(n)
        boolean isPairExists = hasPairWithSumUsingHashSet(arr, k);
    }

    private static boolean hasPairWithSum(int[] arr, int k) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (i != j) {
                    if (arr[i] + arr[j] == k) {
                        System.out.println("firstIndex : " + i + " lastIndex: " + j);
                        return true;
                    }
                }
            }

        }
        return false;
    }

    private static boolean hasPairWithSumUsingHashSet(int[] arr, int k) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : arr){
            if(set.contains(k-num)){
                System.out.println("pair found with sum "+k+ " : " + num + " and " + (k-num));
                return true;
            }
            set.add(num);
        }
        return false;
    }
}

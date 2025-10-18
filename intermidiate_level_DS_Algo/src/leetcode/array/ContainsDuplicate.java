package leetcode.array;

import java.util.HashSet;

public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1};
        boolean result = containsDuplicate(arr);
        System.out.println("Contains Duplicate: " + result);
    }

    private static boolean containsDuplicate(int [] arr){
        if(arr == null || arr.length <= 1){
            return false;
        }
        HashSet<Integer> set = new HashSet<>();
        for(int num : arr){
            if(set.contains(num)){
                return true;
            }
            set.add(num);
        }
        return false;

    }
}

package leetcode.array;

import java.util.ConcurrentModificationException;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;

public class ContainsDublicate2 {
    public static void main(String [] args) {
        int[] arr = {1, 2, 3, 1};
        int k = 3;
        ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();
        boolean result = containsNearbyDuplicate(arr, k);
        System.out.println("Contains Nearby Duplicate: " + result);
    }

    private static boolean containsNearbyDuplicate(int[] arr, int k) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<arr.length; i++) {
            if (set.contains(arr[i])) {
                return true;
            }
            set.add(arr[i]);
            if (set.size() > k) {
                set.remove(arr[i - k]);
            }
        }
            return false;
    }
}

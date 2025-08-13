package leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        List<Integer> list = new ArrayList<>();
        int [] result = new int[2];
        for(int i=0; i<nums.length; i++){
            if(list.contains(target - nums[i])){
                result[0] = i;
                result[1] = list.indexOf(target-nums[i]);
                break;
            }
            list.add(nums[i]);

        }
        return result;

    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
       // int[] result = twoSum.twoSum(nums, target);
        int [] result = twoSum.twoSumUsingHashMap(nums, target);
        System.out.println("Indices: " + result[0] + ", " + result[1]);
    }

    private int[] twoSumUsingHashMap(int[] nums, int target) {
        int result[] = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length; i++){
            if(map.containsKey(target-nums[i])){
                result[0] = map.get(target-nums[i]);
                result[1] = i;
                break;
            }
            map.put(nums[i], i);
        }
        return result;
    }
}

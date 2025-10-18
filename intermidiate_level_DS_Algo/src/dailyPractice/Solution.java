package dailyPractice;

import java.util.*;
import java.util.stream.Collectors;


import java.util.*;

public class Solution {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(4, 5, 6, 4, 7, 5, 9, 10, 6);

        // Count frequency using HashMap
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (Integer num : list) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        System.out.print("Non-duplicate elements: ");
        for (Integer num : list) {
            if (freqMap.get(num) == 1) {
                System.out.print(num + " ");
            }
        }
    }
}


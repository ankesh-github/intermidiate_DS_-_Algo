package coding_practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindDistinctElement {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 5, 2, 7, 1, 9, 10};
        // approach 1 : using brute force
        int disctinctCount = countDistinctElements(arr);
        System.out.println("Total Distinct Elements: " + disctinctCount);

        // approach 2 : using sorting
        int distinctCountWithSorting = countDistinctElementsWithSorting(arr);
        System.out.println("Total Distinct Elements with Sorting: " + distinctCountWithSorting);

        // approach 3 : using HashSet
        int distinctCountWithHashSet = countDistinctElementsWithHashSet(arr);
        System.out.println("Total Distinct Elements with HashSet: " + distinctCountWithHashSet);

    }

    private static int countDistinctElementsWithHashSet(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int count = 0;
        Set<Integer> uniques = new HashSet<>();
        Set<Integer> dublicates = new HashSet<>();
        for (int num : arr) {
            boolean isPresent = uniques.add(num);
            if (!isPresent) {
                dublicates.add(num);
            }
        }
        uniques.removeAll(dublicates);
        uniques.forEach(e -> System.out.println("Distinct Element: " + e));
        return uniques.size();
    }

    private static int countDistinctElementsWithSorting(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        Arrays.sort(arr);
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            String position;
            boolean isDistinct = false;
            if (i == 0) {
                position = "first";
            } else if (i == arr.length - 1) {
                position = "last";
            } else {
                position = "middle";

            }

            switch (position) {
                case "first":
                    isDistinct = arr[i] != arr[i + 1];
                    break;
                case "last":
                    isDistinct = arr[i] != arr[i - 1];
                    break;
                case "middle":
                    isDistinct = arr[i] != arr[i - 1] && arr[i] != arr[i + 1];
                    break;

            }

            if (isDistinct) {
                System.out.println("Distinct Element: " + arr[i]);
                count++;
            }

        }
        return count;
    }

    private static int countDistinctElements(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            boolean isDistinct = true;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j] && i != j) {
                    isDistinct = false;
                    break;
                }
            }
            if (isDistinct) {
                System.out.println("Distinct Element: " + arr[i]);
                count++;
            }
        }
        return count;
    }
}

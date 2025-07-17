package intro_to_array;

public class FindMaxElement {
    public static void main(String[] args) {
        int[] arr = {2, 5, 1, 4, 8, 0, 8, 1, 3, 8};
        int countElement = countElementsWithGreater(arr);
        System.out.println("no of elements : " + countElement);
    }

    private static int countElementsWithGreater(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int maxElement = Integer.MIN_VALUE;
        int countMax = 0;
        for (int num : arr) {
            if (num > maxElement) {
                maxElement = num;
                countMax = 1;
            } else if (num == maxElement) {
                countMax++;
            }

        }
        System.out.println("maxElement : " + maxElement);
        return arr.length - countMax;
    }
}

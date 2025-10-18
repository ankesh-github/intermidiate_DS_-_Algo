package dailyPractice;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        String str = "abcabaxyxyya";
        int k=2;
        int n = characterReplacement(str.toUpperCase(),k);
        System.out.println(n);

    }

    public static int characterReplacement(String s, int k) {
        int maxLen = 0;
        for (int start = 0; start < s.length(); start++) {
            int[] freq = new int[26];
            int maxFreq = 0;
            for (int end = start; end < s.length(); end++) {
                freq[s.charAt(end) - 'A']++;
                maxFreq = Math.max(maxFreq, freq[s.charAt(end) - 'A']);
                if ((end - start + 1) - maxFreq <= k) {
                    maxLen = Math.max(maxLen, end - start + 1);
                }else {
                    break;
                }
            }
        }
        return maxLen;
    }
}

package string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubStringWithoutRepeatingChar {
    //Longest Substring Without Repeating Characters
    public static void main(String[] args) {
       // String s = "geeksforgeeks";
        String s = "aaaa";
        //String substring = approach1(s); // time complexity: o(n2) spacecompexity: o(26)=> ignore
        //String substring = approach2(s);
        String substring = approach3(s);
        System.out.println(substring);
    }

    private static String approach3(String s){
        Map<Character, Integer> map = new HashMap<>();
        int maxLength=0;
        int firstIndex=0;
        int lastIndex=0;
        int start=0;
        for(int end=0; end<s.length(); end++){
            char currentChar = s.charAt(end);
            if(map.containsKey(currentChar)){
                if(start < map.get(currentChar)){
                    start=map.get(currentChar);
                }
                start++;
            }

            map.put(currentChar, end);
            if(maxLength<end-start+1){
                maxLength=end-start+1;
                firstIndex=start;
                lastIndex=end;
            }

        }
        return s.substring(firstIndex, lastIndex+1);
    }

    private static String approach2(String s) {
        // sliding window : add in set => if value is present then slide till the unique
        Set<Character>set = new HashSet<>();
        int maxLength=0;
        int firstIndex=0;
        int lastIndex=0;
        int start=0;
        for(int end=0; end<s.length(); end++){
            char currentChar=s.charAt(end);
            while(set.contains(currentChar)){
                set.remove(s.charAt(start));
                start++;
            }
            set.add(currentChar);
            if(end-start+1 > maxLength){
                maxLength = end-start+1;
                firstIndex=start;
                lastIndex=end;
            }

        }
        return s.substring(firstIndex, lastIndex+1);
    }


    private  static String approach1(String s){
        // iterate loop => add value in set in internal loop if duplicate then break
        Set<Character> set = new HashSet<>();
        int maxLength=0;
        int firstIndex=0;
        int lastIndex=0;
        for(int i=0; i<s.length(); i++){
            set.clear();
            for(int j=i; j<s.length(); j++){
                char currentChar = s.charAt(j);
                if(set.contains(currentChar)){
                    break;
                }
                set.add(currentChar);
                if(j-i+1 > maxLength){
                    maxLength=j-i+1;
                    firstIndex=i;
                    lastIndex=j;
                }

            }
        }
        return s.substring(firstIndex, lastIndex+1);
    }
}

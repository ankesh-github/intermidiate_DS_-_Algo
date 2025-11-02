package string;

import java.lang.reflect.GenericDeclaration;
import java.util.*;

public class LongestSubStringWithKCharacter {
    public static void main(String[] args) {
        String s = "aabacbebebe";
        //int n1 = approach1(s,3);
        //System.out.println(n1);
        //int n2 = approach2(s,2);
        //System.out.println(n2);

        int n3 = approach3(s,3);
        System.out.println(n3);

    }

    private static int approach3(String s, int k) {
        int [] freq=new int[26];
        int count=0;
        int start=0;
        int maxLength=0;
        int firstIndex=0;
        int lastIndex=0;

        for(int i=0; i<s.length(); i++){
            char currentChar = s.charAt(i);
            freq[currentChar - 'a']++;

            if(freq[currentChar-'a']==1){
                count++;
            }

            while(count>k){
                char startChar = s.charAt(start);
                freq[startChar - 'a']--;
                if(freq[startChar - 'a']==0){
                    count--;
                }
                start++;
            }

            if(i-start +1 >maxLength){
                maxLength=i-start+1;
                firstIndex=start;
                lastIndex=i;
            }

        }
        System.out.println("Substring : "+s.substring(firstIndex, lastIndex+1));
        return maxLength<k?-1:maxLength;
    }

    private static int approach2(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int start=0;
        int end=0;
        int maxLength=0;
        int firstIndex=0;
        int lastIndex=0;
        for( end = 0; end<s.length(); end++){
            char currentChar = s.charAt(end);
            map.put(currentChar, map.getOrDefault(currentChar,0)+1);

            while(map.size()>k && start<end){
                char startChar = s.charAt(start);
                map.put(startChar, map.get(startChar)-1);
                if(map.get(startChar)==0){
                    map.remove(startChar);
                }
                start++;
            }

            if(maxLength<end-start+1){
                maxLength=end-start+1;
                firstIndex=start;
                lastIndex=end;
            }


        }
        System.out.println("Substring : "+s.substring(firstIndex, lastIndex+1));
        return maxLength<k?-1:maxLength;
    }

    private static int approach1(String str, int k){
        //"aabacbebebe"
        // brute force  with set
        Set<Character> set = new HashSet<>();
        int maxLength=0;
        int firstIndex=0;
        int lastIndex=0;
        for(int i=0; i<str.length(); i++){
            set.clear();
            for(int j=i; j<str.length(); j++){
                char currentChar = str.charAt(j);
                set.add(currentChar);
                if(set.size()==k && j-i+1 >maxLength){
                    maxLength = j-i+1;
                    firstIndex=i;
                    lastIndex=j;
                }
                if(set.size()>k){
                    break;
                }

            }
        }
        System.out.println("Substring : "+str.substring(firstIndex, lastIndex+1));
        return maxLength<k?-1:maxLength;
    }
}

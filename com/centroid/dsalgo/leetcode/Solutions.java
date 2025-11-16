package com.centroid.dsalgo.leetcode;

import java.util.*;

public class Solutions {
    public boolean hasDuplicte(int[] nums) {
        HashSet<Integer> seenNumbers = new HashSet<>();
        for (int num : nums) {
            if (seenNumbers.contains(num)) {
                return true;
            }
            seenNumbers.add(num);
        }
        return false;
    }

    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] count = new int[26];
        for(int i=0; i<s.length(); i++){
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for(int i=0; i<26; i++){
            if(count[i] != 0){
                return false;
            }
        }
        return true;

    }
    //YOU MUST KNOW THIS BY HEART
    public int[] twoSum(int[] numbers, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0 ; i < numbers.length ; i++){
            int complement = target - numbers[i];
            System.out.println(complement);
            if (map.containsKey(complement)){
                return new int[]{map.get(complement), i};
            }
            map.put(numbers[i], i);
        }
        return new int[]{};
    }
    //49-Group Anagrams
    public List<List<String>> groupAnagrams(String[] str){
        if (str.length == 0){
            return new ArrayList<>();
        }
        Map<String, List> ansMap = new HashMap<>();
        int[] count = new int[26];

        for(String s:str){
            Arrays.fill(count, 0);
            for(char c:s.toCharArray()){
                count[c-'a']++;
            }

            StringBuilder sb = new StringBuilder("");

            for(int i=0; i<26; i++){
                sb.append("#");
                sb.append(count[i]);
            }
            String key = sb.toString();
            if(!ansMap.containsKey(key)){
                ansMap.put(key,new ArrayList());

            }
            ansMap.get(key).add(s);
        }
        return new ArrayList(ansMap.values());
    }
}

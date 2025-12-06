package com.centroid.dsalgo.leetcode;

import java.util.*;

//Contains duplicate
//isAnagram
//two sum
//Group Anagram
//238 - Leetcode: Produc of Array except self: 52:13

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

    /**
     *
     * @param s
     * @param t
     * @return
     * Here is the algorithm in plain English, with one sentence dedicated to each logical step:
     *
     * 1. Preparation: Create a new, empty collection called "seen numbers" to store unique integers encountered so far.
     * 2. Inspection Loop: Examine each number in the input list one by one.
     * 3. Check for Duplication: Determine if the current number is already present in the "seen numbers" collection.
     * 4. Duplicate Found: If the number has been seen before, immediately confirm the presence of a duplicate by returning True.
     * 5. Unique Number: If the number is unique, add the current number to the "seen numbers" collection for future checks.
     * 6.No Duplicates: If the entire list is processed without finding any duplicates, conclude the list contains only unique numbers by returning False.
     */

    /**
     * @param s
     * @param t
     * @return
     * 📝 Anagram Algorithm Steps
     * 1. Length Check: Immediately return False if the lengths of the two input strings,
     * $s$ and $t$, are not equal.
     * 2. Case Normalization: Convert both strings, $s$ and $t$, to lowercase to ensure
     * case-insensitivity.
     * 3. Whitespace Removal: Remove all spaces from both strings, $s$ and $t$.
     * 4. Bucket Initialization: Create an integer array, count, of size 26 (one "bucket"
     * for each letter of the alphabet) and initialize all its values to zero.
     * 5. Filling Buckets (String $s$): Iterate through the first string $s$, and
     * for each character, increment the count in the corresponding array index (e.g.,
     * 'a' maps to index 0, 'b' to index 1, etc.).
     * 6. Emptying Buckets (String $t$): Iterate through the second string $t$, and
     * for each character, decrement the count in the corresponding array index.
     * 7. Final Check: Iterate through the entire 26-element count array.
     * 8.Mismatch Found: If any value in the count array is not zero, it means the
     * character counts don't match, so return False.
     * 9.Anagram Confirmation: If the loop completes and all counts are zero,
     * the strings are perfect anagrams, so return True.
     */
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        //convert both to lowercase to ignore case match
        s = s.toLowerCase();
        t = t.toLowerCase();

        //strip of all the white spaces
        s = s.replace(" ", "");
        t = t.replace(" ", "");

        //Initialize buckets array
        int[] count = new int[26];

        //Fill the buckets
        for(int i=0; i<s.length(); i++){
            count[s.charAt(i) - 'a']++;
        }

        //Empty the buckets
        for (int i =0 ; i<t.length() ; i++){
            count[t.charAt(i) - 'a']--;
        }

        //check if all buckets are empty
        for(int i=0; i<26; i++){
            if(count[i] != 0){
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @param numbers
     * @param target
     * @return
     *
     */
    //YOU MUST KNOW THIS BY HEART
    public int[] twoSum(int[] numbers, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0 ; i < numbers.length ; i++){
            int complement = target - numbers[i];
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

    //        int[] numbers = {1,2,3,4,6,7,7};
//        int[] numbers = {1,2,3,4,6,};
}

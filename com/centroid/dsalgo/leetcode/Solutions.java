package com.centroid.dsalgo.leetcode;

import java.util.*;

//Contains duplicate
//isAnagram
//two sum
//Group Anagram
//238 - Leetcode: Produc of Array except self: 52:13
//4 - Median of Two Sorted Array


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
     * @return 📝 Anagram Algorithm Steps
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
        if (s.length() != t.length()) {
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
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        //Empty the buckets
        for (int i = 0; i < t.length(); i++) {
            count[t.charAt(i) - 'a']--;
        }

        //check if all buckets are empty
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param numbers
     * @param target
     * @return 📝 Algorithm in Plain English
     * The goal is to find the indices (positions) of the two numbers in the input
     * array (numbers) that sum up to the target.
     * <p>
     * 1. Preparation: Create an empty map (or dictionary) to store numbers we have seen
     * so far, where the key is the number itself and the value is its index in the array.
     * <p>
     * 2. Iterate and Search: Start a loop that goes through each number in the input array,
     * from the first index i=0 to the last.
     * 3. Calculate Complement: For the current number ($\text{numbers}[i]$), calculate
     * the complement needed to reach the target: $\text{complement} =
     * \text{target} - \text{numbers}[i]$.
     * <p>
     * 4. Check Map: Check if this complement already exists as a key in the map
     * of seen numbers.
     * 5. Solution Found: If the complement is in the map:This means we have found
     * the two numbers that sum to the target.
     * 6. The index of the first number is the value retrieved from the map using
     * the $\text{complement}$ as the key.
     * 7. The index of the second number is the current index $i$.
     * 8. Return these two indices immediately.
     * 9. Add to Map: If the $\text{complement}$ was not found, add the current
     * number ($\text{numbers}[i]$) and its index ($i$) to the map, so it can
     * be used as a $\text{complement}$ for subsequent numbers.
     * 10. No Solution: If the loop finishes without finding a pair, return an
     * empty array (or indicate that no solution was found).
     */
    //YOU MUST KNOW THIS BY HEART
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int complement = target - numbers[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(numbers[i], i);
        }
        return new int[]{};
    }

    //49-Group Anagrams
    public List<List<String>> groupAnagrams(String[] str) {
        if (str.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List> ansMap = new HashMap<>();
        int[] count = new int[26];

        for (String s : str) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }

            StringBuilder sb = new StringBuilder("");

            for (int i = 0; i < 26; i++) {
                sb.append("#");
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!ansMap.containsKey(key)) {
                ansMap.put(key, new ArrayList());

            }
            ansMap.get(key).add(s);
        }
        return new ArrayList(ansMap.values());
    }

    //        int[] numbers = {1,2,3,4,6,7,7};
    //        int[] numbers = {1,2,3,4,6,};
    public int[] productExceptSelfNotOptimum(int[] numbers) {
        int[] result = new int[numbers.length];
        int total = 1;
        for (int number : numbers) {
            total *= number;
        }
        for (int i = 0; i < numbers.length; i++) {
            result[i] = total / numbers[i];
        }
        return result;
    }

    public int[] productExceptSelfOptimum(int[] nums) {

        int[] result = new int[nums.length];

        Arrays.fill(result, 1);

        //Initializes a variable to track the product of all
        // numbers to the left of the current index.
        int preFix = 1;
        // Iterates from the start of the array to the end.
        for (int i = 0; i < nums.length; i++) {
            // Stores the product of all elements before index i into result[i].
            result[i] = preFix;
            // Updates the prefix product by multiplying the current number.
            preFix = preFix * nums[i];
        }

        //Initializes a variable to track the product of all numbers
        //to the right of the current index.
        int postFix = 1;

        //Iterates from the end of the array to the beginning.
        for (int i = nums.length - 1; i >= 0; i--) {
            //Multiplies the left-side product already stored
            //with the right-side product.
            result[i] = postFix * result[i];
            //Updates the postfix product by multiplying the current number.
            postFix = postFix * nums[i];
        }
        //Returns the array containing the product of all elements except
        // the current one.
        return result;
    }


    // Public method to find the median of two sorted integer arrays
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // Ensure nums1 is the smaller array to minimize binary search range
        if (nums1.length > nums2.length) {
            // Swap arrays by recursively calling the method with reversed arguments
            return findMedianSortedArrays(nums2, nums1);
        }

        // Store the length of the smaller array
        int x = nums1.length;

        // Store the length of the larger array
        int y = nums2.length;

        // Initialize binary search start index
        int start = 0;

        // Initialize binary search end index
        int end = x;

        // Perform binary search on the smaller array
        while (start <= end) {

            // Compute partition index for nums1
            int partX = (start + end) / 2;

            // Compute partition index for nums2 so left partitions contain half the elements
            int partY = (x + y + 1) / 2 - partX;

            // Get the maximum value on the left side of nums1 partition
            int xLeft = partX == 0 ? Integer.MIN_VALUE : nums1[partX - 1];

            // Get the minimum value on the right side of nums1 partition
            int xRight = partX == x ? Integer.MAX_VALUE : nums1[partX];

            // Get the maximum value on the left side of nums2 partition
            int yLeft = partY == 0 ? Integer.MIN_VALUE : nums2[partY - 1];

            // Get the minimum value on the right side of nums2 partition
            int yRight = partY == y ? Integer.MAX_VALUE : nums2[partY];

            // Check if partitions are correctly placed
            if (xLeft <= yRight && yLeft <= xRight) {

                // If total number of elements is even
                if ((x + y) % 2 == 0) {
                    // Return the average of the two middle values
                    return ((double) Math.max(xLeft, yLeft) + Math.min(xRight, yRight)) / 2;
                }
                // If total number of elements is odd
                else {
                    // Return the maximum element from the left partitions
                    return Math.max(xLeft, yLeft);
                }
            }
            // If left part of nums1 is too large, move search left
            else if (xLeft > yRight) {
                end = partX - 1;
            }
            // If left part of nums1 is too small, move search right
            else {
                start = partX + 1;
            }
        }

        // Fallback return value (should never be reached for valid input)
        return 0;
    }

}

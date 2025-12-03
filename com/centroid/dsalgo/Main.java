package com.centroid.dsalgo;

import com.centroid.dsalgo.leetcode.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solutions solutions = new Solutions();
        int[] nums = {1,2,3,4,6,7,7};
        boolean result = solutions.hasDuplicte(nums);
        System.out.println(result);

        int[] arr = {2,5,7,8,2};
        int[] ans = solutions.twoSum(arr, 10);
        System.out.print(Arrays.toString(ans));

        String[] anagrams = {"rat", "act", "tar", "pat", "dog", "art", "cat"};
        List<List<String>> answer = solutions.groupAnagrams(anagrams);
        System.out.println(answer);

    }
}

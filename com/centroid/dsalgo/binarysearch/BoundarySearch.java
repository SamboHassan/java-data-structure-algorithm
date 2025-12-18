package com.centroid.dsalgo.binarysearch;

import java.util.Arrays;

public class BoundarySearch {
    static int lastOccurrence(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int answer = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                answer = mid;        // record candidate
                left = mid + 1;      // keep searching right
            } else if (arr[mid] < target) {
                left = mid + 1;      // discard left half
            } else {
                right = mid - 1;     // discard right half
            }
        }
        return answer;
    }

    // First Occurance or ExactMatch:
    public static int ExactMatch(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;

        while (left <= right){
            int mid = left + (right - left)/2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] numbers = {2, 4, 7, 7, 7, 10, 13};
        System.out.println(Arrays.toString(numbers));
        System.out.println(lastOccurrence(numbers, 7));
    }
}

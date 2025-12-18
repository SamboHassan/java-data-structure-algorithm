package com.centroid.dsalgo.binarysearch;

import java.util.Arrays;

//Non-static method 'binarySearch(int[], int)' cannot be referenced
// from a static context
public class ExactMatch {

    // Uses binary search to efficiently find a target value in a sorted array by
    // repeatedly narrowing the search range in half
    // Defines a method that searches for a target value in a sorted array
    // First Occurrence (Leftmost) aka: ExactMatch
    static int binarySearch(int[] arr, int target) {
        // Initialize the left boundary of the search range
        int left = 0;
        // Initialize the right boundary of the search range
        int right = arr.length - 1;
        // Continue searching while the range is valid
        while (left <= right) {
            // Calculate the middle index of the current range safely
            int mid = left + (right - left) / 2;
            // If the middle element is the target, return its index
            if (arr[mid] == target) return mid;
            // If the middle element is smaller than the target, search the right half
            if (arr[mid] < target) left = mid + 1;
            // Otherwise, search the left half
            else right = mid - 1;
        }
        // Return -1 if the target is not found in the array
        return -1;
    }

    public static void main(String[] args) {
        int[] numbers = {2, 4, 7, 7, 7, 10, 13};
        System.out.println(Arrays.toString(numbers));
        System.out.println(binarySearch(numbers, 7));
    }

}


//    Why It Is Efficient
//
//    Linear search checks every element → O(n)
//
//        Binary search checks log₂(n) elements → O(log n)
//
//        For 1,000,000 elements:
//
//        Linear search ≈ 1,000,000 checks
//
//        Binary search ≈ 20 checks
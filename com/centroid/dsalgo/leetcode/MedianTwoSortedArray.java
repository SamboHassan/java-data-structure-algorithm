package com.centroid.dsalgo.leetcode;
/*
4. Median of Two Sorted Arrays

Given two sorted arrays nums1 and nums2 of size m and n respectively, return
the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).
Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.


Constraints:

nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106
 */
public class MedianTwoSortedArray {
    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array to minimize binary search range
        if (nums1.length > nums2.length) {
            // Swap arrays by recursively calling the method with reversed arguments
            return findMedianSortedArrays2(nums2, nums1);
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
            // Compute partition index for nums2 so left partitions contain half
            // the elements
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

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int x = nums1.length;
        int y = nums2.length;
        int start = 0;
        int end = x;
        while (start <= end) {
            int partX = (start + end) / 2;
            int partY = (x + y + 1) / 2 - partX;
            int xLeft = partX == 0 ? Integer.MIN_VALUE : nums1[partX - 1];
            int xRight = partX == x ? Integer.MAX_VALUE : nums1[partX];
            int yLeft = partY == 0 ? Integer.MIN_VALUE : nums2[partY - 1];
            int yRight = partY == y ? Integer.MAX_VALUE : nums2[partY];
            if (xLeft <= yRight && yLeft <= xRight) {
                if ((x + y) % 2 == 0) {
                    return ((double) Math.max(xLeft, yLeft) + Math.min(xRight, yRight)) / 2;
                }
                else {
                    return Math.max(xLeft, yLeft);
                }
            }
            else if (xLeft > yRight) {
                end = partX - 1;
            }
            else {
                start = partX + 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        //        Input: nums1 = [1,2], nums2 = [3,4]
        //        Output: 2.50000
        // Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}

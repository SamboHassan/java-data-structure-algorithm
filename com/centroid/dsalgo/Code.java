package com.centroid.dsalgo;

import java.sql.Array;
import java.sql.PreparedStatement;
import java.util.*;

//POINTER =
//https://www.youtube.com/c/DestinationFAANG
//https://www.youtube.com/watch?v=T0u5nwSA0w0   -- Neetcode 150
public class Code {
    public static int exactMatchBS(int[] numbers, int target){
        int left = 0;
        int right = numbers.length - 1;
        while (left <= right){
            int mid = left + (right - left)/2;
            if (numbers[mid] == target) return mid;
            if (numbers[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    public static int firstOccurrence(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int answer = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                answer = mid;        // record candidate
                right = mid - 1;     // keep searching left
            } else if (arr[mid] < target) {
                left = mid + 1;      // discard left half
            } else {
                right = mid - 1;     // discard right half
            }
        }
        return answer;
    }


    public static void main(String[] args) {
        int[] arrays = {2, 4, 7, 7, 7, 10, 13};
        System.out.println(exactMatchBS(arrays, 7));
        System.out.println(firstOccurrence(arrays, 7));
    }
}

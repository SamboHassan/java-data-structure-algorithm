package com.centroid.dsalgo;

import java.sql.PreparedStatement;
import java.util.*;

//POINTER =
//https://www.youtube.com/c/DestinationFAANG
//https://www.youtube.com/watch?v=T0u5nwSA0w0   -- Neetcode 150
public class Code {
    public static int[] twoSum(int[] numbers, int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0 ; i< numbers.length ; i++){
            int complement = target - numbers[i];
            if (map.containsKey(complement)){
                return new int[]{map.get(complement), i};
            }
            map.put(map.get(complement), i);
        }
        return new int[]{};
    }
    public static void main(String[] args) {

//        System.out.println(isAnagram("tac", "caT"));
//        System.out.println(isAnagram("Silent", "Talent"));
//        int[] numbers = {3,4,5,6,7,7,7,};
//        boolean result = hasDuplicate(numbers);
//        System.out.println(result);
        int[] arr = {2,5,7,8,2};
        int[] answer = twoSum(arr, 10);
        System.out.print(Arrays.toString(answer));

    }
}

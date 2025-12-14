package com.centroid.dsalgo;

import java.sql.Array;
import java.sql.PreparedStatement;
import java.util.*;

//POINTER =
//https://www.youtube.com/c/DestinationFAANG
//https://www.youtube.com/watch?v=T0u5nwSA0w0   -- Neetcode 150
public class Code {
       public static int[] productExceptSelf(int[] numbers){
           int[] result = new int[numbers.length];
           Arrays.fill(result, 1);

           int prefix = 1;
           for (int i = 0; i<numbers.length ; i++){
               result[i] = prefix;
               prefix = prefix * numbers[i];
           }
           //Postfix pass
           int postfix = 1;
           for (int i = numbers.length - 1 ; i >= 0 ; i--){
               result[i] = postfix * result[i];
               postfix = postfix * numbers[i];
           }
           return result;
       }


    public static void main(String[] args) {

        int[] test = {2,3,4,3,2};
        System.out.println(Arrays.toString(productExceptSelf(test)));
//        System.out.println(isAnagram("tac", "caT"));
//        System.out.println(isAnagram("Silent", "Talent"));
//        int[] numbers = {3,4,5,6,7,7,7,};
//        boolean result = hasDuplicate(numbers);
//        System.out.println(result);
//        int[] arr = {2,5,7,8,2};
//        int[] answer = twoSum(arr, 10);
//        System.out.print(Arrays.toString(answer));

    }
}

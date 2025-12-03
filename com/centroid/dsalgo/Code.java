package com.centroid.dsalgo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;

public class Code {
    public static boolean isAnagram(String s, String t){
        if (s.length() != t.length()){
            return false;
        }
        s = s.toLowerCase().replace(" ", "");
        t = t.toLowerCase().replace(" ", "");

        int[] count = new int[26];

        for (int i = 0 ; i<s.length() ; i++){
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for (int i = 0 ; i<26 ; i++){
            if (count[i] != 0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {

        System.out.println(isAnagram("tac", "caT"));
        System.out.println(isAnagram("Silent", "Talent"));

    }
}

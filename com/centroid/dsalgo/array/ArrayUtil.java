package com.centroid.dsalgo.array;

public class ArrayUtil {
    public void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public int[] resize(int[] arr, int capacity){
        int[] temp = new int[capacity];
        for (int i=0; i<arr.length; i++){
            temp[i] = arr[i];
        }
        return temp;
    }

    public static int findMissingNumber(int[] arr){
        int n = arr.length + 1;
        int sum = n * (n + 1) / 2;
        for (int num : arr){
            sum = sum - num;
        }
        return sum;
    }

    public static void main(String[] args) {
        ArrayUtil arrayUtil = new ArrayUtil();
//        arrayUtil.printArray(new int[] {5,1,2,9,10});
        int[] original = new int[] {5,1,2,9,10};
        System.out.println("The size of the array is: " + original.length);
        original = arrayUtil.resize(original, 10);
        System.out.println("The size of the array is: " + original.length);
        int[] arr = new int[]{1,3,6,8,2,4,7};
        System.out.println(findMissingNumber(arr));

    }
}

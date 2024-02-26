package com.centroid.dsalgo.array;

public class MoveZeros {
    public void printArray(int[] arr){
        int n = arr.length;
        for (int i=0; i<n; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public void arrayDemo(){
        int[] arr = {0,8,1,0,2,1,0,3};
        printArray(arr);
        moveZeros(arr, arr.length);
        printArray(arr);
    }

  public void moveZeros(int[] arr, int n){
        int j = 0;
        for (int i=0; i<n; i++){
            if (arr[j] != 0){
                j++;
            }
            if (arr[i] != 0 && arr[j] == 0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
  }



//    public void moveZeros(int[] arr, int n){
//       int j = 0; //j pointer will keep track of the zeroth element
//       for (int i=0; i<n; i++){
//           if (arr[i] != 0 && arr[j] == 0){ // i will focus on non zero elements
//               int temp = arr[i];
//               arr[i] = arr[j];
//               arr[j] = temp;
//           }
//           // Since j will only focus on zeroth element, we move on to next element
//           // if arr[j] is not zero
//           // Otherwise we stay to do a swap
//           if (arr[j] != 0){
//               j++;
//           }
//       }
//    }

    public static void main(String[] args) {
        MoveZeros arrUtil = new MoveZeros();
        arrUtil.arrayDemo();
    }
}

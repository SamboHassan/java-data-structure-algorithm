package com.centroid.dsalgo.array;

public class TimeComplexityDemo {

    public static void main(String[] args) {
        double now = System.currentTimeMillis();
        TimeComplexityDemo demo = new TimeComplexityDemo();
        System.out.println(demo.findSum(5));
        System.out.println("Time taken: " + (System.currentTimeMillis() - now) + " milliseconds");

    }

//    public int findSum(int n){
//        return n * (n+1)/2;
//    }


    // for(int i = 1; i<=n; n++) This is 3  operations: create i and assign 1 = 1 operation
    // accessing i and n = 2 operation
    // comparing i and n = 1 operation
    // Therefore (i<=n) alone is 3 operations => 1 + 3(n+1)
    // Secondly i++ takes 3 operations, 1-accessing i, 2-incrementing i by 1, 3-assigning back to i => 3n operations
    // Therefore total becomes: 1+3(n+1)+3n
    // sum = sum + i => 4 operations: access sum, access sum, access i, add i to sum.
    // And since (sum = sum + i) will repeat n times => 4n
    // Time Complexity = O(n) where n is input


   public int findSum(int n){
        int sum = 0;
        for (int i=1; i<=n; i++){
            sum += i;
        }
        return sum;
   }
}

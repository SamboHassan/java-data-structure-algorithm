package com.centroid.dsalgo.binarysearch;

/*
The 4 Practical Types of Binary Search

1. Exact-Match Binary Search
Purpose:
Find the index of a value that exactly equals the target.
Question it answers: “Does this value exist, and where?”

Key invariant:
If the target exists, it is always inside [left, right].

Typical use cases:
Searching in a sorted array, Dictionary lookup, Index lookup

2. Boundary Binary Search (First / Last Occurrence)
Purpose:
Find where a value starts or ends in the array.
Question it answers: “Where is the leftmost or rightmost position of this value?”

Key invariant:
One side is guaranteed invalid; the other still may contain the boundary.

Typical use cases:
Counting duplicates, Range queries, Index compression

This includes:
First occurrence
Last occurrence
Lower bound
Upper bound

3. Binary Search on Answer (Search Space Binary Search)

Purpose:
Find the smallest or largest value that satisfies a condition.
Question it answers: “What is the minimum / maximum value that makes
this condition true?”

Key invariant:
The answer lies between left and right, and condition(mid) is monotonic.

Typical use cases:
Minimum speed / capacity / days
Scheduling problems
Optimization problems

4. Modified Binary Search (Non-Standard Arrays)

Purpose:
Search in arrays that are not fully sorted but have structure.
Question it answers: “Which half can I safely discard?”

Key invariant:
At least one half of the data is always ordered or predictable.

Typical use cases:
Rotated sorted arrays
Peak finding
Bitonic arrays
Why These Are the Only Ones That Matter
Every “binary search” problem you will encounter is a variation of one of these four.
Even advanced problems reduce to:
choosing the right invariant
choosing the right update rule

----------------------------------------------------------------------------------------
One Rule to Remember

If the problem asks “where exactly?” → Exact or Boundary
If it asks “how small / how big?” → Binary Search on Answer
 */



/*

Below is a clean, professional mapping of common LeetCode problems to each
binary search type, exactly as they appear in interviews and competitive programming.
This mapping is intentionally curated to help you recognize the pattern instantly.


1. Exact-Match Binary Search

Pattern: “Find this value.”
Key signal words: find, search, exists
Common LeetCode Problems
704. Binary Search
35. Search Insert Position (exact match part)
367. Valid Perfect Square
374. Guess Number Higher or Lower

Why These Fit
Array (or space) is sorted
Single correct index or result
No duplicates handling needed

2. Boundary Binary Search (First / Last / Bounds)

Pattern: “Find where it starts or ends.”
Key signal words: first, last, leftmost, rightmost, range
Common LeetCode Problems
34. Find First and Last Position of Element in Sorted Array
278. First Bad Version
162. Find Peak Element
69. Sqrt(x) (integer boundary)
744. Find Smallest Letter Greater Than Target

Why These Fit
Multiple valid candidates exist
You must keep searching after a match
Requires careful invariant management


3. Binary Search on Answer (Search Space)

Pattern: “Find the minimum or maximum value that works.”

Key signal words: minimum, maximum, capacity, speed, days
Common LeetCode Problems
875. Koko Eating Bananas
1011. Capacity To Ship Packages Within D Days
410. Split Array Largest Sum
1482. Minimum Number of Days to Make m Bouquets
1539. Kth Missing Positive Number

Why These Fit
Answer is not directly in the array
You can test a guess using can(mid)
Condition is monotonic (false → true or true → false)


4. Modified Binary Search (Special Structure)

Pattern: “Array is not fully sorted, but half is predictable.”
Key signal words: rotated, peak, mountain

Common LeetCode Problems
33. Search in Rotated Sorted Array
81. Search in Rotated Sorted Array II
153. Find Minimum in Rotated Sorted Array
154. Find Minimum in Rotated Sorted Array II
852. Peak Index in a Mountain Array

Why These Fit
One half can always be discarded safely
Requires detecting which half is ordered

Quick Recognition Table
---------------------------------------------------------------
Question Asks	                            Binary Search Type
---------------------------------------------------------------
Does this value exist?	                    Exact
Where does it start/end?	                Boundary
What is the smallest/largest valid value?	On Answer
Which half can I discard?	                Modified

Strong Recommendation for Mastery

If you master these five problems, you will recognize 80% of binary search
questions instantly:

704 – Binary Search
34 – First and Last Position
278 – First Bad Version
875 – Koko Eating Bananas
33 – Search in Rotated Sorted Array
 */

public class BinaryAlgorithms {
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

    public static int exact(int[] numbers, int target){
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
                right = mid - 1;     // keep searching left - move left
            } else if (arr[mid] < target) {
                left = mid + 1;      // discard left half
            } else {
                right = mid - 1;     // discard right half
            }
        }
        return answer;
    }

    public static int lastOccurrence(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int answer = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                answer = mid;
                left = mid + 1;      // move right
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }

    public static int countOccurrences(int[] arr, int target) {
        int first = firstOccurrence(arr, target);
        if (first == -1) return 0;   // target not found

        int last = lastOccurrence(arr, target);
        return last - first + 1;
    }
//    [1, 2, 2, 2, 2, 3, 4] target = 2
//    firstOccurrence = 1
//    lastOccurrence = 4
//    count = 4 - 1 + 1 = 4
    /*

    Why This Works
    Binary search is adapted to find boundaries, not just existence.
    First occurrence → shift right boundary left
    Last occurrence → shift left boundary right
    You exploit the sorted order to eliminate half the search space each time.
     */

}

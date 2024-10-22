package main.java.week_35_spring_rest;

public class SlidingWindowSample {

    /*
    The problem gives us an array of length n and a number k. The problem asks us to find the maximum sum of k
    consecutive elements inside the array.
     */
    public static void main(String[] args) {
//        int[] nums = {1, 3, 2, 4, 6, 1, 2, 1};     // k = 3  result = 12
        int[] nums = {5, 7, 1, 4, 3, 6, 2, 9, 2};    // k = 5  result = 24
        int k = 5;
        System.out.println(withNestedLoop(nums, k));
        System.out.println(withSlidingWindow(nums, k));
    }

    /*
    The outer loop iterates over each possible starting index of a subarray of length k, from 0 to n-k.
    The inner loop then calculates the sum of the elements in the subarray starting from the current index,
    and updates the maximum sum seen so far.
    Note that this solution has a time complexity of O(n * k), since for each of the n-k+1 possible subarrays,
    we need to sum up k elements.
     */
    public static int withNestedLoop(int[] nums, int k) {
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i <= n - k; i++) {
            int sum = 0;
            for (int j = i; j < i + k; j++) {
                sum += nums[j];
            }
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

    /*
    Edge Cases Handling: If the array is empty (n == 0) or if k is greater than the length of the array (k > n),
    return 0 since a valid window cannot be formed.

    Initial Window Sum Calculation: The first loop calculates the sum of the first k elements. This sets up the initial window sum.

    Sliding the Window: The second loop starts from index k and slides the window one element at a time.
    The element at the start of the previous window (nums[i - k]) is subtracted, and the new element at the end of the
    current window (nums[i]) is added. maxSum is updated if currentSum is greater.
     */
    public static int withSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0 || k > n) return 0;  // handle edge cases

        int currentSum = 0;
        for (int i = 0; i < k; i++) {
            currentSum += nums[i];
        }

        int maxSum = currentSum;

        for (int i = k; i < n; i++) {
            currentSum += nums[i] - nums[i - k];  // slide the window
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

}

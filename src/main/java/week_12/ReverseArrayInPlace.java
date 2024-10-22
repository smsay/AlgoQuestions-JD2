package main.java.week_12;

/*
REVERSE ARRAY IN PLACE
Write a method that reverses an array of integers in place The reversion should be
performed directly on the original array without using any additional arrays. (Not necessary
to have a return type method since the modification is done in place and a swap algorithm
might be a good approach)

Example 1
Input: [1, 2, 3, 4, 5]
Output: [5, 4, 3, 2, 1]

Example 2
Input 150
Output 150

Constraints
The given array is not empty.
1 <= nums.length <= 1000
-10^6 <= nums[i] <= 10^6
 */

import java.util.Arrays;

public class ReverseArrayInPlace {

    public static void reverseArrayInPlace(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            // Swap elements at left and right indices
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            // Move indices towards the center
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        // Example 1
        int[] array1 = {1, 2, 3, 4, 5};
        reverseArrayInPlace(array1);
        System.out.println(Arrays.toString(array1));
        // Output: [5, 4, 3, 2, 1]

        // Example 2
        int[] array2 = {150};
        reverseArrayInPlace(array2);
        System.out.println(Arrays.toString(array2));
        // Output: [150]
    }
}

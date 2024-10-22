package main.java.week_33_Trees_TicketingSecurity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class SingleNumber {
    /*
    Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

Example 1:
Input: nums = [2,2,1]
Output: 1

Example 2:
Input: nums = [4,1,2,1,2]
Output: 4

Example 3:
Input: nums = [1]
Output: 1

Constraints:
    1 <= nums.length <= 3 * 10^4
    -3 * 10^4 <= nums[i] <= 3 * 10^4
    Each element in the array appears twice except for one element which appears only once.
  Follow-up question: Can you implement a solution with a linear runtime complexity and use only constant extra space?
    https://leetcode.com/problems/single-number/
     */

    public static void main(String[] args) {
        System.out.println(withXOR(new int[]{4, 1, 2, 1, 2}));
    }

    @Test
    public void BruteForce_Test() {
        Assertions.assertEquals(1, bruteForce(new int[]{2, 2, 1}));
        Assertions.assertEquals(4, bruteForce(new int[]{4, 1, 2, 1, 2}));
        Assertions.assertEquals(1, bruteForce(new int[]{1}));

        int[] ints = new int[29_999];
        int middle = (ints.length-11)/2;
        for (int i = 0; i < middle; i++) {
            ints[i] = i;
        }
        for (int i = middle; i < ints.length-11; i++) {
            ints[i] = i - middle;
        }
        int l = ints.length;
        ints[l-11] = -29688;    ints[l-10] = 29566;     ints[l-9] = -29688;
        ints[l-8] = 29566;      ints[l-7] = 30000;      ints[l-6] = 30000;
        ints[l-5] = 29999;      ints[l-4] = 1;          ints[l-3] = 2;
        ints[l-2] = 1;          ints[l-1] = 2;

        Assertions.assertEquals(29999, bruteForce(ints));
    }

    public static Stream<Arguments> inputs() {
        int[] ints = new int[29_999];
        int middle = (ints.length-11)/2;
        for (int i = 0; i < middle; i++) {
            ints[i] = i;
        }
        for (int i = middle; i < ints.length-11; i++) {
            ints[i] = i - middle;
        }
        int l = ints.length;
        ints[l-11] = -29688;    ints[l-10] = 29566;     ints[l-9] = -29688;
        ints[l-8] = 29566;      ints[l-7] = 30000;      ints[l-6] = 30000;
        ints[l-5] = 29999;      ints[l-4] = 1;          ints[l-3] = 2;
        ints[l-2] = 1;          ints[l-1] = 2;

        return Stream.of(
                arguments(1, new int[]{2, 2, 1}),
                arguments(4, new int[]{4, 1, 2, 1, 2}),
                arguments(1, new int[]{1}),
                arguments(29999, ints)
        );
    }

    @ParameterizedTest
    @MethodSource(value = "inputs")
    public void bruteForceTest(int expected, int[] input){
        Assertions.assertEquals(expected, bruteForce(input));
    }

    // TC O(n^2) SC O(1)
    static int bruteForce(int[] nums) {

        for (int num : nums) {
            int count = 0;
            for (int i : nums) {
                if (num == i) {
                    count++;
                }
            }
            if (count == 1) return num;
        }

        return Integer.MIN_VALUE;
    }

    @ParameterizedTest
    @MethodSource(value = "inputs")
    public void withSorting_Test(int expected, int[] input){
        Assertions.assertEquals(expected, withSorting(input));
    }

    // Sorting + Linear traversal
    // TC O(n log (n) ) SC O(1)
    //TC = O(n log n)[because of sorting] + O(n/2)[traversing every other element of array] = O(n log n)
    static int withSorting(int[] nums) {
        Arrays.sort(nums);  // 1,1,2,2,3, 4,4   n log n
        for (int i = 0; i < nums.length - 1; i += 2) {    //i+=2 as we want to check every other element
            if (nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return nums[nums.length - 1];   //if we didn't find answer in the loop, return the last element.
    }

    @ParameterizedTest
    @MethodSource(value = "inputs")
    public void withList_Test(int expected, int[] input){
        Assertions.assertEquals(expected, withList(input));
    }
    // TC O(n^2)  SC O(n)
    static int withList(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for (Integer num : nums) {
            if (list.contains(num)) {
                list.remove(num);
            } else {
                list.add(num);
            }
        }
        return list.get(0);
    }

    @ParameterizedTest
    @MethodSource(value = "inputs")
    public void withSet_Test(int expected, int[] input){
        Assertions.assertEquals(expected, withSet(input));
    }
    // TC O(n)  SC O(n)
    static int withSet(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)){
                set.remove(num);
            }
//            if (set.contains(num))
//                set.remove(num);
//            else
//                set.add(num);
        }
        return set.stream().findFirst().orElseThrow(); // Single Number;
//        return set.iterator().next(); // Single Number;
        // return (int) set.toArray()[0];
    }

    @ParameterizedTest
    @MethodSource(value = "inputs")
    public void withMap_Test(int expected, int[] input){
        Assertions.assertEquals(expected, withMap(input));
    }
    // TC O(n)  SC O(n)
    public int withMap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
//            if (map.containsKey(num))
//                map.replace(num, map.get(num), map.get(num) + 1);
//            else
//                map.put(num, 1);
        }

        for (int num : nums) {
            if (map.get(num) == 1)
                return num;
        }
        return Integer.MIN_VALUE;
    }


    // other solutions:
    @ParameterizedTest
    @MethodSource(value = "inputs")
    public void withXOR_Test(int expected, int[] input){
        Assertions.assertEquals(expected, withXOR(input));
    }

    /*
    Bit Manipulation (XOR)
    Concept :
XOR of zero and some bit returns that bit i.e. x^0 = x...
XOR of two same bits returns 0 i.e. x^x = 0...
And, x^y^x = (x^x)^y = 0^y = y...
XOR all bits together to find the unique number.

-If we use XOR operator between two same values, it will return zero.
-If one of the value is zero, and the other is non-zero, it returns the non-zero value.

XOR
X^X = 0
0^X = X

Let's see some rules:
0^A=A
A^A=0
A^B^A=B
(A^A^B) = (B^A^A) = (A^B^A) = B This shows that position doesn't matter.
Similarly , if we see , A^A^A.. with (even times)=0 and A^A^A.. with (odd times)=A

We apply the above observations :

Because, the elements with frequency=2 will result in 0. And then the only element with frequency=1 will generate the answer.

Our array is : {4,1,2,1,2}
4^1
4^1^2
4^1^2^1 ->[1^1=0]
4^2
4^2^2 -> [2^2=0]
4
So, the element which we got as left should be our answer, so the answer is '4'
     */

    //Time complexity: O(n), Space complexity: O(1)
    static int withXOR(int[] nums) {
        int value = 0;
        for (int num : nums) {
            value = value ^ num;
        }
        return value;
    }

    @ParameterizedTest
    @MethodSource(value = "inputs")
    public void withXOR2_Test(int expected, int[] input){
        Assertions.assertEquals(expected, withXOR2(input));
    }
    static int withXOR2(int[] nums) {
        int value = 0;
        for (int i : nums) {
            value ^= i;
        }
        return value;
    }

}

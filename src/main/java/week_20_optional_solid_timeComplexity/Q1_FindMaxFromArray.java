package main.java.week_20_optional_solid_timeComplexity;

import java.util.Arrays;

public class Q1_FindMaxFromArray {
     /*
    Write a function that can find the maximum number from an int Array.
    input:  int[] array = {6, 8, 3, 5, 1, 9};		output: 9
     */

    public static void main(String[] args) {
        int[] array = {6, 8, 3, 5, 1, 9};
        System.out.println(maxValueWithStream(array));
        System.out.println(maxValueWithStream(new int[1]));
        System.out.println(maxValueWithStream(new int[0]));
        System.out.println(maxValueWithStream(null));
    }

    public static int maxValue(int[] array) {
        if (array == null || array.length == 0)
            throw new IllegalArgumentException("input must contain int array with at least one element");
        int max = Integer.MIN_VALUE;
        for (int each : array) {
//            if (each > max) {
//                max = each;
//            }
            max = Math.max(each, max);
        }
        return max;
    }

    public static int maxValueWithStream(int[] array) {
        if (array == null || array.length == 0)
            throw new IllegalArgumentException("input must contain int array with at least one element");
        return Arrays.stream(array).reduce(Integer.MIN_VALUE, Integer::max);
    }

    public static int maxValueWithStream2(int[] array) {
        if (array == null || array.length == 0)
            throw new IllegalArgumentException("input must contain int array with at least one element");
        return Arrays.stream(array).max().getAsInt();
    }

}

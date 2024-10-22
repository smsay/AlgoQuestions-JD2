package main.java.week_26_LinkedList_TicketingMVCPart2;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class ExcelSheetColumnNumber {
    /*
    171. Excel Sheet Column Number
    Given a string columnTitle that represents the column title as appears in an Excel sheet, return its corresponding column number.

For example:
A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28
...

Example 1:
Input: columnTitle = "A"
Output: 1

Example 2:
Input: columnTitle = "AB"
Output: 28

Example 3:
Input: columnTitle = "ZY"
Output: 701

Constraints:
    1 <= columnTitle.length <= 7
    columnTitle consists only of uppercase English letters.
    columnTitle is in the range ["A", "FXSHRXW"].

leetcode link : https://leetcode.com/problems/excel-sheet-column-number/
     */

    public static void main(String[] args) {
        System.out.println(forLoopStartingFromEnd("A"));    // 1
        System.out.println(forLoopStartingFromEnd("AB"));   // 28
        System.out.println(forLoopStartingFromEnd("ZY"));   // 701
        System.out.println(forLoopStartingFromEnd("FXSHRXW"));  // 2147483647

        System.out.println(forLoopFromBeginning("A"));    // 1
        System.out.println(forLoopFromBeginning("AB"));   // 28
        System.out.println(forLoopFromBeginning("ZY"));   // 701
        System.out.println(forLoopFromBeginning("FXSHRXW"));  // 2147483647
    }

    // TC : O (n) SC : O (1)    n = columnTitle.length()
    static int forLoopStartingFromEnd(String title) {
        int total = 0;
        int multiplier = 1;
        for (int i = title.length() - 1; i >= 0; i--) {
            total += (title.charAt(i) - 'A' + 1) * multiplier;
            multiplier = multiplier * 26;
        }
        return total;
    }

//    For every additional digit of the string, we multiply the value of the digit by 26^n where n is the number of digits
//    it is away from the one's place. This is similar to how the number 254 could be broken down as this: (2 x 10 x 10) + (5 x 10) + (4).
//    The reason we use 26 instead of 10 is because 26 is our base.
//    For title = "BCM" the final solution would be (2 x 26 x 26) + (3 x 26) + (13)
//    We could do this process iteratively. Start at looking at the first digit "B". Add the int equivalent of "B"
//    to the running sum and continue. Every time we look at the following digit multiply our running sum by 26
//    before adding the next digit to signify we are changing places. Example below:
//            "B" = 2
//            "BC" = (2)26 + 3
//            "BCM" = (2(26) + 3)26 + 13

    // TC : O (n) SC : O (1)    n = columnTitle.length()
    public static int forLoopFromBeginning(String title) {
        int result = 0;
        int p = title.length() - 1;

        for (char c : title.toCharArray()) {
            result += (c - 'A' + 1) * Math.pow(26, p--);
        }

        return result;
    }

    @Test
    public void forLoopStartingFromEnd_Test(){
        Assertions.assertEquals(1, forLoopStartingFromEnd("A"));
        Assertions.assertEquals(28, forLoopStartingFromEnd("AB"));
        Assertions.assertEquals(701, forLoopStartingFromEnd("ZY"));
        Assertions.assertEquals(2147483647, forLoopStartingFromEnd("FXSHRXW"));
    }

    public static Stream<Arguments> inputs(){
        return Stream.of(
                arguments(1, "A"),
                arguments(28, "AB"),
                arguments(701, "ZY"),
                arguments(2147483647, "FXSHRXW")
        );
    }

    @ParameterizedTest
    @MethodSource(value = "inputs")
    public void forLoopStartingFromEnd_Test(int expected, String input){
        Assertions.assertEquals(expected, forLoopStartingFromEnd(input));
    }

    @ParameterizedTest
    @MethodSource(value = "inputs")
    public void forLoopStartingFromBeginning_Test(int expected, String input){
        Assertions.assertEquals(expected, forLoopFromBeginning(input));
    }



    // other solutions
    // TC : O (n) SC : O (1)    n = columnTitle.length()
    public static int withRecursion(String title) {
        if (title.length() == 0) return 0;
        return (title.charAt(title.length() - 1) - 'A' + 1)
                + 26 * withRecursion(title.substring(0, title.length() - 1));
    }

}

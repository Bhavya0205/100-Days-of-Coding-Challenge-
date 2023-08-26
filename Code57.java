/*
Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.

 

Example 1:

Input: num = 38
Output: 2
Explanation: The process is
38 --> 3 + 8 --> 11
11 --> 1 + 1 --> 2 
Since 2 has only one digit, return it.
Example 2:

Input: num = 0
Output: 0
 

Constraints:

0 <= num <= 231 - 1
 */
public class Code57 {
    public static int addDigits(int num) {
        if(num == 0)
            return 0;
        else if(num % 9 == 0)
            return 9;
        else 
            return num % 9;
    }

    public static void main(String args[]){
        int num=38;

        System.out.println(addDigits(num));
    }
}

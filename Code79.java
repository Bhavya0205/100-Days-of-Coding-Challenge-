/*
Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.

Note that after backspacing an empty text, the text will continue empty.

 

Example 1:

Input: s = "ab#c", t = "ad#c"
Output: true
Explanation: Both s and t become "ac".
Example 2:

Input: s = "ab##", t = "c#d#"
Output: true
Explanation: Both s and t become "".
Example 3:

Input: s = "a#c", t = "b"
Output: false
Explanation: s becomes "c" while t becomes "b".
 

Constraints:

1 <= s.length, t.length <= 200
s and t only contain lowercase letters and '#' characters.
 */

import java.util.Stack;

public class Code79 {
    public static boolean backspaceCompare(String s, String t) {
        // Use stacks to simulate the typing process
        Stack<Character> stackS = new Stack<>();
        Stack<Character> stackT = new Stack<>();

        // Process string S
        for (char c : s.toCharArray()) {
            if (c != '#') {
                stackS.push(c);  // Push character onto the stack
            } else if (!stackS.isEmpty()) {
                stackS.pop();  // Pop if it's a backspace and the stack is not empty
            }
        }

        // Process string T
        for (char c : t.toCharArray()) {
            if (c != '#') {
                stackT.push(c);  // Push character onto the stack
            } else if (!stackT.isEmpty()) {
                stackT.pop();  // Pop if it's a backspace and the stack is not empty
            }
        }

        // Compare the contents of the two stacks
        return stackS.equals(stackT);
    }

     public static void main(String args[]){
        String s="ab#c";
        String t="ad#c";

        System.out.println(backspaceCompare(s,t));
     }
}

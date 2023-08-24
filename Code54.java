/*
Given a string s, return true if the s can be palindrome after deleting at most one character from it.

 

Example 1:

Input: s = "aba"
Output: true
Example 2:

Input: s = "abca"
Output: true
Explanation: You could delete the character 'c'.
Example 3:

Input: s = "abc"
Output: false
 

Constraints:

1 <= s.length <= 105
s consists of lowercase English letters.
 */
public class Code54 {
    public static boolean validPalindrome(String s) {
        if(s == null || s.length() < 1){
            return false;
        }

        int start=0;
        int end=s.length()-1;
        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                return palindromeCheck(s,start,end-1) || palindromeCheck(s,start+1,end);
            }
            start++;
            end--;
        }
        return true;
    }

    public static boolean palindromeCheck(String s, int leftIndex, int rightIndex){
        int start=leftIndex;
        int end=rightIndex;
        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String args[]){
        String s="aba";

        System.out.println(validPalindrome(s));
    }
}

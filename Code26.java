/*

VALID PALINDROME
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

 

Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
Example 3:

Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.
 

Constraints:

1 <= s.length <= 2 * 105
s consists only of printable ASCII characters.
 */
public class Code26 {
    public static boolean isPalindrome(String s) {
        if(s.isEmpty()){
            return true;
        }

        int start=0;
        int end=s.length()-1;
        while(start <= end){
            char curr_First=s.charAt(start);
            char curr_Last=s.charAt(end);
            if (!Character.isLetterOrDigit(curr_First)){
                start++;
            }
            else if(!Character.isLetterOrDigit(curr_Last)){
                end--;
            }
            else{
                if(Character.toLowerCase(curr_First) != Character.toLowerCase(curr_Last)){
                    return false;
                }
                start++;
                end--;
            }
        }
        return true;
    }
    
    public static void main(String args[]){
        String s="A man, a plan, a canal: Panama";

        System.out.println(isPalindrome(s));
    }
}

/*

Longest Palindromic String 
Given a string s, return the longest 
palindromic
 
substring
 in s.

 

Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
 

Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters.
 */
public class Code28 {
    public static String longestPalindrome(String s) {
        int start =0,end=0;
        for(int i=0;i<s.length();i++){
            
            int len1= extendPel(s,i,i);
            int len2=extendPel(s,i,i+1);
            int len =Math.max(len1,len2);
//  we can also do (len> end-start) in below if but it will give last occurence of a same length substring and
//  (len>end-start+1) will give first occurence of same length substring.
            if(len>(end-start)+1){   
                start=i-(len-1)/2;
                end=i+len/2;
            }
        }
        return s.substring(start,end+1);
    }
    static int extendPel(String s,int i,int j){
        while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){
            i--;
            j++;
        }
        return j-i-1;  //some people think that this length should be j-i+1 but we need to j-i+1-2 because in last
                       // itreation we comapred two unmatched charact
    }

    public static void main(String args[]){
        String s="babad";

        System.out.println(longestPalindrome(s));
    }
}

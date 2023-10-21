/*
Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

 

Example 1:

Input: s = "abc", t = "ahbgdc"
Output: true
Example 2:

Input: s = "axc", t = "ahbgdc"
Output: false
 

Constraints:

0 <= s.length <= 100
0 <= t.length <= 104
s and t consist only of lowercase English letters
 */
public class Code103 {
    public static boolean isSubsequence(String s, String t) {
        int sSz = s.length(), tSz = t.length();
        if(sSz > tSz) return false; 
        //a variable to point to curr character of sub seq 's'
        int sIndx = 0;
        //traverse over the given string
        for(int indx = 0; indx < tSz && sIndx < sSz; indx ++){
            if(t.charAt(indx) == s.charAt(sIndx)){
                sIndx++;
            }
        }
        return sIndx == sSz;
    }

    public static void main(String args[]){
        String s="abc";
        String t="ahbgdc";

        System.out.println(isSubsequence(s,t));
    }
}

/* 

LONGEST COMMON PREFIX


Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

 

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 

Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters. */
import java.util.*;
class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String s1= strs[0];
        String s2= strs[strs.length-1];
        int index=0;
        while(index < s1.length() && index < s2.length()){{
            if(s1.charAt(index) == s2.charAt(index))
                index++;
            else
                break;
        }
    }

    return s1.substring(0,index);
    }

    /**
     * @param args
     */
    public static void main(String args[]){
        final int strs[]={"flower","flow","flight"};

        System.out.println(longestCommonPrefix(strs));


    }
}
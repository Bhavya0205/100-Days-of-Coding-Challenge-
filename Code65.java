/*
Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

 

Example 1:

Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false
 

Constraints:

1 <= s.length <= 300
1 <= wordDict.length <= 1000
1 <= wordDict[i].length <= 20
s and wordDict[i] consist of only lowercase English letters.
All the strings of wordDict are unique
 */

import java.util.List;

public class Code65 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean [] dp = new boolean[len];
        for(int k = 0; k < len; k++)
        {
            for(int j = 0; j <= k; j++)
            {
                if((j == 0 || dp[j-1] == true) && wordDict.contains(s.substring(j, k + 1)))
                {
                    dp[k] = true;
                    break;
                }
            }
        }
        return dp[len-1];
    }

    public static void main(String args[]){
        String s="leetcode";
        char[] wordDict=["leet","code"];


    }
}

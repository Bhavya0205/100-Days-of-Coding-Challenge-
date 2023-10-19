/*
Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.

 

Example 1:

Input: s = "leetcode"
Output: 0
Example 2:

Input: s = "loveleetcode"
Output: 2
Example 3:

Input: s = "aabb"
Output: -1
 

Constraints:

1 <= s.length <= 105
s consists of only lowercase English letters.
 */
public class Code101 {
    public static int firstUniqChar(String s) {
        if(s.length() == 0)
            return -1;

        int[] store = new int[26];
        for(char ch : s.toCharArray()){
            store[ch - 'a']++;
        }

        for(int idx=0;idx<s.length();idx++){
            if(store[s.charAt(idx) - 'a'] == 1){
                return idx;
            }
        }
        return -1;
    }

    public static void main(String args[]){
        String s="leetcode";

        System.out.println(firstUniqChar(s));
    }
}

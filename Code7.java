/* 
LARGEST DIVISIBLE SUBSET
 Given a set of distinct positive integers nums, return the largest subset answer such that every pair (answer[i], answer[j]) of elements in this subset satisfies:

answer[i] % answer[j] == 0, or
answer[j] % answer[i] == 0
If there are multiple solutions, return any of them.

 

Example 1:

Input: nums = [1,2,3]
Output: [1,2]
Explanation: [1,3] is also accepted.
Example 2:

Input: nums = [1,2,4,8]
Output: [1,2,4,8]
 

Constraints:

1 <= nums.length <= 1000
1 <= nums[i] <= 2 * 109
All the integers in nums are unique.

 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Code7 {
    static int largestSubset(int[] a, int n)
    {
        // dp[i] is going to store size of largest
        // divisible subset beginning with a[i].
        int[] dp = new int[n];
 
        // Since last element is largest, d[n-1] is 1
        dp[n - 1] = 1;
 
        // Fill values for smaller elements.
        for (int i = n - 2; i >= 0; i--) {
 
            // Find all multiples of a[i] and consider
            // the multiple that has largest subset
            // beginning with it.
            int mxm = 0;
            for (int j = i + 1; j < n; j++) {
                if (a[j] % a[i] == 0 || a[i] % a[j] == 0) {
                    mxm = Math.max(mxm, dp[j]);
                }
            }
 
            dp[i] = 1 + mxm;
        }
 
        // Return maximum value from dp[]
        return Arrays.stream(dp).max().getAsInt();
    }
public static void main(String[] arr){
    int[] a = { 1, 3, 6, 13, 17, 18 };
    int n = a.length;
    System.out.println(largestSubset(a, n));


}
}

/*
You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.

 

Example 1:

Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation: 
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Example 2:

Input: nums = [1], k = 1
Output: [1]
 

Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
1 <= k <= nums.length
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class Code70 {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deq = new ArrayDeque<>();
        int size=nums.length;
        int result [] = new int[size - k + 1];
        int index=0;
        for(int idx=0;idx<size;idx++){
            int current_Num=nums[idx];
            while(!deq.isEmpty() && deq.peekLast() < idx-k+1){
                deq.pollLast();
            }
            while(!deq.isEmpty() && nums[deq.peekFirst()] < current_Num){
                deq.pollFirst();
            }
            deq.offerFirst(idx);
            if(idx + 1 >=k){
                result[index++] = nums[deq.peekLast()];
            }
        }
        return result;
    }

    public static void main(String args[]){
        int[] nums={1,3,-1,-3,5,3,6,7};
        int k=3;

        System.out.println(maxSlidingWindow(nums,k));
    }
}

/*
Given an integer array nums, find a 
subarray
 that has the largest product, and return the product.

The test cases are generated so that the answer will fit in a 32-bit integer.

 

Example 1:

Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 

Constraints:

1 <= nums.length <= 2 * 104
-10 <= nums[i] <= 10
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 */
public class Code71 {
    public static int maxProduct(int[] nums) {
        int max = nums[0], min = nums[0], result = nums[0];
        // negative multiple negative might be max
        for(int i=1; i<nums.length; i++){
            int temp =max;
            max = Math.max(Math.max(temp*nums[i], nums[i]*min), nums[i]);
            // overflow only happened when negative multiple
            // result cannot be overflow
            // then if negative multiple others already overflow
            // we can ignore the result after the overflow
            if(nums[i]>0 && Integer.MIN_VALUE/nums[i]>min) min = nums[i];
            else min = Math.min(Math.min(temp*nums[i], nums[i]*min), nums[i]);
            result = Math.max(result, max);
        }
        return result;
    }

    public static void main(String args[]){
        int[] nums={2,3,-2,4};

        System.out.println(maxProduct(nums));
    }
}

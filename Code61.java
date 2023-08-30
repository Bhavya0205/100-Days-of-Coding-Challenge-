/*
Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.

Return any array that satisfies this condition.

 

Example 1:

Input: nums = [3,1,2,4]
Output: [2,4,3,1]
Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
Example 2:

Input: nums = [0]
Output: [0]
 

Constraints:

1 <= nums.length <= 5000
0 <= nums[i] <= 5000
 */
public class Code61 {
    public static int[] sortArrayByParity(int[] nums) {
        int left=0;

        for(int i=0;i<nums.length;i++){
            if(nums[i] % 2 ==0){
                int temp = nums[left];
                nums[left]=nums[i];
                nums[i]=temp;
                left++;
            }
        }
        return nums;
    }

    public static void main(String args[]){
        int[] nums={3,1,2,4};

        System.out.println(sortArrayByParity(nums));
    }
}

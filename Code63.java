/*
Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.

 

Example 1:

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Example 2:

Input: nums = [2,0,1]
Output: [0,1,2]
 

Constraints:

n == nums.length
1 <= n <= 300
nums[i] is either 0, 1, or 2.
 */
public class Code63 {
    public static void sortColors(int[] nums) {
        int cnt0=0;int cnt1=0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]==0){
                cnt0++;
            }
            else if(nums[i]==1){
                cnt1++;
            }
        }
        for (int a=0;a<cnt0;a++){
            nums[a]=0;
        }
        for (int b=cnt0;b<cnt0+cnt1;b++){
            nums[b]=1;
        }
        for(int c=cnt0+cnt1;c<nums.length;c++){
            nums[c]=2;
        }
    }

    public static void main(String args[]){
        int[] nums={2,0,2,1,1,0};
        
        sortColors(nums);
    }
}

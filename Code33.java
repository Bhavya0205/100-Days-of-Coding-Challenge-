/*
Majority Elements
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

 

Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2
 

Constraints:

n == nums.length
1 <= n <= 5 * 104
-109 <= nums[i] <= 109
 */
public class Code33 {
    public static int majorityElement(int[] nums) {
        int count=0;
        int n=nums.length;
        int element=0;

        for(int i=0;i<n;i++){
            if(count==0){
                count=1;
                element=nums[i];
            }
            else if(element==nums[i]){
                count++;
            }
            else{
                count--;
            }
        }

        int count1=0;
        for(int i=0;i<n;i++){
            if(nums[i]==element){
                count1++;
            }
        }

        if(count1 > (n/2))
            return element;

        return -1;
    }
    
    public static void main(String args[]){
        int nums[]={3,2,3};

        System.out.println(majorityElement(nums));
    }
}

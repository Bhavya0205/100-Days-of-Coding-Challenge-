/*
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

 

Example 1:

Input: nums = [3,2,3]
Output: [3]
Example 2:

Input: nums = [1]
Output: [1]
Example 3:

Input: nums = [1,2]
Output: [1,2]
 

Constraints:

1 <= nums.length <= 5 * 104
-109 <= nums[i] <= 109
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Code73 {
    public static List<Integer> majorityElement(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        List<Integer> ele=new ArrayList<>();
        int threshold=nums.length/3;

        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            int element=entry.getKey();
            int count=entry.getValue();

            if(count > threshold){
                ele.add(element);
            }
        }
        return ele;
    }

    public static void main(String args[]){
        int[] nums={3,2,3};

        System.out.println(majorityElement(nums));
    }
}

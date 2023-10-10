/*
Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.

 

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Explanation: [4,9] is also accepted.
 

Constraints:

1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000
 */

import java.util.ArrayList;
import java.util.HashSet;

public class Code98 {
    public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set= new HashSet<>();
        ArrayList<Integer> list= new ArrayList<>();
        for(int i=0;i<nums1.length;i++){
            if(set.add(nums1[i]));
        }
        int count=0;
        for(int i=0;i<nums2.length;i++){
            if(set.contains(nums2[i])){
                count++;
                list.add(nums2[i]);
                set.remove(nums2[i]);
            }
        }

        int[] arr = new int[count];
        for(int i=0;i<count;i++){
            arr[i]=list.get(i);
        }
        return arr;
    }

    public static void main(String args[]){
        int[] nums1={1,2,2,1};
        int[] nums2={2,2};

        System.out.println(intersection(nums1,nums2));
    }
}

/*
Given the head of a singly linked list, return true if it is a 
palindrome
 or false otherwise.

 

Example 1:


Input: head = [1,2,2,1]
Output: true
Example 2:


Input: head = [1,2]
Output: false
 

Constraints:

The number of nodes in the list is in the range [1, 105].
0 <= Node.val <= 9
 */
public class Code82 {
    public boolean isPalindrome(ListNode head) {
        ListNode slow=head,fast=head,prev,temp;
        while(fast != null && fast.next != null){
            slow=slow.next;
            fast=fast.next.next;
        }
        prev=slow;
        slow=slow.next;
        prev.next=null;
        while(slow != null){
            temp=slow.next;
            slow.next=prev;
            prev=slow;
            slow=temp;
        }

        fast=head;
        slow=prev;
        while(slow != null){
            if(fast.val != slow.val)
                return false;
            fast=fast.next;
            slow=slow.next;
        }
        return true;
    }
}

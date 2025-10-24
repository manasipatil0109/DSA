/*
 * 203. Remove Linked List Elements
Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.

 

Example 1:


Input: head = [1,2,6,3,4,5,6], val = 6
Output: [1,2,3,4,5]
Example 2:

Input: head = [], val = 1
Output: []
Example 3:

Input: head = [7,7,7,7], val = 7
Output: []
 

Constraints:

The number of nodes in the list is in the range [0, 104].
1 <= Node.val <= 50
0 <= val <= 50
 */


package LinkedList;

public class Remove_LL_Elements {
    /*
     * Solution 1
     */
    public ListNode removeElements(ListNode head, int val) {
        while(head!=null && head.val == val){
            head=head.next;
        }
        if(head==null)
            return head;
        ListNode prev=head, curr = head.next;
        while(curr!=null){
            if(curr.val==val){
                prev.next = curr.next;
            }else{
                prev=prev.next;
            }
            curr=curr.next;
        }
        return head;
    }
}

/*
143. Reorder List

You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.

 

Example 1:


Input: head = [1,2,3,4]
Output: [1,4,2,3]
Example 2:


Input: head = [1,2,3,4,5]
Output: [1,5,2,4,3]
 

Constraints:

The number of nodes in the list is in the range [1, 5 * 104].
1 <= Node.val <= 1000 
*/

package LinkedList;

import java.util.Stack;

public class Reorder_List {
    /*
    Solution 1 
    */
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow= slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;
        slow.next = null;

        Stack<ListNode> st = new Stack<>();
        while(fast!=null){
            st.push(fast);
            fast = fast.next;
        }
        fast = head;
        while(!st.isEmpty()){
            ListNode c = fast.next;
            fast.next = st.pop();
            fast.next.next = c;
            fast = fast.next.next;
        }
    }

    /*
    Solution 2 - using reverse LL 
    */
    private ListNode reverseLL(ListNode head){
        if(head == null || head.next==null)
            return head;
        ListNode temp = reverseLL(head.next);
        head.next.next = head;
        head.next = null;
        return temp;
    }
    public void reorderList1(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow= slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;
        slow.next = null;
        fast = reverseLL(fast);
        slow = head;
        while(slow!=null && fast!=null)
        {
            ListNode stemp = slow.next;
            slow.next = fast;
            ListNode ftemp = fast.next;
            fast.next = stemp;

            slow = stemp;
            fast = ftemp;
        }
    }
}

/*
 * 206. Reverse Linked List

Given the head of a singly linked list, reverse the list, and return the reversed list.

 

Example 1:


Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]
Example 2:


Input: head = [1,2]
Output: [2,1]
Example 3:

Input: head = []
Output: []
 

Constraints:

The number of nodes in the list is the range [0, 5000].
-5000 <= Node.val <= 5000
 

Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?
 */

package LinkedList;

public class ReverseLinkedList {

    /*
     * Solution 1
     */
    public ListNode reverseList(ListNode head) {
        ListNode tail = head;
        while(tail!=null && tail.next!=null){
            ListNode s = tail.next;
            tail.next = tail.next.next;
            s.next = head;
            head=s;
        }
        return head;
    }

    /*
    * Solution - non recursive
    */
   public ListNode reverseList2(ListNode head) {
        ListNode temp = new ListNode(0);
        while(head!=null){
            ListNode t = temp.next;
            temp.next = head;
            head=head.next;
            temp.next.next = t;
        }
        return temp.next;
    }

    /*
     * Solution 2- recursive
     */
    public ListNode reverseList1(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode temp = reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return temp;
    }
}

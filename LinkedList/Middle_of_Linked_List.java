/*
876. Middle of the Linked List

Given the head of a singly linked list, return the middle node of the linked list.

If there are two middle nodes, return the second middle node.

 

Example 1:


Input: head = [1,2,3,4,5]
Output: [3,4,5]
Explanation: The middle node of the list is node 3.
Example 2:


Input: head = [1,2,3,4,5,6]
Output: [4,5,6]
Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
 

Constraints:

The number of nodes in the list is in the range [1, 100].
1 <= Node.val <= 100 
*/



package LinkedList;

public class Middle_of_Linked_List {
    /*
    Solution 1 - brute force 
    */
    public ListNode middleNode(ListNode head) {
        ListNode m=head;
        int count=0;
        while(m!=null){
            count++;
            m=m.next;
        }
        int i=0;
        m=head;
        while(i<(count/2)){
            m=m.next;
            i++;
        }
        return m;
    }



    /*
    Solution 2 - slow fast pointer 
    */
    public ListNode middleNode1(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

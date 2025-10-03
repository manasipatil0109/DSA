/*
 * 2. Add Two Numbers

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example 1:
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.

Example 2:
Input: l1 = [0], l2 = [0]
Output: [0]

Example 3:
Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
 

Constraints:
The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.
 */



package LinkedList;

public class Add_LL_Numbers {
    /*
     * Solution 1
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;
        ListNode l=new ListNode();
        int rem=0;
        int value=l1.val+l2.val+rem;
        if(value<=9){
            l=new ListNode(value,null);
            rem=0;
        }else{
            l=new ListNode(value%10,null);
            rem=1;
        }
        ListNode temp = l;
        l1=l1.next;
        l2=l2.next;
        while(l1!=null && l2!=null){
            value=l1.val+l2.val+rem;
            if(value<=9){
                temp.next=new ListNode(value,null);
                rem=0;
            }else{
                temp.next=new ListNode(value%10,null);
                rem=1;
            }
            l1=l1.next;
            l2=l2.next;
            temp=temp.next;
        }
        while(l1!=null){
            value=l1.val+rem;
            if(value<=9){
                temp.next=new ListNode(value,null);
                rem=0;
            }else{
                temp.next=new ListNode(value%10,null);
                rem=1;
            }
            l1=l1.next;
            temp=temp.next;
        }
        while(l2!=null){
            value=l2.val+rem;
            if(value<=9){
                temp.next=new ListNode(value,null);
                rem=0;
            }else{
                temp.next=new ListNode(value%10,null);
                rem=1;
            }
            l2=l2.next;
            temp=temp.next;
        }
        if(rem==1)
         temp.next=new ListNode(1,null);
        return l;
    }

    /*
     * Solution 2 - easy
     */
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(0);
        ListNode head=temp;
        int carry =0 ;
        while(l1!=null || l2!=null || carry==1){
            int s =0;
            if(l1!=null){
                s+=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                s+=l2.val;
                l2=l2.next;
            }
            s+=carry;

            carry = s/10;
            temp.next = new ListNode(s%10);
            temp=temp.next;
        }
        return head.next;
    }
}

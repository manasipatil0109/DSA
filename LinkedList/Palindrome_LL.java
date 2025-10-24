/*
 * 234. Palindrome Linked List

Given the head of a singly linked list, return true if it is a palindrome or false otherwise.

 

Example 1:


Input: head = [1,2,2,1]
Output: true
Example 2:


Input: head = [1,2]
Output: false
 

Constraints:

The number of nodes in the list is in the range [1, 105].
0 <= Node.val <= 9
 

Follow up: Could you do it in O(n) time and O(1) space?
 */


package LinkedList;

import java.util.ArrayList;
import java.util.List;

public class Palindrome_LL {

    /*
     * Solution 1 - using only LL - 7ms
     */
    public ListNode reverseList(ListNode head){
        if(head==null || head.next==null)
            return head;
        ListNode s = reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return s;
    }
    public boolean isPalindrome2(ListNode head) {

        ListNode slow = head, fast = head;
        //Going hald the list
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        //reversing seconf half of the list
        ListNode sL = reverseList(slow);

        while(sL!=null){
            if(head.val != sL.val){
                return false;
            }
            head=head.next;
            sL=sL.next;
        }
        return true;
    }

    /*
     * Solution 2 - using StringBuilder
     */
    public boolean isPalindrome1(ListNode head) {
        StringBuilder s=new StringBuilder();
        while(head!=null){
            s.append(head.val);
            head=head.next;
        }
        for(int i=0,j=s.length()-1;i<=j;i++,j--){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
        }
        return true;
    }

    /*
     * Solution 2 - very slow, when we do s+= it created new string which leads to O(n2) time
     * 
     */
    public boolean isPalindrome(ListNode head) {
        String s="";
        while(head!=null){
            s+=head.val;
            head=head.next;
        }
        for(int i=0,j=s.length()-1;i<=j;i++,j--){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
        }
        return true;
    }


    /*
     * Solution 4- using arrayList - 7ms, if used arrays then 3ms
     */
    public boolean isPalindrome3(ListNode head) {
        List<Integer> sl = new ArrayList<>();
        ListNode temp = head;
        while(temp!=null){
            sl.add(temp.val);
            temp=temp.next;
        }

        for(int i=0,j=sl.size()-1;i<=j;i++,j--){
            if(sl.get(i) != sl.get(j))
                return false;
        }
        return true;
    }
}

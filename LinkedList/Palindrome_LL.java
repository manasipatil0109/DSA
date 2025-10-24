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

public class Palindrome_LL {

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
}

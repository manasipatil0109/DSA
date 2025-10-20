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

package LinkedList;

public class Swap_Nodes_in_Pairs {

    /*
     * Solution 1 - my latest 0ms solution
     */
    public ListNode swapPairs1(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode t1 = head;
        head=head.next;
        t1.next=head.next;
        head.next=t1;
        while(t1.next!=null && t1.next.next != null){
            ListNode t2 = t1.next;
            ListNode temp = t2.next.next;
            t2.next.next=t2;
            t1.next=t2.next;
            t2.next=temp;
            t1=t2;
        }
        return head;
    }


    /*
     * Solution 2 - my old solution
     */
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode p1=head;
        ListNode p2=head.next;
        ListNode prev=null;
        while(p1!=null && p2!=null){
            System.out.println(p1.val+" - "+p2.val);
            ListNode temp=p2.next;
            p2.next=p1;
            p1.next=temp;
            if(p1==head)
                head=p2;
            else
                prev.next=p2;
            prev=p1;
            p1=p1.next;
            p2=(p1!=null)?p1.next:null;
        }
        return head;
    }
}

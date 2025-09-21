package LinkedList;

public class Merge_Sorted_LL {


    /*
        * Solution 1
        */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null)
            return list2;
        if(list2 == null)
            return list1;
        
        ListNode t = null;
        if(list1.val>=list2.val){
            t=list2;
            list2=list2.next;
        }else{
            t=list1;
            list1=list1.next;
        }
        t.next=null;
        ListNode result = t;
        while(list1!=null && list2!=null){
            if(list1.val==list2.val){
                t.next=list1;
                list1=list1.next;
                t=t.next;
                t.next=list2;
                list2=list2.next;
                t=t.next;
            }else if(list1.val>list2.val){
                t.next=list2;
                list2=list2.next;
                t=t.next;
            } else{
                t.next=list1;
                list1=list1.next;
                t=t.next;
            }
        }
        while(list1!=null){
            t.next=list1;
            list1=list1.next;
            t=t.next;
        }
        while(list2!=null){
            t.next=list2;
            list2=list2.next;
            t=t.next;
        }
        t.next=null;
        return result;

    }

    /* 
     * Solution 2- cleaner code but more space complexity
     */
    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        if(list1==null)
            return list2;
        if(list2 == null)
            return list1;
        ListNode dummy =new ListNode(-1);
        ListNode t=dummy;
        while(list1!=null && list2!=null){
            if(list1.val<=list2.val){
                t.next=list1;
                list1=list1.next;
            }else{
                t.next=list2;
                list2=list2.next;
            } 
            t=t.next;
        }
        if(list1!=null){
            t.next=list1;
        }
        if(list2!=null){
            t.next=list2;
        }
        return dummy.next;
    }


    /*
     * Solution 3 - recursice not my solution
     */
    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {

        if(list1!=null && list2!=null){
        if(list1.val<list2.val){
            list1.next=mergeTwoLists(list1.next,list2);
            return list1;
            }
            else{
                list2.next=mergeTwoLists(list1,list2.next);
                return list2;
        }
        }
        if(list1==null)
            return list2;
        return list1;
    }
}

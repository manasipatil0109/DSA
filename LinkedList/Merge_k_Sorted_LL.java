/*
 * 23. Merge k Sorted Lists

You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
Merge all the linked-lists into one sorted linked-list and return it. 

Example 1:
Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted linked list:
1->1->2->3->4->4->5->6

Example 2:
Input: lists = []
Output: []

Example 3:
Input: lists = [[]]
Output: []
 

Constraints:
k == lists.length
0 <= k <= 104
0 <= lists[i].length <= 500
-104 <= lists[i][j] <= 104
lists[i] is sorted in ascending order.
The sum of lists[i].length will not exceed 104.
 */




package LinkedList;

public class Merge_k_Sorted_LL {
    /*
     * Solution 1 - recursive solution but time complexity is 168 ms
     */
    public ListNode mergeList(ListNode list1, ListNode list2){
        if(list1!=null && list2!=null){
            if(list1.val<list2.val){
                list1.next = mergeList(list1.next,list2);
                return list1;
            }else{
                list2.next = mergeList(list1,list2.next);
                return list2;
            }
        }
        if(list1==null)
            return list2;
        return list1;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)
            return null;
        if(lists.length==1)
            return lists[0];
        ListNode result=lists[0];
        for(int i=1;i<lists.length;i++){
            result = mergeList(result,lists[i]);
        }
        return result;
    }

    /*
     * Solution 2 - time complexity : 81 ms
     */
    public ListNode mergeList1(ListNode list1, ListNode list2){

        ListNode dummy = new ListNode(-1);
        ListNode t = dummy;
        while(list1!=null && list2!=null){
            if(list1.val<list2.val){
                t.next = list1;
                list1=list1.next;
            }else{
                t.next = list2;
                list2=list2.next;
            }
            t=t.next;
        }
        if(list1!=null)
            t.next = list1;
        if(list2!=null)
            t.next = list2;
        return dummy.next;
    }
    public ListNode mergeKLists1(ListNode[] lists) {
        if(lists.length==0)
            return null;
        if(lists.length==1)
            return lists[0];
        ListNode result=lists[0];
        for(int i=1;i<lists.length;i++){
            result = mergeList(result,lists[i]);
        }
        return result;
    }
}

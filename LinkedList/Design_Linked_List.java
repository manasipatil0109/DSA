/*
 * 707. Design Linked List
Solved
Medium
Topics
premium lock icon
Companies
Design your implementation of the linked list. You can choose to use a singly or doubly linked list.
A node in a singly linked list should have two attributes: val and next. val is the value of the current node, and next is a pointer/reference to the next node.
If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in the linked list. Assume all nodes in the linked list are 0-indexed.

Implement the MyLinkedList class:

MyLinkedList() Initializes the MyLinkedList object.
int get(int index) Get the value of the indexth node in the linked list. If the index is invalid, return -1.
void addAtHead(int val) Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
void addAtTail(int val) Append a node of value val as the last element of the linked list.
void addAtIndex(int index, int val) Add a node of value val before the indexth node in the linked list. If index equals the length of the linked list, the node will be appended to the end of the linked list. If index is greater than the length, the node will not be inserted.
void deleteAtIndex(int index) Delete the indexth node in the linked list, if the index is valid.
 

Example 1:

Input
["MyLinkedList", "addAtHead", "addAtTail", "addAtIndex", "get", "deleteAtIndex", "get"]
[[], [1], [3], [1, 2], [1], [1], [1]]
Output
[null, null, null, null, 2, null, 3]

Explanation
MyLinkedList myLinkedList = new MyLinkedList();
myLinkedList.addAtHead(1);
myLinkedList.addAtTail(3);
myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
myLinkedList.get(1);              // return 2
myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
myLinkedList.get(1);              // return 3
 

Constraints:

0 <= index, val <= 1000
Please do not use the built-in LinkedList library.
At most 2000 calls will be made to get, addAtHead, addAtTail, addAtIndex and deleteAtIndex.

 */




package LinkedList;

public class Design_Linked_List {
    class Node{
        int val;
        Node next;
        public Node(int x){
            val = x;
            next=null;
        }
    }
    
    class MyLinkedList {
    
        Node head;
        Node tail;
        int size;
    
        public MyLinkedList() {
            head=null;
            tail=null;
            size=0;
        }
        
        public int get(int index) {
            if(index < 0 || index >= size){
                return -1;
            }
            Node temp=head;
            while(temp!=null && index>0){
                temp=temp.next;
                index--;
            }
            return temp.val;
        }
        
        public void addAtHead(int val) {
            Node newN = new Node(val);
            newN.next = head;
            head=newN;
            if(tail==null)
                tail = newN;
            size++;
        }
        
        public void addAtTail(int val) {
            if(head==null){
                addAtHead(val);
                return;
            }
            Node newN = new Node(val);
            tail.next = newN;
            tail=tail.next;
            size++;
        }
        
        public void addAtIndex(int index, int val) {
            if(index>size){
                return;
            }
            if(index==size){
                addAtTail(val);
            }else if(index==0)
                addAtHead(val);
            else{
                Node temp = head;
                for (int i = 0; i < index - 1; i++) {  // move to node before insertion
                    temp = temp.next;
                }
                Node newN = new Node(val);
                newN.next = temp.next;
                temp.next = newN;
                size++;
            }
        }
        
        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) {
            return;
        }
    
        if (index == 0) { // delete head
            head = head.next;
            if (head == null) { // if list became empty
                tail = null;
            }
        } else {
            Node temp = head;
            for (int i = 0; i < index - 1; i++) { // move to node before index
                temp = temp.next;
            }
            temp.next = temp.next.next;
            if (index == size - 1) { // deleted last node, update tail
                tail = temp;
            }
        }
        size--;
        }
    }
}

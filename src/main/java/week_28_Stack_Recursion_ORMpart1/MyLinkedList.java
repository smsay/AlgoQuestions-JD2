package main.java.week_28_Stack_Recursion_ORMpart1;

class MyLinkedList {
    ListNode head;
    ListNode tail;

    void add(int n) {
        ListNode newNode = new ListNode(n);
        if (head == null){
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }
}
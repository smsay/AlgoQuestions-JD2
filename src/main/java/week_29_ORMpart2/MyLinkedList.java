package main.java.week_29_ORMpart2;

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
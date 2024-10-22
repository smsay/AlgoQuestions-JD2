package main.java.week_27_SQL_newFeatures_readWriteFiles;

class MyLinkedList {
    public ListNode head;
    ListNode tail;

    public void add(int n) {
        ListNode newNode = new ListNode(n);
        if (head == null){
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }
}
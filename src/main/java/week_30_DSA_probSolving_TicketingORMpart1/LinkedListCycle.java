package main.java.week_30_DSA_probSolving_TicketingORMpart1;

import java.util.HashSet;
import java.util.stream.Stream;

public class LinkedListCycle {
/*
142. Linked List Cycle II
Medium

Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.

Do not modify the linked list.

Example 1:

Input: head = [3,2,0,-4], pos = 1
Output: tail connects to node index 1
Explanation: There is a cycle in the linked list, where tail connects to the second node.

Example 2:

Input: head = [1,2], pos = 0
Output: tail connects to node index 0
Explanation: There is a cycle in the linked list, where tail connects to the first node.

Example 3:

Input: head = [1], pos = -1
Output: no cycle
Explanation: There is no cycle in the linked list.

 */

    public static void main(String[] args) {
        LinkedListCycle solution = new LinkedListCycle();
        MyLinkedList list = new MyLinkedList();
        Stream.of(1, 2, 3, 4, 5, 6, 4).forEach(list::add);
        list.tail.next = list.head.next.next.next;

        System.out.println("withHashSet(list.head) = " + solution.withHashSet(list.head).val);
        System.out.println("twoPointer(list.head) = " + solution.twoPointer(list.head).val);
    }

     ListNode withHashSet(ListNode head) {
        if (head == null) return null;
        ListNode current = head;
        HashSet<ListNode> set = new HashSet<>();
        while (current != null) {
            if (!set.add(current)) {
                return current;
            }
//            if (set.contains(current))
//                return current;
//            else
//                set.add(current);
            current = current.next;
        }
        return null;
    }


     ListNode twoPointer(ListNode head){
        if (head == null || head.next == null) return null;
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                ListNode firstNode = head;
                ListNode intersection = fast;
                while (firstNode != intersection) {
                    intersection = intersection.next;
                    firstNode = firstNode.next;
                }
                return firstNode;
            }
        }
        return null;
    }
}

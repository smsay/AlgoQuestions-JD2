package main.java.week_36_spring_rest_security;

import java.util.Deque;
import java.util.LinkedList;

public class SameTree {
      /*
    100. Same Tree
    Given the roots of two binary trees p and q, write a function to areSame if they are the same or not.

Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

Example 1:
Input: p = [1,2,3], q = [1,2,3]
Output: true

Example 2:
Input: p = [1,2], q = [1,null,2]
Output: false

Example 3:
Input: p = [1,2,1], q = [1,1,2]
Output: false

Constraints:

    The number of nodes in both trees is in the range [0, 100].
    -104 <= Node.val <= 104

https://leetcode.com/problems/same-tree/
     */

    public static void main(String[] args) {

        TreeNode firstTreeRoot = new TreeNode(10);
        firstTreeRoot.left = new TreeNode(4);
        firstTreeRoot.right = new TreeNode(15);
        firstTreeRoot.left.left = new TreeNode(3);
        firstTreeRoot.left.right = new TreeNode(5);

        TreeNode secondTreeRoot = new TreeNode(10);
        secondTreeRoot.left = new TreeNode(4);
        secondTreeRoot.right = new TreeNode(15);
        secondTreeRoot.left.left = new TreeNode(3);
        secondTreeRoot.left.right = new TreeNode(5);

        TreeNode thirdTreeRoot = new TreeNode(10);
        thirdTreeRoot.left = new TreeNode(4);
        thirdTreeRoot.right = new TreeNode(15);
        thirdTreeRoot.left.left = new TreeNode(3);

        System.out.println(withRecursion(null, null));
        System.out.println(withIteration(null, null));
        System.out.println(withRecursion(firstTreeRoot, secondTreeRoot));
        System.out.println(withIteration(firstTreeRoot, secondTreeRoot));
        System.out.println(withRecursion(firstTreeRoot, thirdTreeRoot));
        System.out.println(withIteration(firstTreeRoot, thirdTreeRoot));


    }

    public static boolean withRecursion(TreeNode p, TreeNode q) {
        // p and q are both null
        if (p == null && q == null) return true;
        // one of p and q is null
        if (q == null || p == null) return false;
        if (p.val != q.val) return false;
        return withRecursion(p.right, q.right) &&
                withRecursion(p.left, q.left);
    }

    public static boolean withIteration(TreeNode p, TreeNode q) {
        if (!areSame(p, q)) return false;

        Deque<TreeNode> deqP = new LinkedList<>();
        Deque<TreeNode> deqQ = new LinkedList<>();
        deqP.addLast(p);
        deqQ.addLast(q);

        while (!deqP.isEmpty()) {
            p = deqP.removeFirst();
            q = deqQ.removeFirst();

            if (!areSame(p, q)) return false;
            if (p != null) {
                // null value is not allowed in Deque
                if (!areSame(p.left, q.left)) return false;
                if (p.left != null) {
                    deqP.addLast(p.left);
                    deqQ.addLast(q.left);
                }
                if (!areSame(p.right, q.right)) return false;
                if (p.right != null) {
                    deqP.addLast(p.right);
                    deqQ.addLast(q.right);
                }
            }
        }
        return true;
    }


    private static boolean areSame(TreeNode p, TreeNode q) {
        // p and q are null
        if (p == null && q == null) return true;
        // one of p and q is null
        if (q == null || p == null) return false;
        return p.val == q.val;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

package main.java.week_37_aop_testing;

import java.util.LinkedList;

public class RangeSumOfBST {
    /*
    938. Range Sum of BST

    Given the root node of a binary search tree and two integers low and high, return the sum of values of all nodes with a value in the inclusive range [low, high].

Example 1:
Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
Output: 32
Explanation: Nodes 7, 10, and 15 are in the range [7, 15]. 7 + 10 + 15 = 32.

Example 2:
Input: root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
Output: 23
Explanation: Nodes 6, 7, and 10 are in the range [6, 10]. 6 + 7 + 10 = 23.

Constraints:

    The number of nodes in the tree is in the range [1, 2 * 10^4].
    1 <= Node.val <= 105
    1 <= low <= high <= 105
    All Node.val are unique.

    https://leetcode.com/problems/range-sum-of-bst/
     */

    public static void main(String[] args) {

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(18);

        System.out.println(rangeSumBST(root, 7, 15));
    //    System.out.println(rangeSumBSTWithStack(root, 7, 15));

    }

    // recursive
    // DFS - pre order
    // Time: O(n), space: O(n)
    private static int answer;

    public static int rangeSumBST(TreeNode root, int low, int high) {
        answer = 0;
        dfs(root, low, high);
        return answer;
    }

    private static void dfs(TreeNode node, int low, int high) {
        if (node != null) {
            if (low <= node.val && node.val <= high)
                answer += node.val;
            if (low < node.val)
                dfs(node.left, low, high);
            if (node.val < high)
                dfs(node.right, low, high);
        }
    }
 /*   private static void dfs(TreeNode node, int low, int high) {
        if (node == null) return;
        if (low <= node.val && node.val <= high)
            answer += node.val;
        if (low < node.val)
            dfs(node.left, low, high);
        if (node.val < high)
            dfs(node.right, low, high);

    }*/

    // iterative
    // DFS - pre order
    // Time: O(n), space: O(n)
    public static int rangeSumBSTWithStack(TreeNode root, int low, int high) {
        int result = 0;
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null) continue;
            if (low <= node.val && node.val <= high)
                result += node.val;
            if (low < node.val)
                stack.push(node.left);
            if (node.val < high)
                stack.push(node.right);
        }
        return result;
    }


    // other solutions

    // recursive
    // DFS - post order
    // Time: O(n), space: O(n)
    static int rangeSumBST1(TreeNode root, int low, int high) {
        if (root == null) return 0; // base case
        if (root.val < low) return rangeSumBST1(root.right, low, high); // left branch excluded.
        if (root.val > high) return rangeSumBST1(root.left, low, high); // right branch excluded.
        return root.val
                + rangeSumBST1(root.right, low, high)
                + rangeSumBST1(root.left, low, high); // count in both children.
    }


    // recursive
    // DFS - post order
    // Time: O(n), space: O(n)
    public int rangeSumBST3(TreeNode root, int low, int right) {
        if (root == null) return 0; // base case
        int sum = 0;
        if (root.val > low) {
            sum += rangeSumBST3(root.left, low, right);
        } // left child is a possible candidate.
        if (root.val < right) {
            sum += rangeSumBST3(root.right, low, right);
        } // right child is a possible candidate.
        if (root.val >= low && root.val <= right) {
            sum += root.val;
        } // count root in.
        return sum;
    }

    // recursive
    // DFS - post order
    // Time: O(n), space: O(n)
    public int rangeSumBST2(TreeNode root, int low, int right) {
        if (root == null) return 0; // base case
        return (low <= root.val && root.val <= right ? root.val : 0)
                + rangeSumBST2(root.right, low, right)
                + rangeSumBST2(root.left, low, right);
    }

    // BFS traversal - level order
    static int withQueue(TreeNode root, int low, int high) {
        int result = 0;
        if (root == null) return result;
        LinkedList<TreeNode> q = new LinkedList<>();
        TreeNode current = root;
        while (!q.isEmpty() || current != null) {
            if (current != null) {
                int n = current.val;
                if (n >= low && n <= high) {
                    result += n;
                }
                if (n > low) q.push(current.left);
                if (n < high) q.push(current.right);
            }
            current = q.pop();
        }
        return result;
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

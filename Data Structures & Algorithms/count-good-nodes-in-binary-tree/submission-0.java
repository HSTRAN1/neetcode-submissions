/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int goodNodes(TreeNode root) {
        if (root == null)
            return 0;
        return findGood(root, root.val);
    }

    private int findGood(TreeNode node, int max) {
        if (node == null)
            return 0;
        int current;

        if (node.val >= max) 
            current = 1;
        else
            current = 0;
        max = Math.max(max, node.val);

        return current + findGood(node.left,max) + findGood(node.right,max);
    }
}

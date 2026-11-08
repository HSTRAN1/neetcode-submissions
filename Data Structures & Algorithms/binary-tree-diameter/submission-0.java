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
    private int diameter;

    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;

        if (root == null) 
            return 0;
        findDepth(root);

        return diameter;
    }
    private int findDepth (TreeNode node) {

        if (node == null) return 0;
        int leftDepth = findDepth(node.left);
        int rightDepth = findDepth(node.right);

        diameter = Math.max(leftDepth + rightDepth, diameter);

        return 1 + Math.max(leftDepth,rightDepth);
    }
}

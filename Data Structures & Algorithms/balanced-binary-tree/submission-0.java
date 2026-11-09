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
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        int leftDepth = findDepth(root.left);
        int rightDepth = findDepth(root.right);

        if (Math.abs(leftDepth - rightDepth) > 1)
            return false;
        
        return isBalanced(root.left) && isBalanced(root.right);
        
    }
    private int findDepth(TreeNode node) {
        if (node == null)
            return 0;
        int leftDepth = findDepth(node.left);
        int rightDepth = findDepth(node.right);

        return 1 + Math.max(leftDepth,rightDepth);
    }
}

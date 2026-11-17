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
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        long lower = Long.MIN_VALUE;
        long upper = Long.MAX_VALUE;
        
        return validate(root, lower, upper);
    }
    private boolean validate(TreeNode node, long lowerBound, long upperBound) {
        if (node == null)
            return true;

        if (node.val >= upperBound || node.val <= lowerBound)
            return false;
        else
            return validate(node.left, lowerBound, node.val)
                && validate(node.right, node.val, upperBound);
    }
}

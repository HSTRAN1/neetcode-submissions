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
    private int max;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        findMax(root);
        return max;
    }

    private int findMax(TreeNode node) {
        if (node == null)
            return 0;
        int leftGain = findMax(node.left);
        int rightGain = findMax(node.right);

        leftGain = Math.max(0, leftGain);
        rightGain = Math.max(0, rightGain);

        int candidate = node.val + leftGain + rightGain;
        max = Math.max(candidate, max);

        return node.val + Math.max(leftGain, rightGain);
        
    }
}

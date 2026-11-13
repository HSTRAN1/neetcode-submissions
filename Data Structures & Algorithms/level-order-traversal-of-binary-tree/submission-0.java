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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentLevel;

        if (root == null)
            return result;
        
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++)
            {
                TreeNode node = queue.poll();
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
                currentLevel.add(node.val);
            }
            result.add(currentLevel);
        }
        return result;

    }
}

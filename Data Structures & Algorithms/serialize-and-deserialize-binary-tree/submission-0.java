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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        StringBuilder result = new StringBuilder();

        while (!queue.isEmpty())
        {
            TreeNode node = queue.poll();

            if (node == null)
                result.append("#,");
            else {
                result.append(node.val).append(",");
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return result.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] tokens = data.split(",");
        int i = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();

        if (tokens[0].equals("#"))
            return null;
        else {
            TreeNode root = new TreeNode(Integer.parseInt(tokens[0]));
            queue.offer(root);
            i++;

            while (!queue.isEmpty())
            {
                TreeNode parent = queue.poll();
                String left = tokens[i];
                i++;
                if (!left.equals("#"))
                {
                    parent.left = new TreeNode(Integer.parseInt(left));
                    queue.offer(parent.left);
                }
                String right = tokens[i];
                i++;
                if (!right.equals("#"))
                {
                    parent.right = new TreeNode(Integer.parseInt(right));
                    queue.offer(parent.right);
                }
            }
            return root;
        }

    }
}

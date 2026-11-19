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
    private int preorderIndex;
    private Map<Integer, Integer> map;
    private int[] preorderArray;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIndex = 0;
        map = new HashMap<>();
        preorderArray = preorder;

        for (int i = 0; i< inorder.length; i++) {
            map.put(inorder[i],i);
        }

        return build(0, inorder.length - 1);
    }

    private TreeNode build(int inorderLeft, int inorderRight) {
        if (inorderLeft > inorderRight)
            return null;

        int rootValue = preorderArray[preorderIndex];
        preorderIndex++;

        TreeNode node = new TreeNode(rootValue);
        int splitIndex = map.get(rootValue);

        node.left = build(inorderLeft, splitIndex - 1);
        node.right = build(splitIndex + 1, inorderRight);
        
        return node;
    }
}

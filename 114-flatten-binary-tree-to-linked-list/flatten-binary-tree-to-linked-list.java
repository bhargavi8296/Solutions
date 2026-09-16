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
    TreeNode prev;
    public TreeNode helper(TreeNode root)
    {
        if(root==null){return null;}
        if(root.left==null&&root.right==null){prev=root;return root;}
        prev=root;
        TreeNode left=helper(root.left);
        TreeNode temp=root.right;
        root.left=null;
        root.right=left;
        prev.right=helper(temp);
        return root;

    }
    public void flatten(TreeNode root) {
        helper(root);
    }
}
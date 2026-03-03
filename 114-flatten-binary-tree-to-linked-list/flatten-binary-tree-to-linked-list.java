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
        helper(root.left);
        //System.out.print(root.left);
        TreeNode temp=root.right;
        root.right=root.left;root.left=null;
        prev.right=temp;
        helper(temp);
        return root;
    }
    public void flatten(TreeNode root) {
        prev=null;
        helper(root);
    }
}
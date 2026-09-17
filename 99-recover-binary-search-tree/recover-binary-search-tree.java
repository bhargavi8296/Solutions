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
    TreeNode top;
    TreeNode prev;
    public void helper(TreeNode root)
    {
        if(root==null){return;}
        helper(root.left);
        if(top==null){top=root;}
        else if(top.val>root.val){
            prev=root;
        }
        else if(prev==null){top=root;}
        helper(root.right);
    }
    public void recoverTree(TreeNode root) {
        top=null;
        prev=null;
        helper(root);
        int temp=top.val;
        top.val=prev.val;
        prev.val=temp;
    }
}
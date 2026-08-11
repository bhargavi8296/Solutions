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
    public boolean helper(TreeNode root)
    {
        if(root==null){return true;}
        if(!helper(root.left)){return false;}
        if(prev!=null&&prev.val>=root.val){return false;}
        prev=root;
        if(!helper(root.right)){return false;}
        return true;
    }
    public boolean isValidBST(TreeNode root) {
        prev=null;
        return helper(root);
    }
}
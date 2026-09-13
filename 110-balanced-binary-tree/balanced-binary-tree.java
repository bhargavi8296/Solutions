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
        if(root==null){return true;}
        if(root.left==null&&root.right==null){root.val=1;return true;}
        boolean left=isBalanced(root.left);
        boolean right=isBalanced(root.right);
        if(!(left&&right)){return false;}
        int l=root.left!=null?root.left.val:0;
        int r=root.right!=null?root.right.val:0;
        if(Math.abs(l-r)>1){return false;}
        root.val=Math.max(l,r)+1;
        return true;
    }
}
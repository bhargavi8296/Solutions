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
    TreeNode first;
    TreeNode second;
    public void helper(TreeNode root)
    {
        if(root==null){return;}
        helper(root.left);
        if(first==null||first.val<root.val)
        {
            if(second!=null)
            {
                int temp=first.val;
                first.val=second.val;
                second.val=temp;
                second=null;
            }
            first=root;
        }
        else{
            second=root;
        }
        helper(root.right);
    }
    public void recoverTree(TreeNode root) {
        first=null;
        second=null;
        helper(root);
         if(second!=null)
            {
                int temp=first.val;
                first.val=second.val;
                second.val=temp;
                second=null;
            }
    }
}
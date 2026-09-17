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
    int count;
    int result=-1;
    public void helper(TreeNode root)
    {
        if(root==null){return;}
        helper(root.left);
        if(count>0)
        {--count;}
        if(count==0){result=root.val;count=-1;}
        if(count<0){return;}
        helper(root.right);
    }
    public int kthSmallest(TreeNode root, int k) {
        count=k;
        helper(root);
        return result;
    }
}
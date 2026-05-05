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
class pair{
    boolean bst; 
    int sum;
    int min;
    int max;
    pair(boolean bst, int sum, int min, int max)
    {
        this.bst=bst;
        this.sum=sum;
        this.min=min;
        this.max=max;
    }
 }
class Solution {
    int max=Integer.MIN_VALUE;
    public pair helper(TreeNode root)
    {
        if(root==null){return new pair(true,0,Integer.MAX_VALUE,Integer.MIN_VALUE);}
        //if(root.left==null&&root.right==null){return new pair(true,root.val);}
        pair left=helper(root.left);
        pair right=helper(root.right);
        int l=left.max;
        int r=right.min;
        if(left.bst&&right.bst&&root.val>l&&root.val<r){
            max=Math.max(max,Math.max(left.sum,Math.max(right.sum,left.sum+right.sum+root.val)));
            return new pair(true,root.val+left.sum+right.sum,Math.min(Math.min(left.min,right.min),root.val),Math.max(root.val,Math.max(left.max,right.max)));}
        return new pair(false,-1,-1,-1);
    }
    public int maxSumBST(TreeNode root) {
        helper(root);
        return max;
    }
}
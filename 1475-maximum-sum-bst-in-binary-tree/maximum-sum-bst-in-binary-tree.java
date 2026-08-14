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
    int sum;
    int max;
    int min;
    boolean flag;
    pair(boolean flag,int min,int max,int sum)
    {
        this.flag=flag;
        this.min=min;
        this.max=max;
        this.sum=sum;
    }
 }
class Solution {
    int max;
    public pair helper(TreeNode root)
    {
        if(root==null)
        {
            return null;
        }
        if(root.left==null&&root.right==null)
        {
            max=Math.max(max,root.val);
            return new pair(true,root.val,root.val,root.val);
        }
        pair left=helper(root.left);
        pair right=helper(root.right);
        if(left==null||right==null)
        {
            if(left==null)
            {
                if(right.flag&&root.val<right.min)
                {
                    max=Math.max(max,Math.max(right.sum,right.sum+root.val));
                    return new pair(true,root.val,right.max,right.sum+root.val);
                }
            }
            else if(right==null)
            {
                if(left.flag&&root.val>left.max)
                {
                    max=Math.max(max,Math.max(left.sum,left.sum+root.val));
                    return new pair(true,left.min,root.val,left.sum+root.val);
                }
            }
        }
        else if(left.flag&&right.flag){
            if(left.max<root.val&&root.val<right.min)
            {
                max=Math.max(max,Math.max(left.sum,Math.max(right.sum,left.sum+right.sum+root.val)));
                return new pair(true,left.min,right.max,left.sum+right.sum+root.val);
            }
        }
        return new pair(false,0,0,0);
    }
    public int maxSumBST(TreeNode root) {
        max=0;
        helper(root);
        return max;
    }
}
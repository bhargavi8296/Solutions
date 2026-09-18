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
     int min;
     int max;
     boolean flag;
     pair(int sum, int min, int max, boolean flag)
     {
        this.sum=sum;
        this.min=min;
        this.max=max;
        this.flag=flag;
     }
}
class Solution {
    int max=0;
    public pair helper(TreeNode root)
    {
        if(root==null){return new pair(0,Integer.MAX_VALUE,Integer.MIN_VALUE,true);}
        if(root.left==null&&root.right==null){max=Math.max(max,root.val);return new pair(root.val,root.val,root.val,true);}
        pair left=helper(root.left);
        pair right=helper(root.right);
        //System.out.println(left.min+" "+left.max+" "+right.min+" "+right.max+" "+root.val);
        if(left.flag&&right.flag&&root.val>left.max&&root.val<right.min)
        {
            //System.out.println(max);
            max=Math.max(max,left.sum+right.sum+root.val);
            return new pair(left.sum+right.sum+root.val,Math.min(left.min,root.val),Math.max(right.max,root.val),true);
        }
        return new pair(0,Integer.MIN_VALUE,Integer.MAX_VALUE,false);

    }
    public int maxSumBST(TreeNode root) {
        helper(root);
        return max;
    }
}
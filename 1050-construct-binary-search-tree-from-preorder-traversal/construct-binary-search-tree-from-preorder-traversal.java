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
    public TreeNode helper(int[]pre, int[]in, int is, int ie, int ps, int pe)
    {
        if(is>ie||ps>pe){return null;}
        if(is==ie)
        {
            return new TreeNode(pre[ps]);
        }
        int index=is;
        for(int i=is;i<=ie;++i)
        {
            if(pre[ps]==in[i])
            {
                index=i;break;
            }
        }
        int dist=index-is;
        TreeNode root=new TreeNode(pre[ps]);
        root.left=helper(pre,in,is,index-1,ps+1,ps+dist);
        root.right=helper(pre,in,index+1,ie,ps+dist+1,pe);
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        int in[]=new int[preorder.length];
        for(int i=0;i<preorder.length;++i)
        {
            in[i]=preorder[i];
        }
        Arrays.sort(in);
        return helper(preorder,in,0,in.length-1,0,in.length-1);
    }
}
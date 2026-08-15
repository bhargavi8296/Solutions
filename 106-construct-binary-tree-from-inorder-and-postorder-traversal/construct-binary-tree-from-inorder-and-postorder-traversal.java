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
    public TreeNode helper(int[]i, int[]p, int is, int ie, int ps, int pe)
    {
        if(ps>pe||is>ie){return null;}
        if(ps==pe){return new TreeNode(p[ps]);}
        int index=ie;
        for(int j=ie;j>=is;--j)
        {
            if(p[pe]==i[j])
            {
                index=j;
            }
        }
        int diff=ie-index;
        TreeNode root=new TreeNode(p[pe]);
        root.right=helper(i,p,index+1,ie,pe-diff,pe-1);
        root.left=helper(i,p,is,index-1,ps,pe-diff-1);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder,postorder,0,inorder.length-1,0,inorder.length-1);
    }
}
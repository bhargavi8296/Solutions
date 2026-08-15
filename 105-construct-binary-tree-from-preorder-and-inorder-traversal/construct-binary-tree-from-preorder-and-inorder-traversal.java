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
    public TreeNode helper(int[]p, int[]i, int is, int ie, int ps, int pe)
    {
        if(ps>pe||is>ie){return null;}
        if(ps==pe){return new TreeNode(p[ps]);}
        int index=is;
        for(int j=is;j<=ie;++j)
        {
            if(p[ps]==i[j])
            {
                index=j;
            }
        }
        int dif=index-is;
        TreeNode root=new TreeNode(p[ps]);
        root.left=helper(p,i,is,index-1,ps+1,ps+dif);
        root.right=helper(p,i,index+1,ie,ps+dif+1,pe);
        return root;
       
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder,inorder,0,inorder.length-1,0,inorder.length-1);
    }
}
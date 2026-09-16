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
    public TreeNode helper(int[]preorder,int[]inorder, int is,int ie, int ps, int pe)
    {
        if(is>ie||ps>pe){return null;}
        if(is==ie){return new TreeNode(preorder[ps]);}
        int index=is;
        for(int i=is;i<=ie;++i)
        {
            if(inorder[i]==preorder[ps])
            {
                index=i;
            }
        }
        int diff=index-is;
        //System.out.println(is+" "+ie+" "+ps+" "+pe);
        TreeNode root=new TreeNode(preorder[ps]);
        root.left=helper(preorder,inorder,is,index-1,ps+1,ps+diff);
        root.right=helper(preorder,inorder,index+1,ie,ps+diff+1,pe);
        return root; 
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder,inorder, 0,preorder.length-1,0,inorder.length-1);
    }
}
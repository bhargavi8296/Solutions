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
    public TreeNode helper(int[] inorder, int[] postorder,int is, int ie, int ps,int pe)
    {
        if(is>ie||ps>pe){return null;}
        if(is==ie){return new TreeNode(postorder[pe]);}
        int index=is;
        for(int i=is;i<=ie;++i)
        {
            if(inorder[i]==postorder[pe])
            {
                index=i;break;
            }
        }
        int diff=index-is;
        TreeNode root=new TreeNode(postorder[pe]);
        root.left=helper(inorder,postorder,is,index-1,ps,ps+diff-1);
        root.right=helper(inorder,postorder,index+1,ie,ps+diff,pe-1);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder,postorder,0,inorder.length-1,0,inorder.length-1);
    }
}
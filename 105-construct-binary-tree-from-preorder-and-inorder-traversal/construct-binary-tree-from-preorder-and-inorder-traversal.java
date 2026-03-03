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
    public TreeNode helper(int[]preorder,int[]inorder, int prestart, int preend,int instart,int inend)
    {
        if(prestart>preend){return null;}
        if(instart==inend){return new TreeNode(inorder[instart]);}
        TreeNode root=new TreeNode(preorder[prestart]);
        int val=preorder[prestart];
        int prelast=preend;
        int inlast=inend;
        for(int i=instart;i<=inend;++i)
        {
            if(inorder[i]==val)
            {
                inlast=i;break;
            }
        }
        prelast=prestart+(inlast-instart);
        root.left= helper(preorder,inorder,prestart+1,prelast,instart,inlast-1);
        root.right=helper(preorder,inorder,prelast+1,preend,inlast+1,inend);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
       return helper(preorder,inorder,0, preorder.length-1,0,inorder.length-1);
    }
}
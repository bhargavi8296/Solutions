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
    public TreeNode insert(TreeNode root,int value,TreeNode insert)
    {
        if(root==null)
        {
            return insert;
        }
        if(root.val>value){root.left=insert(root.left,value,insert);}
        else{root.right=insert(root.right,value,insert);}
        return root;
    }
    public TreeNode helper(TreeNode root, int key)
    {
        if(root==null){return null;}
        if(key<root.val){root.left=helper(root.left,key); }
        else if(root.val==key){if(root.left==null||root.right==null){return root.left==null?root.right:root.left;}
        else{return insert(root.left,root.val,root.right);}
        }
        else{root.right=helper(root.right,key);}
        return root;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        return helper(root,key);
    }
}
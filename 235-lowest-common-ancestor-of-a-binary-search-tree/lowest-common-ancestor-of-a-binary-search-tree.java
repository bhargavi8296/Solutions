/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode helper(TreeNode root, TreeNode p, TreeNode q)
    {
        if(root==null){return null;}
        if(p==root||q==root||(p.val<root.val&&q.val>root.val)){return root;}
        if(q.val<root.val){return lowestCommonAncestor(root.left,p,q);}
        return lowestCommonAncestor(root.right,p,q);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val>q.val){return helper(root,q,p);}
        return helper(root,p,q);
    }
}
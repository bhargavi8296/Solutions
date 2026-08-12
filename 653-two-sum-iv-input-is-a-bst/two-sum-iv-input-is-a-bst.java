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
    Set<Integer>set;
    public boolean helper(TreeNode root, int k)
    {
        if(root==null){return false;}
        if(helper(root.left,k)){return true;}
        if(set.contains(k-root.val)){return true;}
        set.add(root.val);
        return helper(root.right,k);
    }
    public boolean findTarget(TreeNode root, int k) {
        set=new HashSet<>();
        return helper(root,k);
    }
}
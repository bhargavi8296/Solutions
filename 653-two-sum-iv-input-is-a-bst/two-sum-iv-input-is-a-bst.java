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
    Map<Integer,Integer>map=new HashMap<>();
    public boolean helper(TreeNode root, int k)
    {
        if(root==null){return false;}
        boolean left=helper(root.left,k);
        if(left){return true;}
        if(map.containsKey(k-root.val)){return true;}
        map.put(root.val,1);
        return helper(root.right,k);
    }
    public boolean findTarget(TreeNode root, int k) {
        return helper(root,k);
    }
}
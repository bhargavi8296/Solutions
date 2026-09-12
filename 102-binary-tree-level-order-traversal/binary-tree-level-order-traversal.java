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
    List<List<Integer>>result=new ArrayList<>();
    public void helper(TreeNode root, int h)
    {
        if(root==null){return;}
        if(result.size()<h){result.add(new ArrayList<>());}
        result.get(h-1).add(root.val);
        helper(root.left,h+1);
        helper(root.right,h+1);
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        helper(root,1);
        return result;
    }
}
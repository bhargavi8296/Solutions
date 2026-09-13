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
    List<List<Integer>>list;
    public void helper(TreeNode root, int h)
    {
        if(root==null){return;}
        if(list.size()<h){list.add(new ArrayList<>());}
        if(h%2==1){list.get(h-1).add(root.val);}
        else{
            list.get(h-1).add(0,root.val);
        }
        helper(root.left,h+1);
        helper(root.right,h+1);
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        list=new ArrayList<>();
        helper(root,1);
        return list;
    }
}
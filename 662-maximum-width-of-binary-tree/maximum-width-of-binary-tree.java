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
    int max=0;
    Map<Integer,Integer>map;
    public void helper(TreeNode root,int h, int i)
    {
        if(root==null){return ;}
        if(!map.containsKey(h)){map.put(h,i);}
        //System.out.println(map.get(h)+" "+i);
        max=Math.max(max,i-map.get(h)+1);
        helper(root.left,h+1,2*i+1);
        helper(root.right,h+1,2*i+2);

    }
    public int widthOfBinaryTree(TreeNode root) {
        map=new HashMap<>();
        helper(root, 0,0);
        return max;
    }
}
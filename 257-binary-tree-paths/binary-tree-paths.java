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
    List<String>result;
    public void helper(TreeNode root, String str)
    {
        if(root==null){return;}
        if(str.equals("")){str+=root.val;}
        else{str+=("->"+root.val);}
        if(root.left==null&&root.right==null){result.add(str);return;}
        helper(root.left,str);
        helper(root.right,str);
    }
    public List<String> binaryTreePaths(TreeNode root) {
        result=new ArrayList<>();
        helper(root,"");
        return result;
    }
}
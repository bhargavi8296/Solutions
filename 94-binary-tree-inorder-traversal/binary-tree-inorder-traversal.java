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
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root==null){return new ArrayList<>();}
        List<Integer>result=new ArrayList<>();
        Stack<TreeNode>stack=new Stack<>();
        stack.add(root);
        while(!stack.isEmpty())
        {
            TreeNode temp=stack.pop();
            if(temp.right!=null){stack.add(temp.right);temp.right=null;}
            if(temp.left!=null){TreeNode t=temp.left;temp.left=null;stack.add(temp);stack.add(t);}
            else{
                result.add(temp.val);
            }
        }
        return result;
    }
}

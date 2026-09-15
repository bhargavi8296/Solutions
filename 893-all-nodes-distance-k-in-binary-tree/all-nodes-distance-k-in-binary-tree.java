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
    Map<TreeNode,TreeNode>map;
    List<Integer>result;
    public void helper(TreeNode root,TreeNode par)
    {
        if(root==null){return;}
        map.put(root,par);
        helper(root.left,root);
        helper(root.right,root);
    }
    public void helper1(TreeNode root,TreeNode par, int k)
    {
        if(root==null){return;}
        if(k==0){result.add(root.val);return;}
        if(root.left!=par){helper1(root.left,root,k-1);}
        if(root.right!=par){helper1(root.right,root,k-1);}
        if(map.get(root)!=par){helper1(map.get(root),root,k-1);}
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        map=new HashMap<>();
        result=new ArrayList<>();
        helper(root,null);
        helper1(target,null,k);
        return result;
    }
}
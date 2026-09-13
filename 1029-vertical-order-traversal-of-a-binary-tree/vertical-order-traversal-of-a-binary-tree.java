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
    Map<Integer,Map<Integer,List<Integer>>>map=new TreeMap<>();
    public void helper(TreeNode root, int i,int h)
    {
        if(root==null){return;}
        if(!map.containsKey(i))
        {
            map.put(i,new TreeMap<>());
        }
        if(!map.get(i).containsKey(h)){map.get(i).put(h,new ArrayList<>());}
        map.get(i).get(h).add(root.val);
        helper(root.left,i-1,h+1);
        helper(root.right,i+1,h+1);
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        helper(root,0,0);
        List<List<Integer>>result=new ArrayList<>();
        for (Map.Entry<Integer, Map<Integer,List<Integer>>> entry : map.entrySet()) {
            List<Integer>temp=new ArrayList<>();
            for (Map.Entry<Integer, List<Integer>> e : entry.getValue().entrySet())
                {Collections.sort(e.getValue());
                temp.addAll(e.getValue());}
                result.add(temp);
        }
        return result;
    }
}
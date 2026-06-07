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
    Set<Integer>p=new HashSet<>();
    Set<Integer>c=new HashSet<>();
    HashMap<Integer,TreeNode>map=new HashMap<>();
    public TreeNode createBinaryTree(int[][] descriptions) {
        for(int i=0;i<descriptions.length;++i)
        {
            p.add(descriptions[i][0]);
            c.add(descriptions[i][1]);
            if(!map.containsKey(descriptions[i][0])){map.put(descriptions[i][0],new TreeNode(descriptions[i][0]));}
            if(!map.containsKey(descriptions[i][1])){map.put(descriptions[i][1],new TreeNode(descriptions[i][1]));}
            int n=descriptions[i][2];
            if(n==1){map.get(descriptions[i][0]).left=map.get(descriptions[i][1]);}
            else{map.get(descriptions[i][0]).right=map.get(descriptions[i][1]);}
        }
        int root=0;
        for(int val:p)
        {
            if(!c.contains(val))
            {
                root=val;break;
            }
        }
        return map.get(root);
    }
}
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
    public int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode>queue=new LinkedList<>();
        root.val=0;
        int max=0;
        queue.add(root);
        while(!queue.isEmpty())
        {
            int size=queue.size();
            int first=-1;
            int last=-1;
            for(int i=0;i<size;++i)
            {
                TreeNode temp=queue.poll();
                if(first==-1)
                {
                    first=temp.val;
                }
                last=temp.val;
                if(temp.left!=null)
                {
                    temp.left.val=temp.val*2+1;
                    queue.add(temp.left);
                }
                if(temp.right!=null)
                {
                    temp.right.val=temp.val*2+2;
                    queue.add(temp.right);
                }
            }
            max=Math.max(max,last-first+1);
        }
        return max;
    }
}
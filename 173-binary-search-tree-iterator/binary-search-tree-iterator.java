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
class BSTIterator {
    List<Integer>list;
    int i=0;
    public void helper(TreeNode root)
    {
        if(root==null){return;}
        helper(root.left);
        list.add(root.val);
        helper(root.right);
    }
    public BSTIterator(TreeNode root) {
        list=new ArrayList<>();
        helper(root);
    }
    
    public int next() {
        int temp=list.get(i);
        ++i;
        return temp;
    }
    
    public boolean hasNext() {
        return i<list.size()?true:false;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
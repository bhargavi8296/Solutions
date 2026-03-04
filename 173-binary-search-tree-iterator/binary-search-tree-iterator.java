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
    TreeNode head=null;
    TreeNode next=null;
    TreeNode t;
    public void helper(TreeNode root)
    {
        if(root==null){return ;}
        helper(root.left);
        if(head==null){head=new TreeNode(root.val);next=head;}
        else{next.right=new TreeNode(root.val);next=next.right;}
        helper(root.right);
    }
    public BSTIterator(TreeNode root) {
        t=root;
        helper(t);
    }
    
    public int next() {
        if(head==null){return -1;}
        int val=head.val;
        head=head.right;
        return val;
    }
    
    public boolean hasNext() {
        return head==null?false:true;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
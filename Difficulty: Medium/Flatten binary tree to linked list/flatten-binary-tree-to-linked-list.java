// User function Template for Java

class Solution {
    static Node prev=null;
    public static Node helper(Node root)
    {
        if(root==null){return null;}
        if(root.left==null&&root.right==null){prev=root;return root;}
        Node left=helper(root.left);
        Node temp=root.right;
        if(left!=null)
        {
            root.right=left;
            root.left=null;
        }
        prev.right=helper(temp);
        return root;
    }
    public static void flatten(Node root) {
        // code here
        helper(root);
    }
}
 


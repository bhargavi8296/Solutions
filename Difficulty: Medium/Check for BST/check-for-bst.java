/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    Node prev=null;
    public boolean helper(Node root)
    {
        if(root==null){return true;}
        boolean left=helper(root.left);
        //System.out.print(root.data);
        if(!left){return false;}
        else if(prev!=null&&prev.data>=root.data){return false;}
        prev=root;
        return helper(root.right);
    }
    public boolean isBST(Node root) {
        // code here
        return helper(root);
    }
}
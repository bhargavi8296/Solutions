/* class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
} */

class Solution {
    int res;
    public boolean helper(Node root, int x)
    {
        if(root==null){return false;}
        if(root.data==x){res=root.data; return true;}
        else if(root.data>x){if(!helper(root.left,x)){res=root.data;}return true;}
        return helper(root.right,x);
    }
    int findCeil(Node root, int x) {
        // code here
        res=-1;
        helper(root,x);
        return res;
    }
}
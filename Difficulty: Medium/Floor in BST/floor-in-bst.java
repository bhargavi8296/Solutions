/*
class Node {
    int data;
    Node left, right;

    Node(int val)
    {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    static int res;
    public static boolean helper(Node root, int x)
    {
        if(root==null){return false;}
        if(root.data==x){res=root.data; return true;}
        else if(root.data<x){if(!helper(root.right,x)){res=root.data;}return true;}
        return helper(root.left,x);
    }
    public static int floor(Node root, int x) {
        // code here
        res=-1;
        helper(root,x);
        return res;
    }
}
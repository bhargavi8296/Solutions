/*
class Node {
    int data;
    Node left, right;
    Node(int x) {
        data = x;
        left = right = null;
    }
}
*/

class Solution {
    Node pre=null;
    Node suc=null;
    public void helper(Node root,int key)
    {
        if(root==null){return;}
        helper(root.left,key);
        if(root.data<key&&(pre==null||pre.data<root.data)){pre=root;}
        else if(root.data>key&&(suc==null||suc.data>root.data)){suc=root;}
        helper(root.right,key);
    }
    public ArrayList<Node> findPreSuc(Node root, int key) {
        // code here
        helper(root,key);
        ArrayList<Node>res=new ArrayList<>();
        res.add(pre);
        res.add(suc);
        return res;
    }
}
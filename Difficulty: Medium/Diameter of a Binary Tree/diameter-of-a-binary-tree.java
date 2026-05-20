/*
Definition for Node
class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = right = null;
    }
} */

class Solution {
    int max=Integer.MIN_VALUE;
    public int helper(Node root)
    {
        if(root==null){return 0;}
        int left=helper(root.left);
        int right=helper(root.right);
        max=Math.max(max,left+right);
        return Math.max(left,right)+1;
    }
    public int diameter(Node root) {
        // code here
        helper(root);
        return max;
        
    }
}
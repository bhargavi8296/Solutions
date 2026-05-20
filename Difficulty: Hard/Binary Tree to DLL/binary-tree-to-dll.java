/*
class Node {
    int data;
    Node left, right;

    Node() {
        this.data = 0;
        this.left = this.right = null;
    }

    Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}
*/
class Solution {
    Node prev=null;
    Node head=null;
    void helper(Node root)
    {
        if(root==null){return ;}
        helper(root.left);
        if(prev!=null)
        {
            root.left=prev;
            prev.right=root;
        }
        else
        {
            head=root;
        }
        prev=root;
        helper(root.right);
    }
    Node bToDLL(Node root) {
        // code here
        helper(root);
        return head;
        
    }
}
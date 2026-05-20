/*
class Node
{
    int data;
    Node left;
    Node right;
    Node(int data)
    {
        this.data = data;
        left=null;
        right=null;
    }
}
*/
class Solution {
    // return the Kth largest element in the given BST rooted at 'root'
    int prev=0;
    int result=-1;
    public void helper(Node root, int k)
    {
        if(root==null){return ;}
        helper(root.right,k);
        if(prev+1==k){result=root.data;}
        ++prev;
        helper(root.left,k);
        //prev=r+1;
        
    }
    public int kthLargest(Node root, int k) {
        // Your code here
        helper(root,k);
        return result;
    }
}
//     4
// 2   9
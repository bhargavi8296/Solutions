/*Complete the function below
Node is as follows:
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
*/
class Solution {
    // returns the inorder successor of the Node x in BST (rooted at 'root')
    int val;
    boolean flag=false;
    public void helper(Node root,Node x)
    {
        if(root==null){return;}
        helper(root.left,x);
        if(flag){val=root.data;flag=false;}
        if(root==x){flag=true;}
        helper(root.right,x);
    }
    public int inorderSuccessor(Node root, Node x) {
        // add code here.
        val=-1;
        helper(root,x);
        return val;
    }
}
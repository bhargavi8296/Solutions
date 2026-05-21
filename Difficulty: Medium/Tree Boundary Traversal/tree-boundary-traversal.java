/*
Definition for Node
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    
    ArrayList<Integer> boundaryTraversal(Node root) {
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        if(root == null)
            return ans;
        
        // root add karo agar leaf nahi hai
        if(!isLeaf(root))
            ans.add(root.data);
        
        // left boundary
        addLeftBoundary(root, ans);
        
        // sare leaf nodes
        addLeaves(root, ans);
        
        // right boundary
        addRightBoundary(root, ans);
        
        return ans;
    }
    
    boolean isLeaf(Node node)
    {
        return node.left == null && node.right == null;
    }
    
    void addLeftBoundary(Node root, ArrayList<Integer> ans)
    {
        Node curr = root.left;
        
        while(curr != null)
        {
            if(!isLeaf(curr))
                ans.add(curr.data);
            
            // agar left nahi hai toh right se jao
            if(curr.left != null)
                curr = curr.left;
            else
                curr = curr.right;
        }
    }
    
    void addLeaves(Node root, ArrayList<Integer> ans)
    {
        if(root == null)
            return;
        
        if(isLeaf(root))
        {
            ans.add(root.data);
            return;
        }
        
        addLeaves(root.left, ans);
        addLeaves(root.right, ans);
    }
    
    void addRightBoundary(Node root, ArrayList<Integer> ans)
    {
        Node curr = root.right;
        Stack<Integer> st = new Stack<>();
        
        while(curr != null)
        {
            if(!isLeaf(curr))
                st.push(curr.data);
            
            // agar right nahi hai toh left se jao
            if(curr.right != null)
                curr = curr.right;
            else
                curr = curr.left;
        }
        
        // reverse order mein add karna hai
        while(!st.isEmpty())
        {
            ans.add(st.pop());
        }
    }
}
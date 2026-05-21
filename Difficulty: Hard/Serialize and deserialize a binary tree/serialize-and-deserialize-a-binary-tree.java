/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}*/

class Solution {
    public ArrayList<Integer> serialize(Node root) {
        // code here
        ArrayList<Integer>result=new ArrayList<>();
        Queue<Node>q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            Node temp=q.poll();
            int t=temp==null?-1:temp.data;
            result.add(t);
            if(temp!=null)
            {
                q.add(temp.left);
                q.add(temp.right);
            }
        }
        return result;
    }

    public Node deSerialize(ArrayList<Integer> arr) {
        
        // code here
        Queue<Node>q=new LinkedList<>();
        Node root=new Node(arr.get(0));
        q.add(root);
        int i=1;
        while(!q.isEmpty())
        {
            Node curr = q.poll();
            if(arr.get(i)!=-1)
            {
                curr.left=new Node(arr.get(i));
                q.add(curr.left);
            }
            ++i;
            if(arr.get(i)!=-1)
            {
                curr.right=new Node(arr.get(i));
                q.add(curr.right);
            }
            ++i;
        }
        return root;
    }
};
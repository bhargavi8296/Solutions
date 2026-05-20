/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
*/

class Solution {
    public ArrayList<Integer> leftView(Node root) {
        // code here
        if(root==null){return new ArrayList<>();}
        Queue<Node>q=new LinkedList<>();
        q.add(root);
        ArrayList<Integer>result=new ArrayList<>();
        while(!q.isEmpty())
        {
            int size=q.size();
            int temp=-1;
            while(size>0)
            {
                Node tem=q.poll();
                if(tem.left!=null){q.add(tem.left);}
                if(tem.right!=null){q.add(tem.right);}
                if(temp==-1)
                {
                    temp=tem.data;
                }
                --size;
            }
            result.add(temp);
        }
        return result;
    }
}
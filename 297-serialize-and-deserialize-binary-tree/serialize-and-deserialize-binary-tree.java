/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null){return "N";}
        Stack<TreeNode>st=new Stack<>();
        String str=root.val+"";
        st.push(root);
        while(!st.isEmpty())
        {
            TreeNode temp=st.pop();
            if(temp==null){continue;}
            if(temp.left!=null){str=str+","+temp.left.val;}
            else{str+=",N";}
            if(temp.right!=null){str=str+","+temp.right.val;}
            else{str=str+",N";}
            st.push(temp.right);
            st.push(temp.left);
        }
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        //System.out.println(data);
         if(data.equals("N")){return null;}
         String []d=data.split(",");
        TreeNode root=new TreeNode(Integer.parseInt(d[0]));
        Stack<TreeNode>stack=new Stack<>();
        stack.push(root);
        for(int i=1;i<d.length;)
        {
            TreeNode temp=stack.pop();
            if(d[i].equals("N")){temp.left=null;}
            else{
                temp.left=new TreeNode(Integer.parseInt(d[i]));
            }
            ++i;
            if(d[i].equals("N")){temp.right=null;}
            else{
                temp.right=new TreeNode(Integer.parseInt(d[i]));
            }
            ++i;
            if(temp.right!=null){stack.push(temp.right);}
            if(temp.left!=null){stack.push(temp.left);}
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
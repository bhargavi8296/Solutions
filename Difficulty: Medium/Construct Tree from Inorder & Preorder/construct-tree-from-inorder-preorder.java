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
    public static Node helper(int in[],int pre[],int is, int ie, int ps, int pe)
    {
        //System.out.println(is+" "+ie+" "+ps+" "+pe);
    
        if(is>ie||ps>pe){return null;}
        if(is==ie){return new Node(in[is]);}
        int index=0;
        for(int i=is;i<=ie;++i)
        {
            if(in[i]==pre[ps])
            {
                index=i;break;
            }
        }
        int left=index-is-1;
        Node root=new Node(pre[ps]);
        root.left=helper(in,pre,is,index-1,ps+1,ps+left+1);
        root.right=helper(in,pre,index+1,ie,ps+left+2,pe);
        return root;
    }
    public static Node buildTree(int inorder[], int preorder[]) {
        // code here
        return helper(inorder,preorder,0,inorder.length-1,0,inorder.length-1);
        
    }
}
class Solution {
    int res=0;
    public int helper(TreeNode root)
    {
        if(root==null){return 0;}
        if(root.left==null&&root.right==null){res+=1;return 1;}
        int left=helper(root.left);
        int right=helper(root.right);
        int temp=root.val;
        if(root.left!=null){root.val+=root.left.val;}
        if(root.right!=null){root.val+=root.right.val;}
        if((root.val/(left+right+1))==temp){++res;}
        return left+right+1;
    }
    public int averageOfSubtree(TreeNode root) {
        helper(root);
        return res;
    }
}
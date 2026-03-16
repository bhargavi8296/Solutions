class Solution {
    int dp[][];
    public int helper(String s1,String s2, int i, int j)
    {
        if(i<0||j<0){return 0;}
        if(dp[i][j]!=-1){return dp[i][j];}
        if(s1.charAt(i)==s2.charAt(j))
        {
            return dp[i][j]=1+helper(s1,s2,i-1,j-1);
        }
        return dp[i][j]=Math.max(helper(s1,s2,i-1,j),helper(s1,s2,i,j-1));
    }
    public int minInsertions(String s) {
        dp=new int[s.length()+1][s.length()+1];
        for(int i=0;i<s.length()+1;++i)
        {
            Arrays.fill(dp[i],-1);
        }
        int res=helper(s,new StringBuilder(s).reverse().toString(),s.length()-1,s.length()-1);
        return s.length()-res;
    }
}
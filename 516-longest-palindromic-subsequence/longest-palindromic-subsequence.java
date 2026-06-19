class Solution {
    int dp[][];
    public int helper(String s, String t, int i, int j)
    {
        if(i<0||j<0){return 0;}
        if(dp[i][j]!=-1){return dp[i][j];}
        if(s.charAt(i)==t.charAt(j))
        {
            return dp[i][j]=helper(s,t,i-1,j-1)+1;
        }
        return dp[i][j]=Math.max(helper(s,t,i-1,j),helper(s,t,i,j-1));
    }
    public int longestPalindromeSubseq(String s) {
        dp=new int[s.length()+1][s.length()+1];
        for(int i=0;i<s.length()+1;++i)
        {
            Arrays.fill(dp[i],-1);
        }
        return helper(s,new StringBuffer(s).reverse().toString(),s.length()-1,s.length()-1);
    }
}
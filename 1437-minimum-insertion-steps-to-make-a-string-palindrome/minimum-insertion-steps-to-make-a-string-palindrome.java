class Solution {
    int dp[][];
    public int helper(String s, int i, int j)
    {
        if(i>j){return 0;}
        if(i>=s.length()||j<0){return 501;}
        if(dp[i][j]!=501){return dp[i][j];}
        if(s.charAt(i)==s.charAt(j))
        {
            return dp[i][j]=helper(s,i+1,j-1);
        }
        return dp[i][j]=Math.min(helper(s,i+1,j-1)+2,Math.min(helper(s,i+1,j),helper(s,i,j-1))+1);
    }
    public int minInsertions(String s) {
        dp=new int[s.length()+1][s.length()+1];
        for(int i=0;i<s.length()+1;++i)
        {
            Arrays.fill(dp[i],501);
        }
        return helper(s,0,s.length()-1);
    }
}
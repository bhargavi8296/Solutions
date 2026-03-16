class Solution {
    int dp[][];
    public int helper(String s, String t, int i, int j)
    {
        if(j<0){return 1;}
        if(i<0){return 0;}
        if(dp[i][j]!=-1){return dp[i][j];}
        int res=0;
        if(s.charAt(i)==t.charAt(j))
        {
             res=helper(s,t,i-1,j-1);
        }
         res+=helper(s,t,i-1,j);
         return dp[i][j]=res;
    }
    public int numDistinct(String s, String t) {
        dp=new int[s.length()][t.length()];
        for(int i=0;i<s.length();++i)
        {
            Arrays.fill(dp[i],-1);
        }
        return helper(s,t,s.length()-1,t.length()-1);
    }
}
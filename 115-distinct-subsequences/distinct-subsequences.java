class Solution {
    int dp[][];
    public int helper(String s, String t , int i, int j)
    {
        if(j<0){return 1;}
        if(i<0){return 0;}
        if(dp[i][j]!=-1){return dp[i][j];}
        int count=0;
        if(s.charAt(i)==t.charAt(j))
        {
            count=helper(s,t,i-1,j-1);
        }
        return dp[i][j]= count+helper(s,t,i-1,j);
    }
    public int numDistinct(String s, String t) {
        dp=new int[s.length()+1][t.length()+1];
        for(int i=0;i<s.length()+1;++i)
        {
            Arrays.fill(dp[i],-1);
        }
        return helper(s,t,s.length()-1,t.length()-1);
    }
}
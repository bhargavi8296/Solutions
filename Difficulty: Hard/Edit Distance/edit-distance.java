class Solution {
    int dp[][];
    public int helper(String s1, String s2, int i, int j)
    {
        if(i<0&&j<0){return 0;}
        if(i<0||j<0){return Math.max(i,j)+1;}
        if(dp[i][j]!=-1){return dp[i][j];}
        if(s1.charAt(i)==s2.charAt(j))
        {
            return dp[i][j]=helper(s1,s2,i-1,j-1);
        }
        return dp[i][j]= Math.min(helper(s1,s2,i-1,j),Math.min(helper(s1,s2,i,j-1),helper(s1,s2,i-1,j-1)))+1;
    }
    public int editDistance(String s1, String s2) {
        // code here
        dp=new int[s1.length()+1][s2.length()+1];
        for(int i=0;i<s1.length()+1;++i)
        {
            Arrays.fill(dp[i],-1);
        }
        return helper(s1,s2,s1.length()-1,s2.length()-1);
    }
}
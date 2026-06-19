class Solution {
    int dp[][];
    public boolean helper(String s, String t, int i, int j)
    {
        if(i<0&&j<0){return true;}
        if(i<0){if(t.charAt(j)=='*'){return helper(s,t,i,j-1);}return false;}
        if(j<0){return false;}
        if(dp[i][j]!=-1){return dp[i][j]==1?true:false;}
        boolean flag;
        if(t.charAt(j)=='?')
        {
            flag= helper(s,t,i-1,j-1);
        }
        else if(t.charAt(j)=='*')
        {
            flag= helper(s,t,i-1,j-1)||helper(s,t,i,j-1)||helper(s,t,i-1,j);
        }
        else if(s.charAt(i)!=t.charAt(j))
        {
            flag= false;
        }
        else
        {flag= helper(s,t,i-1,j-1);}
        dp[i][j]=flag==true?1:0;
        return flag;
    }
    public boolean isMatch(String s, String p) {
        dp=new int[s.length()+1][p.length()+1];
        for(int i=0;i<s.length()+1;++i)
        {
            Arrays.fill(dp[i],-1);
        }
        return helper(s,p,s.length()-1,p.length()-1);
    }
}
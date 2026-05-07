class Solution {
    int dp[][];
    public boolean helper(String s, String p, int i, int j)
    {
        if(i==0&&j==0){return true;}
        else if(i>0&&j==0){return false;}
        else if(i==0&&j>0){if(p.charAt(j-1)=='*'){return helper(s,p,i,j-1);}return false;}
        if(dp[i][j]!=-1){return dp[i][j]==1?true:false;}
        boolean flag;
        if(p.charAt(j-1)=='?'){
            flag=helper(s,p,i-1,j-1);
            dp[i][j]=flag==true?1:0;
            return flag;
            }
        else if(p.charAt(j-1)>='a'&&p.charAt(j-1)<='z')
        {
            if(p.charAt(j-1)!=s.charAt(i-1)){flag= false;}
            else{flag=helper(s,p,i-1,j-1);}
            dp[i][j]=flag==true?1:0;
            return flag;
        }
        flag=helper(s,p,i-1,j)||helper(s,p,i,j-1);
        dp[i][j]=flag==true?1:0;
        return flag;

    }
    public boolean isMatch(String s, String p) {
        dp=new int[s.length()+1][p.length()+1];
        for(int i=0;i<s.length()+1;++i)
        {
            Arrays.fill(dp[i],-1);
        }
            return helper(s,p,s.length(),p.length());
    }
}
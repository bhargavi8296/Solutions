class Solution {
    int dp[][];
    public int helper(String s1, String s2, int i, int j)
    {
        if(i<0||j<0){return 0;}
        if(dp[i][j]!=-1){return dp[i][j];}
        int count=0;
        int i1=i;
        int j1=j;
        while(i>=0&&j>=0&&s1.charAt(i)==s2.charAt(j))
        {
            --i;--j;++count;
        }
        if(i<0||j<0){return count;}
        return dp[i][j]= Math.max(count,Math.max(helper(s1,s2,i1-1,j1),helper(s1,s2,i1,j1-1)));
    }
    public int longCommSubstr(String s1, String s2) {
        // code here
        dp=new int[s1.length()+1][s2.length()+1];
        for(int i=0;i<s1.length()+1;++i)
        {
            Arrays.fill(dp[i],-1);
        }
        return helper(s1,s2,s1.length()-1,s2.length()-1);
    }
}



class Solution {
    int max;
    int dp[][];
    public int helper(String s1, String s2, int i, int j)
    {
        //System.out.println(i+" "+j);
        if(i<0||j<0){return 0;}
        if(dp[i][j]!=-1){return dp[i][j];}
        if(s1.charAt(i)==s2.charAt(j))
        {
            //System.out.println(s1.charAt(i)+" "+s2.charAt(j)+" "+i+" "+j);
            dp[i][j]=helper(s1,s2,i-1,j-1)+1;
            max=Math.max(max,dp[i][j]);
        }
        else
        {
            dp[i][j]=0;
        }
        helper(s1,s2,i-1,j);
        helper(s1,s2,i,j-1);
        return dp[i][j];
    }
    public int longCommSubstr(String s1, String s2) {
        // code here
        max=0;
        dp=new int[s1.length()+1][s2.length()+1];
        for(int i=0;i<s1.length()+1;++i)
        {
            Arrays.fill(dp[i],-1);
        }
        helper(s1,s2,s1.length()-1,s2.length()-1);
        return max;
    }
}
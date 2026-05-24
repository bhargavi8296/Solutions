class Solution {
    static int dp[][];
    public static int helper(String s1,String s2,int i, int j)
    {
        if(i<0||j<0){return 0;}
        if(dp[i][j]!=-1){return dp[i][j];}
        int ans=-1;
        if(s1.charAt(i)==s2.charAt(j)){
            ans=Math.max(ans,1+helper(s1,s2,i-1,j-1));
        }
        return dp[i][j]=Math.max(ans,Math.max(helper(s1,s2,i-1,j),helper(s1,s2,i,j-1)));
    }
    static int lcs(String s1, String s2) {
        // code here
        dp=new int[s1.length()+1][s2.length()+1];
        for(int i=0;i<s1.length()+1;++i)
        {
            Arrays.fill(dp[i],-1);
        }
        return helper(s1,s2, s1.length()-1,s2.length()-1);
    }
}
class Solution {
    int dp[][];
    public int helper(String s,String r,int i,int j)
    {
        if(i==s.length()|| j==s.length())
        {
            return 0;
        }
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        if(s.charAt(i)==r.charAt(j))
        {
            return dp[i][j]=helper(s,r,i+1,j+1)+1;
        }
        return dp[i][j]=Math.max(helper(s,r,i+1,j),helper(s,r,i,j+1));
    }
    public int minInsertions(String s) {
         StringBuilder input1 = new StringBuilder();
        input1.append(s);
        dp=new int[s.length()][s.length()];
        for(int i=0;i<s.length();++i)
        {
            Arrays.fill(dp[i],-1);
        }
        String t=new String(input1.reverse());
        int max=helper(s,t,0,0);
        return s.length()-max;
    }
}
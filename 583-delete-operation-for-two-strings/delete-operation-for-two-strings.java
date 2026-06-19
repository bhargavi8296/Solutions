class Solution {
    int dp[][];
    public int helper(String s, String t, int i, int j)
    {
        if(i<0&&j<0){return 0;}
        if(i<0||j<0){return i<0?j+1:i+1;}
        if(dp[i][j]!=501){return dp[i][j];}
        if(s.charAt(i)==t.charAt(j))
        {
            return dp[i][j]=helper(s,t,i-1,j-1);
        }
        return dp[i][j]=Math.min(helper(s,t,i-1,j),helper(s,t,i,j-1))+1;
    }
    public int minDistance(String word1, String word2) {
        dp=new int[word1.length()+1][word2.length()+1];
        for(int i=0;i<word1.length()+1;++i)
        {
            Arrays.fill(dp[i],501);
        }
        return helper(word1,word2,word1.length()-1,word2.length()-1);
    }
}
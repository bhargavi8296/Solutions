class Solution {
    int dp[][];
    public int helper(String s1, String s2, int i, int j)
    {
        if(i<0||j<0){return 0;}
        if(dp[i][j]!=-1){return dp[i][j];}
        if(s1.charAt(i)==s2.charAt(j))
        {
            return dp[i][j]=1+helper(s1,s2,i-1,j-1);
        }
        return dp[i][j]=Math.max(helper(s1,s2,i-1,j),helper(s1,s2,i,j-1));
    }
    public int minDistance(String word1, String word2) {
        dp=new int[word1.length()+1][word2.length()+1];
        for(int i=0;i<word1.length()+1;++i)
        {
            Arrays.fill(dp[i],-1);
        }
        return word1.length()+word2.length()-2*(helper(word1,word2,word1.length()-1,word2.length()-1));
    }
}
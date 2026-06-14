class Solution {
    int dp[][];
    List<List<Integer>> tri;
    public int helper( int r, int c)
    {
        if(r==tri.size()-1){return tri.get(r).get(c);}
        if(dp[r][c]!=Integer.MAX_VALUE){return dp[r][c];}
        List<Integer> row = tri.get(r);
        return dp[r][c]=row.get(c)+Math.min(helper(r+1,c),helper(r+1,c+1));
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        dp=new int[triangle.size()][triangle.size()];
        for(int i=0;i<triangle.size();++i)
        {
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        tri=triangle;
        int ans=helper(0,0);
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}
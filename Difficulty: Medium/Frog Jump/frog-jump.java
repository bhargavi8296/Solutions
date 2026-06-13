class Solution {
    int minCost(int[] height) {
        // code here
        int newH[]=new int[height.length+1];
        int dp[]=new int[height.length+1];
        newH[newH.length-1]=Integer.MAX_VALUE;
        for(int i=0;i<height.length;++i)
        {
            newH[i]=height[i];
        }
        for(int i=height.length-2;i>=0;--i)
        {
            dp[i]=Math.min(dp[i+1]+Math.abs(newH[i]-newH[i+1]),dp[i+2]+Math.abs(newH[i]-newH[i+2]));
        }
        return dp[0];
    }
}
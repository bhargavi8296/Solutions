class Solution {
    int dp[][];
    public int helper(int[]arr,int k,int i, int j)
    {
        if(i>j){return 0;}
        if(dp[i][j]!=-1){return dp[i][j];}
        int max=0;
        int result=0;
        for(int l=i;l<i+k&&l<arr.length;++l)
        {
            max=Math.max(max,arr[l]);
            int res=max*(l-i+1);
            int temp=helper(arr,k,l+1,j);
            result=Math.max(result,res+temp);
        }
        return dp[i][j]=result;
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        dp=new int[arr.length+1][arr.length+1];
        for(int i=0;i<arr.length+1;++i)
        {
            Arrays.fill(dp[i],-1);
        }
        return helper(arr,k, 0, arr.length-1);
    }
}
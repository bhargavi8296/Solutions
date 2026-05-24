class Solution {
    int dp[][];
    int helper(int arr[], int i, int flag)
    {
        if(i==arr.length){return 0;}
        if(dp[i][flag]!=-1){return dp[i][flag];}
        if(flag==0)
        {
            return dp[i][flag]=Math.max(helper(arr,i+1,1)-arr[i],helper(arr,i+1,flag));
        }
        return dp[i][flag]=Math.max(helper(arr,i+1,0)+arr[i],helper(arr,i+1,flag));
    }
    int stockBuySell(int arr[]) {
        // code here
        dp=new int[arr.length+1][2];
        for(int i=0;i<arr.length+1;++i)
        {
            Arrays.fill(dp[i],-1);
        }
        return helper(arr,0, 0);
    }
}

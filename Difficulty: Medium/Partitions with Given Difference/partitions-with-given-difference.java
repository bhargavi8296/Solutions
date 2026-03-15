class Solution {
    int dp[][];
    public int helper(int[]arr, int sum, int n)
    {
        if(n==0)
        {
            if(sum==0 && arr[0]==0) return 2;
            if(sum==0 || sum==arr[0]) return 1;
            return 0;
        }
        if(dp[n][sum]!=-1){return dp[n][sum];}
        if(arr[n]<=sum){return dp[n][sum]=helper(arr,sum-arr[n],n-1)+helper(arr,sum,n-1);}
        return dp[n][sum]=helper(arr,sum,n-1);
    }
    public int countPartitions(int[] arr, int diff) {
        // code here
        int sum=0;
        for(int val:arr){sum+=val;}
        sum+=diff;
        if(sum%2!=0){return 0;}
        sum/=2;
        int n=arr.length;
        dp=new int[n+1][sum+1];
        for(int i=0;i<n+1;++i){Arrays.fill(dp[i],-1);}
        return helper(arr,sum,n-1);
    }
}

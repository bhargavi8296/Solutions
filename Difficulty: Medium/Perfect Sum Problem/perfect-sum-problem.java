class Solution {

    int dp[][];

    int helper(int arr[], int sum, int ind)
    {
        if(ind == 0)
        {
            if(sum == 0 && arr[0] == 0) return 2;
            if(sum == 0 || sum == arr[0]) return 1;
            return 0;
        }

        if(dp[ind][sum] != -1)
        return dp[ind][sum];

        int notTake = helper(arr, sum, ind-1);

        int take = 0;
        if(arr[ind] <= sum)
        take = helper(arr, sum-arr[ind], ind-1);

        return dp[ind][sum] = take + notTake;
    }

    public int perfectSum(int[] nums, int target)
    {
        int n = nums.length;

        dp = new int[n][target+1];

        for(int i=0;i<n;i++)
        Arrays.fill(dp[i], -1);

        return helper(nums, target, n-1);
    }
}
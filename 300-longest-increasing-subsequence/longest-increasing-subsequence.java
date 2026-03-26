class Solution {
    int[][] dp;

    public int helper(int[] nums, int ind, int prev) {
        if (ind == nums.length) return 0;

        if (dp[ind][prev + 1] != -1)
            return dp[ind][prev + 1];

        // not take
        int notTake = helper(nums, ind + 1, prev);

        // take
        int take = 0;
        if (prev == -1 || nums[ind] > nums[prev]) {
            take = 1 + helper(nums, ind + 1, ind);
        }

        return dp[ind][prev + 1] = Math.max(take, notTake);
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        dp = new int[n][n + 1];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        return helper(nums, 0, -1);
    }
}
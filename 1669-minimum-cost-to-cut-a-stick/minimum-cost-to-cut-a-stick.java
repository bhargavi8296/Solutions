class Solution {

    int[][] dp;

    public int helper(int[] cuts, int i, int j) {

        // no cut possible
        if (j - i <= 1) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int res = Integer.MAX_VALUE;

        // try every cut between i and j
        for (int k = i + 1; k < j; k++) {

            int cost =
                    (cuts[j] - cuts[i]) +
                    helper(cuts, i, k) +
                    helper(cuts, k, j);

            res = Math.min(res, cost);
        }

        return dp[i][j] = res;
    }

    public int minCost(int n, int[] cuts) {

        int m = cuts.length;

        int[] arr = new int[m + 2];

        arr[0] = 0;
        arr[m + 1] = n;

        for (int i = 0; i < m; i++) {
            arr[i + 1] = cuts[i];
        }

        Arrays.sort(arr);

        dp = new int[m + 2][m + 2];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper(arr, 0, m + 1);
    }
}
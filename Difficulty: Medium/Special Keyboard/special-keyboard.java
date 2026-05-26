class Solution {
    public int optimalKeys(int n) {
        // code here
       int dp[] = new int[n + 1];

        for (int i = 1; i <= n; i++) {

            // Pressing only A
            dp[i] = i;

            // Try every breakpoint
            for (int j = 1; j <= i - 3; j++) {

                dp[i] = Math.max(
                    dp[i],
                    dp[j] * (i - j - 1)
                );
            }
        }

        return dp[n];
    }
}
// 1 2 3 4 5 6 7
// 1 2 3 2 4 6 7
//       4 5 6 9
//       1 2 3 4;
      
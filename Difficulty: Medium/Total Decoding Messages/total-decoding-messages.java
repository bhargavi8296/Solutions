// User function Template for Java

class Solution {

    public int countWays(String digits) {

        int n = digits.length();

        // invalid starting
        if(digits.charAt(0) == '0') {
            return 0;
        }

        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i <= n; i++) {

            char one = digits.charAt(i - 1);

            // single digit valid
            if(one != '0') {

                dp[i] += dp[i - 1];
            }

            // two digit number
            int two =
                Integer.parseInt(
                    digits.substring(i - 2, i)
                );

            if(two >= 10 && two <= 26) {

                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }
}
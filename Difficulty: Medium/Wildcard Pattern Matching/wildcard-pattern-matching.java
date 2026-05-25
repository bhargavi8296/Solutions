class Solution {

    int dp[][];

    public boolean helper(String s, String p,
                          int i, int j) {

        // both exhausted
        if(i < 0 && j < 0) {
            return true;
        }

        // pattern exhausted
        if(j < 0) {
            return false;
        }

        // string exhausted
        if(i < 0) {

            // remaining should all be '*'
            for(int k = 0; k <= j; k++) {

                if(p.charAt(k) != '*') {
                    return false;
                }
            }

            return true;
        }

        if(dp[i][j] != -1) {
            return dp[i][j] == 1;
        }

        boolean ans = false;

        // exact match or '?'
        if(s.charAt(i) == p.charAt(j)
           || p.charAt(j) == '?') {

            ans = helper(s, p,
                         i - 1, j - 1);
        }

        // '*'
        else if(p.charAt(j) == '*') {

            ans =
                helper(s, p, i, j - 1) ||  // empty
                helper(s, p, i - 1, j);   // consume
        }

        dp[i][j] = ans ? 1 : 0;

        return ans;
    }

    public boolean wildCard(String txt,
                            String pat) {

        int n = txt.length();
        int m = pat.length();

        dp = new int[n][m];

        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return helper(txt, pat,
                      n - 1, m - 1);
    }
}
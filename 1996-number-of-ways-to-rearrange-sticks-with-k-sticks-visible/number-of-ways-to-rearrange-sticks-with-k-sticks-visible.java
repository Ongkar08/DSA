class Solution {
    public int rearrangeSticks(int n, int k) {
        int MOD = 1_000_000_007;

        long[][] dp = new long[n + 1][k + 1];
        dp[1][1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= Math.min(i, k); j++) {
                dp[i][j] = (dp[i - 1][j - 1] + (i - 1) * dp[i - 1][j]) % MOD;
            }
        }

        return (int) dp[n][k];
    }
}
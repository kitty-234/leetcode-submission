// Last updated: 2/4/2026, 12:57:15 PM
class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int k = primes.length;
        int[] dp = new int[n];
        int[] idx = new int[k];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            long min = Long.MAX_VALUE;
            for (int j = 0; j < k; j++) {
                min = Math.min(min, (long) primes[j] * dp[idx[j]]);
            }
            dp[i] = (int) min;
            for (int j = 0; j < k; j++) {
                if ((long) primes[j] * dp[idx[j]] == min) {
                    idx[j]++;
                }
            }
        }
        return dp[n - 1];
    }
}
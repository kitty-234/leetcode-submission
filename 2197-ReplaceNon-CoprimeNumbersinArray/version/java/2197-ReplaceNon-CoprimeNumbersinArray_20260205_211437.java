// Last updated: 2/5/2026, 9:14:37 PM
1class Solution {
2    public int peopleAwareOfSecret(int n, int delay, int forget) {
3        int MOD=1_000_000_007;
4
5        long[] dp=new long[n + 1];
6        dp[1] = 1;
7
8        long share = 0;
9
10        for (int day = 2; day <= n; day++) {
11            if (day - delay >= 1) {
12                share = (share + dp[day - delay]) % MOD;
13            }
14
15            // people forget
16            if (day - forget >= 1) {
17                share = (share - dp[day - forget] + MOD) % MOD;
18            }
19
20            dp[day] = share;
21        }
22        long ans = 0;
23        for (int i = n - forget + 1; i <= n; i++) {
24            if (i >= 1) {
25                ans = (ans + dp[i]) % MOD;
26            }
27        }
28        return (int) ans;
29    }
30}
31
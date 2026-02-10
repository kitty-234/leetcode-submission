// Last updated: 2/10/2026, 10:01:18 PM
1import java.util.HashSet;
2
3class Solution {
4    public int longestBalanced(int[] nums) {
5        int n = nums.length;
6        int maxLen = 0;
7
8        for (int i = 0; i < n; i++) {
9            HashSet<Integer> evenSet = new HashSet<>();
10            HashSet<Integer> oddSet = new HashSet<>();
11
12            for (int j = i; j < n; j++) {
13                if (nums[j] % 2 == 0) {
14                    evenSet.add(nums[j]);
15                } else {
16                    oddSet.add(nums[j]);
17                }
18
19                if (evenSet.size() == oddSet.size()) {
20                    maxLen = Math.max(maxLen, j - i + 1);
21                }
22            }
23        }
24        return maxLen;
25    }
26}
27
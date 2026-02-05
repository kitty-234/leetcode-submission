// Last updated: 2/5/2026, 9:16:20 PM
1import java.util.*;
2class Solution {
3    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
4        List<Set<Integer>> lang = new ArrayList<>();
5        for (int i = 0; i < languages.length; i++) {
6            Set<Integer> set = new HashSet<>();
7            for (int l : languages[i]) {
8                set.add(l);
9            }
10            lang.add(set);
11        }
12        Set<Integer> needHelp = new HashSet<>();
13
14        for (int[] f : friendships) {
15            int u = f[0] - 1;
16            int v = f[1] - 1;
17            boolean canTalk = false;
18            for (int l : lang.get(u)) {
19                if (lang.get(v).contains(l)) {
20                    canTalk = true;
21                    break;
22                }
23            }
24            if (!canTalk) {
25                needHelp.add(u);
26                needHelp.add(v);
27            }
28        }
29        int ans = Integer.MAX_VALUE;
30        for (int l = 1; l <= n; l++) {
31            int count = 0;
32            for (int p : needHelp) {
33                if (!lang.get(p).contains(l)) {
34                    count++;
35                }
36            }
37            ans = Math.min(ans, count);
38        }
39        return ans == Integer.MAX_VALUE ? 0 : ans;
40    }
41}
42
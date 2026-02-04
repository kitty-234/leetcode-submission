// Last updated: 2/4/2026, 12:56:39 PM
import java.util.*;
class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int num = nums.get(i);
            if (num == 2) {
                ans[i] = -1;
                continue;
            }
            int r = 0;
            int temp = num;
            while ((temp & 1) == 1) {
                r++;
                temp >>= 1;  
            }
            int prefix_shifted = (num >> r) << r;
            int trailing = (r == 1) ? 0 : ((1 << (r - 1)) - 1);
            ans[i] = prefix_shifted | trailing;
        }
        return ans;
    }
}
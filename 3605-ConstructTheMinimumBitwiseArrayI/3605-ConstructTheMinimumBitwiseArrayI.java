// Last updated: 2/4/2026, 12:56:40 PM
import java.util.List;

class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int p = nums.get(i);
            ans[i] = -1;
            for (int a = 0; a < p; a++) {
                if ((a | (a + 1)) == p) {
                    ans[i] = a;
                    break;
                }
            }
        }
        return ans;
    }
}
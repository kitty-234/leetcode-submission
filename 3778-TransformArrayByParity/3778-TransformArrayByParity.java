// Last updated: 2/4/2026, 12:56:42 PM
import java.util.Arrays;

class Solution {
    public int[] transformArray(int[] nums) {
        // Step 1 & 2: Replace even with 0, odd with 1
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (nums[i] % 2 == 0) ? 0 : 1;
        }
        
        // Step 3: Sort the array
        Arrays.sort(nums);
        
        return nums;
    }
}
// Last updated: 2/4/2026, 12:57:41 PM
public class Solution {
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {4, 1, 2, 1, 2};
        System.out.println("Single Number: " + solution.singleNumber(nums));  // Output: 4
    }
}
// Last updated: 2/4/2026, 12:57:28 PM
class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] > nums[mid + 1]) {
                // Peak is on the left including mid
                high = mid;
            } else {
                // Peak is on the right
                low = mid + 1;
            }
        }

        return low; // or high (both point to a peak)
    }
}
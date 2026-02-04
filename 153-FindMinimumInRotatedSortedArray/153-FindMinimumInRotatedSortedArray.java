// Last updated: 2/4/2026, 12:57:31 PM
import java.util.*;

class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        // if array is not rotated
        if (nums[left] <= nums[right]) {
            return nums[left];
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // check mid + 1 safely
            if (mid < right && nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }

            // check mid - 1 safely
            if (mid > left && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }

            // decide which half to search
            if (nums[mid] >= nums[left]) {
                left = mid + 1; // min must be in right half
            } else {
                right = mid - 1; // min must be in left half
            }
        }

        return nums[0]; // fallback
    }
}


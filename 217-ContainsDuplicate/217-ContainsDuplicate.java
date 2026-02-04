// Last updated: 2/4/2026, 12:57:23 PM
import java.util.*;
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true; 
            }
        }
        return false;
    }
}
// Last updated: 2/4/2026, 12:56:38 PM
import java.util.*;
class Solution {
    public int minimumPairRemoval(int[] nums) {
        List<Integer> arr = new ArrayList<>();
        for (int num : nums) arr.add(num);
        int ops = 0;
        while (true) {
            boolean nonDec = true;
            for (int i = 1; i < arr.size(); i++) {
                if (arr.get(i - 1) > arr.get(i)) {
                    nonDec = false;
                    break;
                }
            }
            if (nonDec) return ops;
            int minSum = Integer.MAX_VALUE;
            int mergeIdx = -1;
            for (int i = 0; i + 1 < arr.size(); i++) {
                int curSum = arr.get(i) + arr.get(i + 1);
                if (curSum < minSum || (curSum == minSum && i < mergeIdx)) {
                    minSum = curSum;
                    mergeIdx = i;
                }
            }
            arr.set(mergeIdx, arr.get(mergeIdx) + arr.get(mergeIdx + 1));
            arr.remove(mergeIdx + 1);
            ops++;
        }
    }
}
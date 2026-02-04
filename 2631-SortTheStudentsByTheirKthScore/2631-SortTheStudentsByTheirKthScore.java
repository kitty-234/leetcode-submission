// Last updated: 2/4/2026, 12:56:46 PM
import java.util.*;
class Solution {
    public int[][] sortTheStudents(int[][] score, int k) {
        Arrays.sort(score, (a, b) -> b[k] - a[k]);
        return score;
    }
}

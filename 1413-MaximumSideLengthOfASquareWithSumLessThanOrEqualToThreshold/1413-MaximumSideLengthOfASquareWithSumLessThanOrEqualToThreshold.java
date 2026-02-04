// Last updated: 2/4/2026, 12:56:51 PM
class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length, n = mat[0].length;
        int[][] pre = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                pre[i][j] = mat[i - 1][j - 1]
                          + pre[i - 1][j]
                          + pre[i][j - 1]
                          - pre[i - 1][j - 1];
            }
        }
        int left = 1, right = Math.min(m, n);
        int ans = 0;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (existsSquare(pre, m, n, mid, threshold)) {
                ans = mid;
                left = mid + 1;   
            } else {
                right = mid - 1; 
            }
        }
        return ans;
    }
    private boolean existsSquare(int[][] pre, int m, int n, int k, int threshold) {
        for (int i = 0; i + k <= m; i++) {
            for (int j = 0; j + k <= n; j++) {
                int sum = pre[i + k][j + k]
                        - pre[i][j + k]
                        - pre[i + k][j]
                        + pre[i][j];
                if (sum <= threshold) return true;
            }
        }
        return false;
    }
}
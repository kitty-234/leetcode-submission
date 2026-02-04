// Last updated: 2/4/2026, 12:56:59 PM
public class Solution {
    public static double champagneTower(int poured, int query_row, int query_glass) {
        double[][] tower = new double[query_row + 2][query_row + 2];
        tower[0][0] = poured;

        for (int row = 0; row <= query_row; row++) {
            for (int col = 0; col <= row; col++) {
                double excess = (tower[row][col] - 1.0) / 2.0;
                if (excess > 0) {
                    tower[row + 1][col] += excess;
                    tower[row + 1][col + 1] += excess;
                }
            }
        }

        return Math.min(1, tower[query_row][query_glass]);
    }

    public static void main(String[] args) {
        // Test examples
        System.out.println(champagneTower(1, 1, 1)); // Output: 0.0
        System.out.println(champagneTower(2, 1, 1)); // Output: 0.5
        System.out.println(champagneTower(100000009, 33, 17)); // Example with larger input
    }
}
// Last updated: 2/4/2026, 12:56:57 PM
class Solution {
    public int[][] transpose(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int[][] arr=new int[n][m];
        for(int row=0;row<n;row++){
            for(int col=0;col<m;col++){
                arr[row][col]=mat[col][row];
            }
        }
        return arr;
    }
}
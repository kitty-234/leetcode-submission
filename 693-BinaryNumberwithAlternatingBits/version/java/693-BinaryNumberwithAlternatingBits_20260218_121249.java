// Last updated: 2/18/2026, 12:12:49 PM
1class Solution {
2    public boolean hasAlternatingBits(int n){
3         int x=n^(n>>1);
4        return (x&(x+1))==0;
5    }
6}
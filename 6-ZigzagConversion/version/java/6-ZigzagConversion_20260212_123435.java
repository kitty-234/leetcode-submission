// Last updated: 2/12/2026, 12:34:35 PM
1class Solution {
2    public int reverse(int x) {
3        int reversed = 0;
4        while (x != 0) {
5            int digit = x % 10;
6            x /= 10;
7            if (reversed > Integer.MAX_VALUE / 10 || 
8               (reversed == Integer.MAX_VALUE / 10 && digit > 7)) {
9                return 0;
10            }
11            if (reversed < Integer.MIN_VALUE / 10 || 
12               (reversed == Integer.MIN_VALUE / 10 && digit < -8)) {
13                return 0;
14            }
15            reversed = reversed * 10 + digit;
16        }
17        return reversed;
18    }
19}
20
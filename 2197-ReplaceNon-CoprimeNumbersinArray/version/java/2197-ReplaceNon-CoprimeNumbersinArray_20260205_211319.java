// Last updated: 2/5/2026, 9:13:19 PM
1import java.util.*;
2class Solution {
3    public List<Integer> replaceNonCoprimes(int[] nums) {
4        List<Integer>stack=new ArrayList<>();
5        for (int num:nums) {
6            while (!stack.isEmpty()) {
7                int top=stack.get(stack.size() - 1);
8                int g=gcd(top, num);
9
10                if (g == 1) break;
11
12                stack.remove(stack.size() - 1);
13                num = lcm(top, num);
14            }
15            stack.add(num);
16        }
17        return stack;
18    }
19
20    private int gcd(int a, int b) {
21        while (b != 0) {
22            int temp = b;
23            b = a % b;
24            a = temp;
25        }
26        return a;
27    }
28
29    private int lcm(int a, int b) {
30        return a / gcd(a, b) * b;
31    }
32}
33
// Last updated: 2/12/2026, 12:32:10 PM
1class Solution {
2    public String longestPalindrome(String s) {
3        if (s == null || s.length() < 1) return "";
4        
5        int start = 0, end = 0;
6        
7        for (int i = 0; i < s.length(); i++) {
8            int len1 = expandFromCenter(s, i, i);       
9            int len2 = expandFromCenter(s, i, i + 1);   
10            int len = Math.max(len1, len2);
11            
12            if (len > end - start) {
13                start = i - (len - 1) / 2;
14                end = i + len / 2;
15            }
16        }
17        
18        return s.substring(start, end + 1);
19    }
20    
21    private int expandFromCenter(String s, int left, int right) {
22        while (left >= 0 && right < s.length() 
23                && s.charAt(left) == s.charAt(right)) {
24            left--;
25            right++;
26        }
27        return right - left - 1;  
28    }
29}
30
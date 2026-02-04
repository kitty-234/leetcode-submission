// Last updated: 2/4/2026, 12:57:51 PM
public class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        int[] need = new int[128], window = new int[128];
        for (char c : t.toCharArray()) need[c]++;

        int left = 0, right = 0, valid = 0, start = 0, len = Integer.MAX_VALUE;
        while (right < s.length()) {
            char c = s.charAt(right++);
            if (need[c] > 0) {
                window[c]++;
                if (window[c] <= need[c]) valid++;
            }

            while (valid == t.length()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                char d = s.charAt(left++);
                if (need[d] > 0) {
                    if (window[d] <= need[d]) valid--;
                    window[d]--;
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
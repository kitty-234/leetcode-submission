// Last updated: 2/4/2026, 12:57:13 PM
class Solution {
    public String removeDuplicateLetters(String s) {
        int[] freq = new int[26];
        boolean[] used = new boolean[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        StringBuilder stack = new StringBuilder();

        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            freq[idx]--;

            if (used[idx]) continue;
            while (stack.length() > 0) {
                char last = stack.charAt(stack.length() - 1);
                if (last > c && freq[last - 'a'] > 0) {
                    used[last - 'a'] = false;
                    stack.deleteCharAt(stack.length() - 1);
                } else {
                    break;
                }
            }

            stack.append(c);
            used[idx] = true;
        }

        return stack.toString();
    }
}
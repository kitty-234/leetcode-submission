// Last updated: 2/5/2026, 9:18:33 PM
1import java.util.*;
2class Solution {
3    public String sortVowels(String s) {
4        Set<Character> vowels = new HashSet<>(
5            Arrays.asList('a','e','i','o','u','A','E','I','O','U')
6        );
7        List<Character> list = new ArrayList<>();
8        for (char c : s.toCharArray()) {
9            if (vowels.contains(c)) {
10                list.add(c);
11            }
12        }
13
14        Collections.sort(list);
15
16        StringBuilder sb = new StringBuilder();
17        int idx = 0;
18        for (char c : s.toCharArray()) {
19            if (vowels.contains(c)) {
20                sb.append(list.get(idx++));
21            } else {
22                sb.append(c);
23            }
24        }
25        return sb.toString();
26    }
27}
28
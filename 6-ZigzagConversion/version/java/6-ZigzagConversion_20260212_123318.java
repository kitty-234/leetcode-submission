// Last updated: 2/12/2026, 12:33:18 PM
1class Solution {
2    public String convert(String s, int numRows) {
3        if (numRows == 1 || s.length() <= numRows) {
4            return s;
5        }
6        
7        StringBuilder[] rows = new StringBuilder[numRows];
8        for (int i = 0; i < numRows; i++) {
9            rows[i] = new StringBuilder();
10        }
11        
12        int currentRow = 0;
13        boolean goingDown = false;
14        
15        for (char c : s.toCharArray()) {
16            rows[currentRow].append(c);
17            
18            if (currentRow == 0 || currentRow == numRows - 1) {
19                goingDown = !goingDown;
20            }
21            
22            currentRow += goingDown ? 1 : -1;
23        }
24        
25        StringBuilder result = new StringBuilder();
26        for (StringBuilder row : rows) {
27            result.append(row);
28        }
29        
30        return result.toString();
31    }
32}
33
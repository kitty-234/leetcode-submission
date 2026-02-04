// Last updated: 2/4/2026, 12:57:06 PM
class Solution {
    public String toHex(int num) {
        if (num == 0) return "0";

        String hex = "0123456789abcdef";
        StringBuilder sb = new StringBuilder();

        while (num != 0) {
            int digit = num & 15;      
            sb.append(hex.charAt(digit));
            num >>>= 4;                  
        }

        return sb.reverse().toString();
    }
}
// Last updated: 2/4/2026, 12:57:44 PM
// class Solution {
//     // Method to calculate the maximum profit
//     public int maxProfit(int[] prices) {
//         int minPrice = Integer.MAX_VALUE;
//         int maxProfit = 0;

//         // Iterate through the prices array
//         for (int i = 0; i < prices.length; i++) {
//             if (prices[i] < minPrice) {
//                 minPrice = prices[i];
//             } else if (prices[i] - minPrice > maxProfit) {
//                 maxProfit = prices[i] - minPrice;
//             }
//         }

//         return maxProfit;
//     }

//     public static void main(String[] args) {
//         Solution solution = new Solution();
        
//         // Example to test maxProfit method
//         int[] prices = {7, 1, 5, 3, 6, 4};
//         int result = solution.maxProfit(prices);
//         System.out.println("Maximum Profit: " + result);
//     }
// }
class Solution {
    // Method to calculate the maximum profit
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        // Iterate through the prices array
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example to test maxProfit method
        int[] prices = {7, 1, 5, 3, 6, 4};
        int result = solution.maxProfit(prices);
        System.out.println("Maximum Profit: " + result);
    }
}
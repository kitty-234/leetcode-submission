// Last updated: 2/4/2026, 12:56:56 PM
import java.util.*;

public class Solution {

    public static int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();
        int result = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            
            long hours = 0; 
            for (int pile : piles) {
                hours += (pile + mid - 1) / mid; 
            }

            if (hours <= h) {
                result = mid;
                right = mid - 1; 
            } else {
                left = mid + 1; 
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] piles1 = {3, 6, 7, 11};
        System.out.println(minEatingSpeed(piles1, 8));

        int[] piles2 = {30, 11, 23, 4, 20};
        System.out.println(minEatingSpeed(piles2, 5)); 

        int[] piles3 = {30, 11, 23, 4, 20};
        System.out.println(minEatingSpeed(piles3, 6));
    }
}
// Last updated: 2/4/2026, 12:58:03 PM
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int ans[] = {-1,-1};
        int n = nums.length;
        for(int i =0; i<n; i++){
            if(nums[i]==target){
                ans[0] =i;
                break;
            }
        }


        for(int i = n-1; i>=0;i--){
            if(nums[i] == target){
                ans[1] = i;
                break;
            }
        }
    return ans;
    }
}
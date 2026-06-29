class Solution {
    public int maxProduct(int[] nums) {
        int[][] dp = new int[nums.length][2];
        int ans = nums[0];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        for(int i = 1; i < nums.length; i++){
            int n = nums[i];
            int n1 = n*dp[i-1][0];
            int n2 = n*dp[i-1][1];
            // max
            dp[i][0] = Math.max(n,Math.max(n1,n2));
            // min
            dp[i][1] = Math.min(n,Math.min(n1,n2));
            ans = Math.max(ans,dp[i][0]);
        }
        return ans; 
    }
}



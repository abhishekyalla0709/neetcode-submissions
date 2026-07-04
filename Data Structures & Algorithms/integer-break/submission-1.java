class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int remaining = 2; remaining <= n; remaining++){
            for(int left = 1; left < remaining; left++){
                int right = remaining - left;
                int leftValue = Math.max(left,dp[left]);
                int rightValue = Math.max(right,dp[right]);
                dp[remaining] = Math.max(dp[remaining],leftValue*rightValue);
            }
        }
        return dp[n];
        // Arrays.fill(dp,-1);
        // return solve(n,dp);
    }

    private int solve(int remaining, int[] dp){
        if(remaining == 1){
            return 1;
        }
        if(dp[remaining]!=-1){
            return dp[remaining];
        }
        int ans = 0;
        for(int i = 1; i < remaining; i++){
            int left = Math.max(i, solve(i,dp));
            int right = Math.max(remaining-i,solve(remaining-i,dp));
            ans = Math.max(ans, left*right);
        }
        dp[remaining] = ans;
        return ans;
    }
}
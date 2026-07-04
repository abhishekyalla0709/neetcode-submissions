class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n,dp);
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
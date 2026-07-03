class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        int x = 1;
        while(x*x<=n){
            dp[x*x] = 1;
            x+=1;
        }
        for(int i = 1; i <= n; i++){
            if(dp[i]==1){
                continue;
            }
            dp[i] = Integer.MAX_VALUE;
            int l = 0;
            int r = i;
            while(l<=r){
                dp[i] = Math.min(dp[i],dp[l++]+dp[r--]);
            }
        }
        return dp[n];
    }
}
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0] = 0;
        for(int i = 1; i <= amount; i++){
            for(int j = 0; j < coins.length; j++){
                if(i-coins[j]>=0){
                    dp[i] = Math.min(dp[i],1+dp[i-coins[j]]);
                }
            }
        }
        if(dp[amount]>amount){
            return -1;
        }
        return dp[amount];
        // int ans = reqCoins(coins, amount, amount, dp);
        // if(ans>amount){
        //     return -1;
        // }
        // return ans;
    }

    private int reqCoins(int[] coins, int amount, int remaining, int[] dp){
        if(remaining==0){
            return 0;
        }
        if(remaining < 0){
            return amount+1;
        }
        if(dp[remaining]!=0){
            return dp[remaining];
        }
        int ans = 1+amount;
        for(int i = 0; i < coins.length; i++){
            ans = Math.min(ans, 1 + reqCoins(coins,amount,remaining-coins[i],dp));
        }
        dp[remaining] = ans;
        return ans;
    }
}

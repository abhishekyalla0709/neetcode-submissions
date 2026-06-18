class Solution {
    public int maxProfit(int[] prices) {

        int buy = prices[0];
        int ans = 0;

        int l = 0;
        while(l<prices.length){
            if(prices[l]>buy){
                ans+=prices[l]-buy;
                buy=prices[l];
            }
            else{
                buy = prices[l];
            }
            l++;
        }
        return ans;
    }
}
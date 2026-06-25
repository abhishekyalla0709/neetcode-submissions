class Solution {
    public int climbStairs(int n) {
        if(n==1 || n==2){
            return n;
        }
        int prev2 = 1;
        int prev1 = 2;
        for(int i = 3; i <= n; i++){
            int temp = prev1;
            prev1 = prev1+prev2;
            prev2 = temp;;
        }
        return prev1;
    }
}

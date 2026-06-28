class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp,-1);
        return decode(s,0,dp);
        
    }

    private int decode(String s, int index, int[] dp){
        if(index< s.length() && s.charAt(index)=='0'){
            return 0;
        }
        if(index==s.length()){
            return 1;
        }
        if(dp[index]!=-1){
            return dp[index];
        }
        int ans = decode(s,index+1,dp);
        if(index<s.length()-1){
            int num = 10 * (s.charAt(index)-'0') + s.charAt(index+1)-'0';
            if(num>=10 && num<=26){
                ans+=decode(s,index+2,dp);
            }
        }
        dp[index] = ans;
        return ans;
    }
}

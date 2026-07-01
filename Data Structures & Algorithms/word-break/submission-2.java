// Memoization Solution

// class Solution {
//     public boolean wordBreak(String s, List<String> wordDict) {
//         Set<String> set = new HashSet<>(wordDict);
//         Boolean[] dp = new Boolean[s.length()];
//         return word(s,0,set,dp);
//     }

//     private boolean word(String s, int start, Set<String> set, Boolean[] dp){
//         if(start==s.length()){
//             return true;
//         }
//         if(dp[start]!=null){
//             return dp[start];
//         }
//         for(int end = start; end < s.length(); end++){
//             if(set.contains(s.substring(start,end+1))){
//                 if(word(s,end+1,set,dp)){
//                     dp[start] = true;
//                     return true;
//                 }
//             }
//         }
//         dp[start] = false;
//         return false;
//     }
// }


// Tabulation Solution
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        Set<String> set = new HashSet<>(wordDict);

        boolean[] dp = new boolean[s.length() + 1];

        dp[s.length()] = true;

        for (int start = s.length() - 1; start >= 0; start--) {

            for (int end = start; end < s.length(); end++) {

                if (set.contains(s.substring(start, end + 1)) && dp[end + 1]) {

                    dp[start] = true;
                    break;
                }
            }
        }

        return dp[0];
    }
}


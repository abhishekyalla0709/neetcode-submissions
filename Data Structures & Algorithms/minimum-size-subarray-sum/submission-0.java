class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        int l = 0;
        int r = 0;
        while(r<nums.length){
            sum+=nums[r++];
            if(sum>=target){
                ans=Math.min(ans,r-l);
                while(sum>=target){
                    sum-=nums[l++];
                    if(sum>=target){
                        ans=Math.min(ans,r-l);
                    }
                }
            }
        }
        if(ans==Integer.MAX_VALUE){
            return 0;
        }
        return ans;
    }
}
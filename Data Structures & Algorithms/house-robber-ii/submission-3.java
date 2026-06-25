class Solution {
    public int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }
        int house_1_included = robLinear(nums,0,nums.length-1);
        int house_1_excluded = robLinear(nums,1,nums.length);
        return Math.max(house_1_included, house_1_excluded);
    }

    private int robLinear(int[] nums, int start, int end){
        int two_prev = nums[start];
        int prev = Math.max(nums[start+1],nums[start]);
        for(int i = start+2; i < end; i++){
            int current = Math.max(nums[i]+two_prev,prev);
            two_prev = prev;
            prev = current;
        }
        return prev;
    }
}

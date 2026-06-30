class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        return partition(nums,0,sum/2);
    }

    private boolean partition(int[] nums, int index, int target) {
        if(target==0){
            return true;
        }
        if(index==nums.length){
            return false;
        }
        return partition(nums,index+1,target-nums[index]) || partition(nums,index+1,target);
    }
}

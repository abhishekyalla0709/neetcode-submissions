class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        boolean[] exists = new boolean[nums.length];
        int total_sum = 0;
        for(int i = 0; i < nums.length; i++){
            exists[i] = true;
            total_sum+=nums[i];
        }
        int target;
        if(total_sum%k!=0){
            return false;
        }
        target = total_sum/k;
        return kSubsets(nums,exists,k,0,target);
        
    }

    private boolean kSubsets(int[] nums, boolean[] exists, int k, int currentSum, int target){
        if(k==1){
            return true;
        }
        if(currentSum==target){
            return kSubsets(nums,exists,k-1,0,target);
        }
        for(int i = nums.length-1; i >= 0; i--){
            if(!exists[i]){
                continue;
            }
            if(currentSum+nums[i]>target){
                continue;
            }
            exists[i]=false;
            if(kSubsets(nums,exists,k,currentSum+nums[i],target)){
                return true;
            }
            exists[i]=true;
        }
        return false;
    }
}
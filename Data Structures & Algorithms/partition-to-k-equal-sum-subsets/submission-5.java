class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0;
        int r = nums.length-1;
        while(l<r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
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
        if(nums[0]>total_sum){
            return false;
        }
        return kSubsets(nums,exists,k,0,target,0);
        
    }

    private boolean kSubsets(int[] nums, boolean[] exists, int k, int currentSum, int target,int index){
        if(k==1){
            return true;
        }
        if(currentSum==target){
            return kSubsets(nums,exists,k-1,0,target,0);
        }
        for(int i = index; i < nums.length; i++){
            if(!exists[i]){
                continue;
            }
            if(currentSum+nums[i]>target){
                continue;
            }
            exists[i]=false;
            if(kSubsets(nums,exists,k,currentSum+nums[i],target,i+1)){
                return true;
            }
            exists[i]=true;
        }
        return false;
    }
}
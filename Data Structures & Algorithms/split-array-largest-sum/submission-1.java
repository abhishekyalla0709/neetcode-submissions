class Solution {
    public int splitArray(int[] nums, int k) {
        int min = nums[0];
        int total = 0;
        for(int i = 0; i < nums.length; i++){
            total+=nums[i];
            min = Math.max(min,nums[i]);
        }
        // so for every mid value I need to check whether I can split into k subsets or not
        int ans = -1;
        int l = min;
        int r = total;
        while(l<=r){
            int mid = l + (r-l)/2;
            int count = 1;
            int sum = 0;
            for(int i = 0; i < nums.length; i++){
                if(count>k){
                    break;
                }
                sum+=nums[i];
                if(sum>mid){
                    count++;
                    if(sum==mid){
                        sum=0;
                    }
                    else{
                        sum=nums[i];
                    }
                }
            }
            if(count>k){
                l=mid+1;
            }
            else{
                r=mid-1;
                ans=mid;
            }
        }
        return ans;
    }
}
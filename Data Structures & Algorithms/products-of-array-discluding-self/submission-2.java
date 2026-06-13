class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        int temp = 1;
        for(int i = 0; i < nums.length; i++){
            if(i>0){
                temp*=nums[i-1];
            }
            ans[i] = temp;
        }
        
        temp = 1;
        for(int i = nums.length-1; i>=0; i--){
            if(i<nums.length-1){
                temp*=nums[i+1];
            }
            ans[i]=ans[i]*temp;
        }
        return ans;
    }
}  

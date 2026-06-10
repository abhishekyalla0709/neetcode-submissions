class Solution {
    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        int l = 0;
        int r = nums.length-1;
        // reverse the entire array
        while(l<r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
        // now do 2 reversals 
        // 1st till k
        l = 0;
        r = k-1;
        while(l<r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
        // 2nd k to nums.length-1
        l = k;
        r = nums.length-1;
        while(l<r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }
}
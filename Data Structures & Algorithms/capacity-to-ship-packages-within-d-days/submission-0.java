class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l = Integer.MIN_VALUE;
        int r = 0;
        for(int i = 0; i < weights.length; i++){
            l=Math.max(l,weights[i]);
            r+=weights[i];
        }
        int ans = 0;
        while(l<=r){
            int mid = l + (r-l)/2;
            int time = 1;
            int p = 0;
            int temp = 0;
            while(p<weights.length){
                temp+= weights[p];
                if(temp>mid){
                    time++;
                    temp=weights[p];
                }
                p++;
                if(time>days){
                    break;
                }
            }
            if(time<=days){
                ans = mid;
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return ans;
    }
}
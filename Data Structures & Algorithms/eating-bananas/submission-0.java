class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int l = 1;
        int r = piles[piles.length-1];
        int ans = 0;
        while(l<=r){
            int mid = l + (r-l)/2;
            int time = 0;
            for(int i = 0;i < piles.length; i++){
                if(piles[i]%mid == 0){
                    time+= piles[i]/mid;
                }
                else{
                    time+= piles[i]/mid + 1;
                }
                if(time>h){
                    break;
                }
            }
            if(time>h){
                l=mid+1;
            }
            else{
                ans = mid;
                r=mid-1;
            }
        }
        return ans;
    }
}

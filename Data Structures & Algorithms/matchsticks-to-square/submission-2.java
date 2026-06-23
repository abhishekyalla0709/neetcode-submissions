class Solution {
    public boolean makesquare(int[] matchsticks) {
        Arrays.sort(matchsticks);
        int l = 0;
        int r = matchsticks.length-1;
        while(l<r){
            int temp = matchsticks[l];
            matchsticks[l] = matchsticks[r];
            matchsticks[r] = temp;
            l++;
            r--;
        }
        boolean[] used = new boolean[matchsticks.length];
        int target = 0;
        for(int i = 0; i < matchsticks.length; i++){
            target+=matchsticks[i];
        }
        if(matchsticks[0]>target/4){
            return false;
        }
        if(target%4!=0){
            return false;
        }
        target=target/4;
        return isPossible(matchsticks,used,0,target,4,0);
    }

    private boolean isPossible(int[] matchsticks, boolean[] used, int currentside, int target, int k, int index){
        if(k==1){
            return true;
        }
        if(currentside == target){
            return isPossible(matchsticks, used, 0, target, k-1, 0);
        }
        for(int i = index; i < matchsticks.length; i++){
            if(used[i]){
                continue;
            }
            if(currentside+matchsticks[i]>target){
                continue;
            }
            used[i]=true;
            if(isPossible(matchsticks,used,currentside+matchsticks[i],target,k, i+1)){
                return true;
            }
            used[i]=false;
        }
        return false;
    }
}
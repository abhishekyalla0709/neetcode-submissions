class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        dfs(nums, 0, target, list, ans);
        return ans;
    }

    private void dfs(int[] nums, int index, int target, List<Integer> list, List<List<Integer>> ans){
        if(target==0){
            ans.add(new ArrayList<>(list));
            return;   
        }
        if(target<0 || index==nums.length){
            return;
        }
        for(int i = index; i < nums.length; i++){
            list.add(nums[i]);
            dfs(nums,i,target-nums[i],list,ans);
            list.remove(list.size()-1);
        }
        return;
    }
}

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(nums,0,list,ans);
        return ans;
    }

    private void dfs(int[] nums, int i, List<Integer> list, List<List<Integer>> ans){
        if(i==nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[i]);
        dfs(nums,i+1,list,ans);

        list.remove(list.size()-1);
        dfs(nums,i+1,list,ans);
    }
}

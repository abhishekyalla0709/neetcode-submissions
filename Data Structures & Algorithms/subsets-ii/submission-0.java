class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        dfs(nums, 0, list, ans);
        return ans;
    }

    private void dfs(int[] arr, int index, List<Integer> list, List<List<Integer>> ans){
        if(index<=arr.length){
            ans.add(new ArrayList<>(list));
        }
        if(index>arr.length){
            return;
        }
        for(int i = index; i < arr.length; i++){
            if(i>index && arr[i]==arr[i-1]){
                continue;
            }
            list.add(arr[i]);
            dfs(arr,i+1,list,ans);
            list.remove(list.size()-1);
        }
        return;
    }
}

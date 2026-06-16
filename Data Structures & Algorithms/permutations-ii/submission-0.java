class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        dfs(nums, visited, list, ans);
        return ans;
    }

    private void dfs(int[] arr, boolean[] visited, List<Integer> list, List<List<Integer>> ans){
        if(list.size() == arr.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0; i < arr.length; i++){
            if(visited[i]){
                continue;
            }
            if(i>0 && arr[i]==arr[i-1] && !visited[i-1]){
                continue;
            }
            list.add(arr[i]);
            visited[i] = true;
            dfs(arr,visited,list,ans);
            visited[i] = false;
            list.remove(list.size()-1);
        }
        return;
    }
}
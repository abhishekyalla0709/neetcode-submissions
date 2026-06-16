class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        dfs(nums, visited, list, ans);
        return ans;
    }

    private void dfs(int[] arr, boolean[] visited, List<Integer> list, List<List<Integer>> ans){
        if(list.size()==arr.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0; i < arr.length; i++){
            if(!visited[i]){
                list.add(arr[i]);
                visited[i]=true;
            }
            else{
                continue;
            }
            dfs(arr,visited,list,ans);
            visited[i]=false;
            list.remove(list.size()-1);
        }
        return;
    }
}

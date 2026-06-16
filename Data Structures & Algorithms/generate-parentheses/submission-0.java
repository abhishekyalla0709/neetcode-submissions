class Solution {
    public List<String> generateParenthesis(int n) {
        boolean[] visited = new boolean[2*n];
        char[] arr = new char[2*n];
        for(int i = 0; i < n; i++){
            arr[i] = '(';
        }
        for(int i = n; i < 2*n; i++){
            arr[i] = ')';
        }
        List<Character> list = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        dfs(arr,visited,list,ans);
        return ans;
    }

    private void dfs(char[] arr, boolean[] visited, List<Character> list, List<String> ans){
        if(list.size()==arr.length){
            if(isValid(list)){
                StringBuilder sb = new StringBuilder();
                for(int i = 0; i < list.size(); i++){
                    sb.append(list.get(i));
                }
                ans.add(sb.toString());
            }
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
            visited[i]=true;
            dfs(arr,visited,list,ans);
            visited[i]=false;
            list.remove(list.size()-1);
        }
        return;
    }

    private boolean isValid(List<Character> list){
        Deque<Character> stack = new ArrayDeque<>();
        int p = 0;
        while(p<list.size()){
            if(stack.isEmpty()){
                stack.push(list.get(p));
            }
            else{
                char ch = list.get(p);
                if(stack.peek()=='(' && ch == ')'){
                    stack.pop();
                }
                else{
                    stack.push(ch);
                }
            }
            p++;
        }
        return stack.isEmpty();
    }
}

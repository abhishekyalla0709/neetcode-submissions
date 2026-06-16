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
        StringBuilder sb = new StringBuilder();
        List<String> ans = new ArrayList<>();
        dfs(arr,visited,sb,ans);
        return ans;
    }

    private void dfs(char[] arr, boolean[] visited, StringBuilder sb, List<String> ans){
        if(sb.length()==arr.length){
            if(isValid(sb)){
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
            sb.append(arr[i]);
            visited[i]=true;
            dfs(arr,visited,sb,ans);
            visited[i]=false;
            sb.deleteCharAt(sb.length()-1);
        }
        return;
    }

    private boolean isValid(StringBuilder sb){
        Deque<Character> stack = new ArrayDeque<>();
        int p = 0;
        while(p<sb.length()){
            if(stack.isEmpty()){
                stack.push(sb.charAt(p));
            }
            else{
                char ch = sb.charAt(p);
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

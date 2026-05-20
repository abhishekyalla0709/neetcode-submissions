class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Stack<int[]> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty()) {
                int[] arr = stack.peek();
                if (arr[0] > temperatures[i]) {
                    ans[i] = arr[1] - i;
                    break;
                } else {
                    stack.pop();
                }
            }
            if (stack.isEmpty()) {
                ans[i] = 0;
            }
            int[] arr = new int[2];
            arr[0] = temperatures[i];
            arr[1] = i;
            stack.push(arr);
        }
        return ans;
    }
}

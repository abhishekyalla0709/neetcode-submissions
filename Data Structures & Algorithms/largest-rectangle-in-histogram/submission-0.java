class Solution {
    public int largestRectangleArea(int[] heights) {
        int ans = 0;
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            int index = i;
            while (!stack.isEmpty() && heights[i] < stack.peek()[1]) {
                int[] arr = stack.pop();
                ans = Math.max(ans, arr[1] * (i - arr[0]));
                index = arr[0];
            }
            int[] arr = new int[2];
            arr[0] = index;
            arr[1] = heights[i];
            stack.push(arr);
        }
        
        while(!stack.isEmpty()){
            int[] arr = stack.pop();
            ans = Math.max(ans,arr[1]*(heights.length-arr[0]));
        }
        return ans;
    }
}
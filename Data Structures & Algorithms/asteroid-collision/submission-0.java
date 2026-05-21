class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            boolean flag = true;
            int n = asteroids[i];
            while (!stack.isEmpty() && stack.peek() > 0 && n < 0) {
                int x = stack.peek();
                if (Math.abs(n) > x) {
                    stack.pop();
                } else if (Math.abs(n) == x) {
                    stack.pop();
                    flag = false;
                    break;
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag == true) {
                stack.push(n);
            }
        }
        int[] ans = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }
        return ans;
    }
}
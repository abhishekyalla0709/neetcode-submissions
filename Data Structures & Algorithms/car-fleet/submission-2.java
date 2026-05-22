class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = position[i];
            arr[i][1] = speed[i];
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        int ans = 0;
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            stack.push(arr[i]);
        }
        while (!stack.isEmpty()) {
            int[] arr1 = stack.pop();
            double p = arr1[0];
            double s = arr1[1];
            double time = (target-p)/s;
            ans++;
            while (!stack.isEmpty()) {
                int[] arr2 = stack.peek();
                double p1 = arr2[0];
                double s1 = arr2[1];
                double t = (target-p1)/s1;
                //System.out.println("time -> " + time + " t -> " + t);
                if (t <= time) {
                    stack.pop();
                } else {
                    break;
                }
            }
        }
        return ans;
    }
}

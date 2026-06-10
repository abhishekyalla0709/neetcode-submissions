class Solution {
    public int[] getOrder(int[][] tasks) {
        int[][] arr = new int[tasks.length][3];
        for (int i = 0; i < tasks.length; i++) {
            arr[i][0] = tasks[i][0];
            arr[i][1] = tasks[i][1];
            arr[i][2] = i;
        }
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> {
            if (a[1] == b[1]) {
                return Integer.compare(a[2], b[2]);
            }
            return Integer.compare(a[1], b[1]);
        });
        int[] ans = new int[tasks.length];
        int x = 0;
        int y = 0;
        long time = 0;
        while (x < tasks.length) {
            if (minHeap.isEmpty()) {
                time = arr[y][0];
            }
            if (!minHeap.isEmpty()) {
                int[] arr1 = minHeap.poll();
                ans[x++] = arr1[2];
                time += arr1[1];
            }
            while (y < tasks.length && time >= arr[y][0]) {
                minHeap.offer(arr[y]);
                y++;
            }
        }
        return ans;
    }
}
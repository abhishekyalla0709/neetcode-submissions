class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k+1];
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        int l = 0;
        int r = 0;
        while (r < k) {
            int[] arr = new int[2];
            arr[0] = nums[r];
            arr[1] = r;
            maxHeap.offer(arr);
            r++;
        }
        ans[l++] = maxHeap.peek()[0];
        while (r < nums.length) {
            int[] arr = new int[2];
            arr[0] = nums[r];
            arr[1] = r;
            r++;
            maxHeap.offer(arr);
            while (!maxHeap.isEmpty() && maxHeap.peek()[1] < (r - k)) {
                maxHeap.poll();
            }

            ans[l++] = maxHeap.peek()[0];
        }
        return ans;
    }
}

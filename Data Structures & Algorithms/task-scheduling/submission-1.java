class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)-> b-a);
        Queue<int[]> queue = new LinkedList<>();
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < tasks.length; i++){
            map.put(tasks[i],map.getOrDefault(tasks[i],0)+1);
        }
        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            maxHeap.offer(entry.getValue());
        }
        int time = 0;
        while(true){
            if(queue.size()!=0){
                int[] arr = queue.peek();
                if(arr[1]<=time){
                    queue.poll();
                    maxHeap.offer(arr[0]);
                }
            }
            if(maxHeap.size()!=0){
                int[] arr = new int[2];
                if(maxHeap.peek()!=1){
                arr[0] = maxHeap.poll()-1;
                arr[1] = time+n+1;
                queue.offer(arr);
                }
                else{
                    maxHeap.poll();
                }
            }
            time++;
            if(maxHeap.size()==0 && queue.size()==0){
                break;
            }
        }
        return time;
    }
}

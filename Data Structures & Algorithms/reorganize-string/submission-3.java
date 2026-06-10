class Solution {
    public String reorganizeString(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int max = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
            max=Math.max(max,map.get(ch));
        }
        if(max>(s.length()+1)/2){
            return "";
        }
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b[0],a[0]));
        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            int[] arr = new int[2];
            arr[0] = entry.getValue();
            arr[1] = entry.getKey();
            maxHeap.offer(arr);
        }
        Queue<int[]> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        while(!maxHeap.isEmpty()){
            int[] arr = maxHeap.poll();
            char ch = (char) arr[1];
            sb.append(ch);
            arr[0]=arr[0]-1;
            if(!queue.isEmpty()){
                maxHeap.offer(queue.poll());
            }
            if(arr[0]>0){
                queue.offer(arr);
            }
        }
        if(!queue.isEmpty()){
        sb.append((char) queue.poll()[1]);
        }
        return sb.toString();
    }
}
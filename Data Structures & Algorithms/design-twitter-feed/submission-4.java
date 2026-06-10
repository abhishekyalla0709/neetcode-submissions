class Twitter {
    private int time;
    private Map<Integer,Set<Integer>> map;
    private Map<Integer,List<int[]>> tweets;

    public Twitter() {
        this.time = 1;
        this.map = new HashMap<>();
        this.tweets = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if(tweets.containsKey(userId)){
            List<int[]> list = tweets.get(userId);
            int[] arr = new int[2];
            arr[0] = time++;
            arr[1] = tweetId;
            list.add(arr);
            tweets.put(userId,list);
        }
        else{
            List<int[]> list = new ArrayList<>();
            int[] arr = new int[2];
            arr[0] = time++;
            arr[1] = tweetId;
            list.add(arr);
            tweets.put(userId,list);
        }
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a1,a2) -> a1[0]-a2[0]);
        Set<Integer> ans = new LinkedHashSet<>();
        //1st add all the user tweets
        List<int[]> ownList = tweets.get(userId);
        if(ownList!=null){
        for(int i = 0; i < ownList.size(); i++){
            minHeap.offer(ownList.get(i));
            if(minHeap.size()>10){
                minHeap.poll();
            }
        }
        }
        // get follower List
        Set<Integer> followList = map.get(userId);
        if(followList!=null){
        for(Integer id : followList){
            List<int[]> list = tweets.get(id);
            for(int j = list.size()-1; j >=0; j--){
                minHeap.offer(list.get(j));
                if(minHeap.size()>10){
                    minHeap.poll();
                }
            } 
        }
        }
        
        int x = 0;
        while(!minHeap.isEmpty() && x<=9){
            ans.add(minHeap.poll()[1]);
            x++;
        }
        List<Integer> list = new ArrayList<>(ans);
        Collections.reverse(list);
        return list;
    }
    
    public void follow(int followerId, int followeeId) {
        if(map.containsKey(followerId)){
            Set<Integer> set = map.get(followerId);
            set.add(followeeId);
            map.put(followerId,set);
        }
        else{
            Set<Integer> set = new HashSet<>();
            set.add(followeeId);
            map.put(followerId,set);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(map.containsKey(followerId)){
            Set<Integer> set = new HashSet<>();
            set.remove(followeeId);
            map.put(followerId,set);
        }
    }
}

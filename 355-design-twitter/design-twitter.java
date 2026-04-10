class post{
    int num;
    int time;
    post next;
    post(int num,int time)
    {
        this.num=num;
        this.time=time;
    }
}
class Twitter {
    Map<Integer,Set<Integer>>map;
    Map<Integer,post>map1;
    int counter=0;
    public Twitter() {
        map=new HashMap<>();
        map1=new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        map.putIfAbsent(userId,new HashSet<>());
        map.get(userId).add(userId);
        post t=new post(tweetId,counter);++counter;
        map1.putIfAbsent(userId, null);
        t.next=map1.get(userId);
        map1.put(userId,t);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer>result=new ArrayList<>();
        Queue<post>q=new PriorityQueue<>((a,b)->a.time-b.time);
        map.putIfAbsent(userId,new HashSet<>());
        map.get(userId).add(userId);
        for(int val:map.get(userId))
        {
            post temp=map1.get(val);
            while(temp!=null)
            {
                if(q.size()<10){q.add(temp);}
                else{
                    if(q.peek().time<temp.time)
                    {
                        q.poll();
                        q.add(temp);
                    }
                    else{
                        break;
                    }
                }
                temp=temp.next;
            }
        }
        while(!q.isEmpty())
        {
            result.add(q.poll().num);
        }
        Collections.reverse(result);
        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        
        map.putIfAbsent(followerId, new HashSet<>());
        map.get(followerId).add(followerId);
        map.putIfAbsent(followeeId, new HashSet<>());
        map.get(followeeId).add(followeeId);
        map.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(map.containsKey(followerId))
        {map.get(followerId).remove(followeeId);}
        
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
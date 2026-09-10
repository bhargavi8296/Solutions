class pair{
    int num; int counter;
    pair(int num, int counter)
    {
        this.num=num;
        this.counter=counter;
    }
}
class Twitter {

    int counter;
    Map<Integer,Queue<pair>>feed;
    Map<Integer,Set<Integer>>follower;
    public Twitter() {
        counter=0;
        feed=new HashMap<>();
        follower=new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!follower.containsKey(userId)){follower.put(userId,new HashSet<>());follower.get(userId).add(userId);}
        if(!feed.containsKey(userId)){feed.put(userId,new LinkedList<>());}
        feed.get(userId).add(new pair(tweetId,counter++));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer>result=new ArrayList<>();
        Queue<pair>pq=new PriorityQueue<>((a,b)->b.counter-a.counter);
        if(follower.containsKey(userId)&&!follower.get(userId).isEmpty()){
        for(int val:follower.get(userId)){if(feed.containsKey(val)){pq.addAll(feed.get(val));}}
        int size=10;
        while(size>0&&!pq.isEmpty())
        {
            int r=pq.poll().num;
            result.add(r);
            --size;
        }}
        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!follower.containsKey(followerId))
        {
            follower.put(followerId,new HashSet<>());
            follower.get(followerId).add(followerId);
        }
        follower.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) {
        return;
    }
        if(follower.containsKey(followerId)&&follower.get(followerId).contains(followeeId))
        {follower.get(followerId).remove(Integer.valueOf(followeeId));}
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
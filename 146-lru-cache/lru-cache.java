class LRUCache {
    Queue<Integer>q;
    int cap;
    Map<Integer,Integer>map;
    public LRUCache(int capacity) {
        q=new LinkedList<>();
        cap=capacity;
        map=new HashMap<>();
    }
    
    public int get(int key) {
        if(map.containsKey(key))
        {
            q.remove(key);
            q.add(key);
            return map.get(key);
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key))
        {
            q.remove(key);
        }
        else{
            if(map.size()==cap)
            {
                map.remove(q.poll());
            }
        }
        q.add(key);
        map.put(key,value);
        //System.out.println(q);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
class KthLargest {
    Queue<Integer>q;
    int k;
    public KthLargest(int k, int[] nums) {
        q=new PriorityQueue<>();
        this.k=k;
        for(int i=0;i<nums.length;++i)
        {
            if(q.size()==k){if(q.peek()<nums[i]){q.poll();q.add(nums[i]);}}
            else{q.add(nums[i]);}
            //System.out.print(q);
        }
    }
    
    public int add(int val) {
        if(q.size()==k){if(q.peek()<val){q.poll();q.add(val);}}
        else{q.add(val);}
        return q.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
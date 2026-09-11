class MedianFinder {
    PriorityQueue<Integer>p1;
    PriorityQueue<Integer>p2;
    int count=0;
    public MedianFinder() {
        p1=new PriorityQueue<>((a,b)->b-a);
        p2=new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(p1.isEmpty()||p1.peek()>num){p1.add(num);}
        else{p2.add(num);}
        ++count;
        if(count%2==0)
        {
            while(!p1.isEmpty()&&p1.size()>p2.size())
            {
                p2.add(p1.poll());
            }
            while(!p2.isEmpty()&&p2.size()>p1.size())
            {
                p1.add(p2.poll());
            }
        }
        else{
            while(!p1.isEmpty()&&p1.size()-1>p2.size())
            {
                p2.add(p1.poll());
            }
            while(!p2.isEmpty()&&p2.size()>p1.size())
            {
                p1.add(p2.poll());
            }
        }
        
    }
    
    public double findMedian() {
        double sum=p1.peek();
        if(count%2==0)
        {sum+=p2.peek(); return sum/2;}
        return sum;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
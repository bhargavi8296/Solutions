class MedianFinder {
    Queue<Integer>q1;
    Queue<Integer>q2;
    int count;
    public MedianFinder() {
        q2=new PriorityQueue<>((a,b)->a-b);
        q1=new PriorityQueue<>((a,b)->b-a);
        count=0;
    }
    
    public void addNum(int num) {
        if(q1.isEmpty()||q1.peek()>num){q1.add(num);}
        else{q2.add(num);}
        ++count;
        //System.out.println(q1+" "+q2);
        if(count%2==0)
        {
            if(q1.size()>q2.size())
            {
                q2.add(q1.poll());
            }
            else if(q2.size()>q1.size())
            {
                q1.add(q2.poll());
            }
        }
        else{
            if(q1.size()-1>q2.size())
            {
                q2.add(q1.poll());
            }
            else if(q2.size()>q1.size())
            {
                q1.add(q2.poll());
            }
        } 
    }
    
    public double findMedian() {
        if(count%2==0){double meadian=q1.peek();meadian+=q2.peek();return meadian/2;}
        return q1.peek();
    }
}
/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

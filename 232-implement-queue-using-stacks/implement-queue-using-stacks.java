class MyQueue {
    Stack<Integer>st;
    int t=-1;
    public MyQueue() {
        st=new Stack<>();
    }
    
    public void push(int x) {
        if(empty()){t=x;}
        st.push(x);
    }
    
    public int pop() {
        if(st.isEmpty()){return -1;}
        Stack<Integer>temp=new Stack<>();
        while(!st.isEmpty())
        {
            temp.push(st.pop());
        }
        int res=temp.pop();
        if(temp.isEmpty()){t=-1;}
        else{t=temp.peek();}
        while(!temp.isEmpty())
        {
            st.push(temp.pop());
        }
        
        return res;
    }
    
    public int peek() {
        return t;
    }
    
    public boolean empty() {
        return st.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
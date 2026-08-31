class pair{
    int v;
    int m;
    pair(int v, int m)
    {
        this.v=v;
        this.m=m;
    }
}
class MinStack {

    Stack<pair>st;
    int min=Integer.MAX_VALUE;
    public MinStack() {
        st=new Stack();
    }
    
    public void push(int value) {
        min=Math.min(min,value);
        st.push(new pair(value,min));
    }
    
    public void pop() {
        st.pop();
        min=st.isEmpty()?Integer.MAX_VALUE:st.peek().m;
        //System.out.println(min);
    }
    
    public int top() {
        return st.peek().v;
    }
    
    public int getMin() {
        return st.peek().m;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
 
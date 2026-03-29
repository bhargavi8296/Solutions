class Solution {
    public void sortStack(Stack<Integer> st) {
        // code here
        if(st.isEmpty()){return;}
        int temp=st.pop();
        sortStack(st);
        Stack<Integer>t=new Stack<>();
        while(!st.isEmpty()&&st.peek()>temp)
        {
            t.push(st.pop());
        }
        st.push(temp);
        while(!t.isEmpty())
        {
            st.push(t.pop());
        }
        
    }
}
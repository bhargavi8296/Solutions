class Solution {
    public static void reverseStack(Stack<Integer> st) {
        // code here
        if(st.isEmpty()){return;}
        int temp=st.pop();
        reverseStack(st);
        Stack<Integer>t=new Stack<>();
        while(!st.isEmpty())
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

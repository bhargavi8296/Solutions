class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<s.length();++i)
        {
            if(s.charAt(i)=='(')
            {
                st.push(0);
            }
            else{
                int temp=0;
                while(st.peek()!=0)
                {
                    temp=temp+st.pop();
                }
                if(temp!=0){
                    temp*=2;
                }
                else{
                    temp=1;
                }
                st.pop();
                st.push(temp);
            }
        }
        int temp=0;
        while(!st.isEmpty())
        {
            temp+=st.pop();
        }
        return temp;
    }
}
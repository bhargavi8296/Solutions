class Solution {
    public String infixToPrefix(String s) {
        // code here
        Stack<Character>st=new Stack<>();
        String str="";
        for(int i=s.length()-1;i>=0;--i)
        {
            //System.out.println(st+" "+i);
            if((s.charAt(i)>='a'&&s.charAt(i)<='z')||(s.charAt(i)>='A'&&s.charAt(i)<='Z'))
            {
                str=s.charAt(i)+str;
            }
            else{
                if(s.charAt(i)==')'){st.push(s.charAt(i));}
                else if(s.charAt(i)=='(')
                {
                    while(st.peek()!=')')
                    {
                        str=st.pop()+str;
                    }
                    st.pop();
                }
                else{
                    if(s.charAt(i)=='+'||s.charAt(i)=='-')
                    {
                        while(!st.isEmpty()&&(st.peek()!='+'&&st.peek()!='-'&&st.peek()!=')'))
                        {str=st.pop()+str;}
                    }
                    else if(s.charAt(i)=='*'||s.charAt(i)=='/')
                    {
                        while(!st.isEmpty()&&(st.peek()=='^'))
                        {str=st.pop()+str;}
                    }
                    else{
                        while(!st.isEmpty()&&st.peek()=='^')
                        {
                            str=st.pop()+str;
                        }
                    }
                    st.push(s.charAt(i));
                }
                
            }
        }
        while(!st.isEmpty())
        {
            str=st.pop()+str;
        }
        return str;
    }
}
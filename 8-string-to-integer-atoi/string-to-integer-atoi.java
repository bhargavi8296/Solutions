class Solution {
    public int myAtoi(String s) {
        Stack<Character>st=new Stack<>();
        s=s.trim();
        String ans="0";
        int flag=1;
        for(int i=0;i<s.length();++i)
        {
            if(i==0&&(s.charAt(i)=='+'||s.charAt(i)=='-')){
                flag=s.charAt(i)=='+'?flag:-1;
            }
            else
            {
                if(s.charAt(i)>='0'&&s.charAt(i)<='9')
                {
                    if(st.isEmpty()&&s.charAt(i)=='0'){continue;}
                    else{st.push(s.charAt(i));ans+=s.charAt(i);}
                }
                else{
                    break;
                }
            }
            if(flag>0){if(Long.parseLong(ans)>=Integer.MAX_VALUE){return Integer.MAX_VALUE;}}
            else{if((flag*Long.parseLong(ans))<=Integer.MIN_VALUE){return Integer.MIN_VALUE;}}
        }
        return Integer.parseInt(ans)*flag;
    }
}

class pair{
    char val;
    int count;
    pair(char val,int count){
        this.val=val;
        this.count=count;
    }
}
class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<pair>st=new Stack<>();
        for(int i=0;i<s.length();++i)
        {
            if(!st.isEmpty()&&st.peek().val==s.charAt(i))
            {
                if(st.peek().count==k-1){st.pop();}
                else{
                    pair temp=st.pop();
                    temp.count+=1;
                    st.push(temp);
                }
            }
            else{
                st.push(new pair(s.charAt(i),1));
            }
        }
        String result="";
        while(!st.isEmpty())
        {
            pair temp=st.pop();
            result=(temp.val+"").repeat(temp.count)+result;
        }
        return result;
    }
}
class Solution {
    public int myAtoi(String s) {
        int i=0;
        boolean flag=false;
        s=s.trim();
        if(s.length()>0&&(s.charAt(0)=='+'||s.charAt(i)=='-'))
        {
            if(s.charAt(i)=='-'){flag=true;}
            ++i;
        }
        while(i<s.length()&&s.charAt(i)=='0'){++i;}
        long res=0;
        while(i<s.length()&&s.charAt(i)>='0'&&s.charAt(i)<='9')
        {
            res*=10;
            res+=(s.charAt(i)-'0');
            if(!flag&&res>Integer.MAX_VALUE){return Integer.MAX_VALUE;}
            else if(flag&&res*-1<Integer.MIN_VALUE){return Integer.MIN_VALUE;}
            ++i;
        }
        res=flag==true?res*-1:res;
        return (int)res;
    }
}
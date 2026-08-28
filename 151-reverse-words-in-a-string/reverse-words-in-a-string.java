class Solution {
    public String reverseWords(String s) {
       s=s.trim();
       int i=0;
       String result="";
       while(i<s.length())
       {
        String temp="";
            while(i<s.length()&&s.charAt(i)!=' ')
            {
                //System.out.println(s.charAt(i));
                temp+=s.charAt(i);
                ++i;
            }
            //System.out.println(temp+".");
            result=temp+" "+result;
            while(i<s.length()&&s.charAt(i)==' '){++i;}
       } 
    
    String str=result.trim();
    return str;
    }
}
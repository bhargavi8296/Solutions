class Solution {
    public boolean isPalindrome(String s) {
        s=s.toLowerCase();
        int i=0;int j=s.length()-1;
        while(i<j)
        {
            while(i<s.length()&&!(s.charAt(i)>='a'&&s.charAt(i)<='z')&&!(s.charAt(i)>='0'&&s.charAt(i)<='9')){++i;}
            while(j>=0&&!(s.charAt(j)>='a'&&s.charAt(j)<='z')&&!(s.charAt(j)>='0'&&s.charAt(j)<='9')){--j;}
            if(i<s.length()&&j>=0)
            {if(s.charAt(i)!=s.charAt(j)){return false;}
            ++i;--j;}
        }
        return true;
    }
}
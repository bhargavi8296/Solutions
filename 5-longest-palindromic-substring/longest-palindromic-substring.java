class Solution {
    public String longestPalindrome(String s) {
        String str="";
        for(int i=0;i<s.length();++i)
        {
            int j=i-1;
            int k=i+1;
            while(j>=0&&k<s.length()&&s.charAt(j)==s.charAt(k))
            {
                --j;++k;
            }
            if(str.length()<k-j-1)
            {
                str=s.substring(j+1,k);
            }
        }
        for(int i=0;i<s.length()-1;++i)
        {
            if(s.charAt(i)==s.charAt(i+1))
            {
                int j=i-1;
                int k=i+2;
                while(j>=0&&k<s.length()&&s.charAt(j)==s.charAt(k))
                {
                    --j;++k;
                }
                if(str.length()<k-j-1)
                {
                    str=s.substring(j+1,k);
                }
            }
        }
        return str;
    }
}
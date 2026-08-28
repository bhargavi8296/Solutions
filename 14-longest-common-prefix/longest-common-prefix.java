class Solution {
    public String longestCommonPrefix(String[] strs) {
        String temp=strs[0];
        for(int i=1;i<strs.length;++i)
        {
            String t=strs[i];
            int j=0;int k=0;
            while(j<temp.length()&&k<t.length())
            {
                if(temp.charAt(j)!=t.charAt(k)){break;}
                ++j;++k;
            }
            temp=temp.substring(0,Math.min(j,k));
        }
        return temp;
    }
}
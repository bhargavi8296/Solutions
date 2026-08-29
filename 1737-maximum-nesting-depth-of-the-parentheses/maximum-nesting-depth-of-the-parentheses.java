class Solution {
    public int maxDepth(String s) {
        int l=0;
        int r=0;
        int max=0;
        // int total=0;
        // for(int i=0;i<s.length();++i)
        // {
        //     if(s.charAt(i)=='('){++total;}
        // }
        for(int i=0;i<s.length();++i)
        {
            if(s.charAt(i)=='('){++l;}
            if(s.charAt(i)==')'){++r;}
            max=Math.max(max,l-r);
        }
        return max;
    }
}
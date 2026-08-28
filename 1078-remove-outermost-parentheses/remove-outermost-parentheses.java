class Solution {
    public String removeOuterParentheses(String s) {
        int i=0;
        int l=0;
        int r=0;
        int j=0;
        String result="";
        while(i<s.length())
        {
            j=i;
            while(j<s.length())
            {
                //System.out.println(j+" ");
                if(s.charAt(j)==')'){++r;}
                else{++l;}
                if(l==r){break;}
                ++j;
            }
            if(l!=0&&l==r)
            {
                result+=s.substring(i+1,j);
            }
            i=j;
        }
        return result;
    }
}
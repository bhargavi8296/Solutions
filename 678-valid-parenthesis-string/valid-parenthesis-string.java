class Solution {
    public boolean checkValidString(String s) {
        int l=0;
        int p=0;
        for(int i=0;i<s.length();++i)
        {
            if(s.charAt(i)=='('){++l;}
            else if(s.charAt(i)==')'){
                if(l>0){--l;}
                else if(p>0){--p;}
                else{return false;}
            }
            else{++p;}
        }l=0;p=0;
         for(int i=s.length()-1;i>=0;--i)
        {
            if(s.charAt(i)==')'){++l;}
            else if(s.charAt(i)=='('){
                if(l>0){--l;}
                else if(p>0){--p;}
                else{return false;}
            }
            else{++p;}
        }
        return true;
    }
}
class Solution {
    public boolean rotateString(String s, String goal) {
       for(int i=0;i<s.length();++i)
       {
        String str=s.substring(i+1)+s.substring(0,i+1);
        if(str.equals(goal)){return true;}
       } 
       return false;
    }
}
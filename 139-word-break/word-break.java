class Solution {
    int temp[];
    public boolean helper(String s, List<String>w, int i)
    {
        if(i==s.length()){return true;}
        if(temp[i]!=-1){
            return temp[i]==1?true:false;
        }
        String str="";
        for(int j=i;j<s.length();++j)
        {
            str+=s.charAt(j);
            //w.remove(str);
            if(w.contains(str))
            {
                if(helper(s,w,j+1)){
                    temp[i]=1;
                    return true;}
                else{
                    temp[i]=0;
                }
            }
            //w.add(str);
        }
        return false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        temp=new int[s.length()];
        Arrays.fill(temp,-1);
        return helper(s,wordDict,0);
    }
}
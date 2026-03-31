class Solution {
    List<String>wD;
    int temp[];
    public boolean helper(String s, int i)
    {
        if(i==s.length()){return true;}
        String str="";
        if(temp[i]!=-1)
        {
            return temp[1]==1?true:false;
        }
        for(int j=i;j<s.length();++j)
        {
            str+=s.charAt(j);
            if(wD.contains(str))
            {
                if(helper(s,j+1)){
                    temp[i]=1;
                    return true;}
                else{
                    temp[i]=0;
                }
            }
        }
        return false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        wD=wordDict;
        temp=new int[s.length()];
        Arrays.fill(temp,-1);
        return helper(s,0);
    }
}
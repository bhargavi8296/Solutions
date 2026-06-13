class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        String result="";
        for(String str:words)
        {
            int sum=0;
            for(char ch:str.toCharArray())
            {
                sum+=weights[ch-'a'];
            }
            sum=25-(sum%26);
            result+=(char)('a'+sum);
        }
        return result;
        
    }
    
}
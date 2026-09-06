class Solution {
    public int beautySum(String s) {
        int result=0;
        for(int i=0;i<s.length();++i)
        {
            int freq[]=new int[26];
            for(int k=i;k<s.length();++k)
            {
                freq[s.charAt(k)-'a']++;
                int max=Integer.MIN_VALUE;
                int min=Integer.MAX_VALUE;
                for(int j=0;j<26;++j)
                {
                    if(freq[j]>0){
                        max=Math.max(max,freq[j]);
                        min=Math.min(min,freq[j]);
                    }
                }
                result+=(max-min);
            }
        }
        return result;

    }
}

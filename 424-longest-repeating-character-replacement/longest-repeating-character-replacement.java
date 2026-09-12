class Solution {
    public int characterReplacement(String s, int k) {
        int i=0;
        int j=0;
        int []freq=new int[26];
        int max=0;
        int result=0;
        while(j<s.length())
        {
            freq[s.charAt(j)-'A']++;
            max=Math.max(max,freq[s.charAt(j)-'A']);
            while((j-i+1)-max>k)
            {
                freq[s.charAt(i)-'A']--;
                ++i;
            }
            result=Math.max(result,j-i+1);
            ++j;
        }
        return result;
    }
}


class Solution {
    public int characterReplacement(String s, int K) {
        Set<Character>set=new HashSet<>();
        int arr[]=new int[26];
        int i=0;
        int count=0;
        int maxFreq=0;
        int result=0;
        int j=i;
        while(i<s.length())
        {
            while(j<s.length()&&count-maxFreq<=K)
            {
                arr[s.charAt(j)-'A']++;
                set.add(s.charAt(j));
                for(char ch:set){maxFreq=Math.max(arr[ch-'A'],maxFreq);}
                ++count;++j;
            }
            //System.out.println(j+" "+i+" "+maxFreq+" "+count);
            result=Math.max(result,j-i+(count-maxFreq<=K?0:-1));
            if(j>=s.length()){break;}
            while(i<s.length()&&count-maxFreq>K)
            {
                arr[s.charAt(i)-'A']--;
                if(arr[s.charAt(i)-'A']==0){set.remove(s.charAt(i));}
                for(char ch:set){maxFreq=Math.max(arr[ch-'A'],maxFreq);}
                --count;++i;
            }
        }
        return result;
    }
}
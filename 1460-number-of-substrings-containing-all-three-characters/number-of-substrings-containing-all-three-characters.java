class Solution {
    public int numberOfSubstrings(String s) {
        int n=s.length();
        long total=((n)*1L*(n+1))/2;
        int i=0;int j=0;
        int result=0;
        Map<Character,Integer>map=new HashMap<>();
        while(j<s.length())
        {
            map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);
            while(map.size()>2)
            {
                map.put(s.charAt(i),map.get(s.charAt(i))-1);
                if(map.get(s.charAt(i))==0)
                {
                    {map.remove(s.charAt(i));}
                }
                ++i;
            }
            result+=(j-i+1);
            ++j;
        }
        return (int)(total-result);
    }
}

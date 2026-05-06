class Solution {
    public int longestKSubstr(String s, int k) {
        // code here
        int i=0;
        Map<Character,Integer>map=new HashMap<>();
        int j=0;
        int result=-1;
        while(j<s.length())
        {
            //System.out.print(i);
            map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);
            if(map.size()>k)
            {
                result=Math.max(result,j-i);
                while(map.size()>k)
                {
                    map.put(s.charAt(i),map.get(s.charAt(i))-1);
                    if(map.get(s.charAt(i))==0)
                    {
                        map.remove(s.charAt(i));
                    }
                    ++i;
                }
            }
            ++j;
            
        }
        if(map.size()==k){result=Math.max(result,j-i);}
        return result;
    }
}
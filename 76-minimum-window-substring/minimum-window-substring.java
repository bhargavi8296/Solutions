class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer>map=new HashMap<>();
        for(int i=0;i<t.length();++i)
        {
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)+1);
        }
        int i=0;int j=0;
        int count=0;
        int result=Integer.MAX_VALUE;
        String res="";
        while(j<s.length())
        {
            if(map.getOrDefault(s.charAt(j),0)>0){++count;}
            map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)-1);
            ++j;
            if(count==t.length())
            {
                while(i<j&&count==t.length())
                {   
                    if(j-i<result){result=j-i;res=s.substring(i,j);}
                    map.put(s.charAt(i),map.get(s.charAt(i))+1);
                    if(map.get(s.charAt(i))>0){--count;}
                    ++i;
                }
            }
        }
        //System.out.println(res);
        return res;
    }
}
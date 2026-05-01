class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer>map=new HashMap<>();
        int count=0;
        int result=0;
        int start=0;
        for(int i=0;i<s.length();++i)
        {
            char c=s.charAt(i);
            if(!map.containsKey(c)){++count;}
            else{if(map.get(c)>=start){start=map.get(c);count=i-map.get(c);}else{++count;}}
            map.put(c,i);
            result=Math.max(result,count);
            //System.out.println(result+" "+i+" "+count);
        }
        return result;
    }
}
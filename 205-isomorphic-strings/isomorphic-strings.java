class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character,Character>m1=new HashMap<>();
        Set<Character>set=new HashSet<>();
        for(int i=0;i<s.length();++i)
        {
            if(m1.containsKey(s.charAt(i)))
            {
                if(m1.get(s.charAt(i))!=t.charAt(i)){return false;}
            }
            else{
                if(set.contains(t.charAt(i))){return false;}
                m1.put(s.charAt(i),t.charAt(i));
                set.add(t.charAt(i));
            }
        }
        return true;
    }
}
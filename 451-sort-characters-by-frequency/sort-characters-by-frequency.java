class Solution {
    public String frequencySort(String s) {
        int ch[]=new int[26];
        int ch1[]=new int[26];
        int ch2[]=new int[10];
        for(int i=0;i<s.length();++i)
        {
            if(s.charAt(i)>='A'&&s.charAt(i)<='Z')
            {ch[s.charAt(i)-'A']++;}
            else if(s.charAt(i)>='a'&&s.charAt(i)<='z'){
                ch1[s.charAt(i)-'a']++;
            }
            else{
                ch2[s.charAt(i)-'0']++;
            }

        }
        Map<Integer,List<Character>>map=new TreeMap<>();
        for(int i=0;i<26;++i)
        {
            if(ch[i]>0)
            {
                if(!map.containsKey(ch[i]))
                {
                    map.put(ch[i],new ArrayList<>());
                }
                map.get(ch[i]).add((char)('A'+i));
            }
            if(ch1[i]>0)
            {
                if(!map.containsKey(ch1[i]))
                {
                    map.put(ch1[i],new ArrayList<>());
                }
                //System.out.println(map+" "+ch1[i]);
                map.get(ch1[i]).add((char)('a'+i));
            }
            if(i<10&&ch2[i]>0)
            {
                if(!map.containsKey(ch2[i]))
                {
                    map.put(ch2[i],new ArrayList<>());
                }
                //System.out.println(map+" "+ch1[i]);
                map.get(ch2[i]).add((char)('0'+i));
            }
        }
        //System.out.print(map);
        String result="";
        for (Map.Entry<Integer, List<Character>> entry : map.entrySet()) {
            int key=entry.getKey();
            List<Character>temp=entry.getValue();
            for(char c:temp)
            {
                result=(c+"").repeat(key)+result;
            }
        }
        return result;
    }
}
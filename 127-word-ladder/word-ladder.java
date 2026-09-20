class pair{
    String str;
    int count;
    pair(String str, int count)
    {
        this.str=str;
        this.count=count;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<pair>q=new LinkedList<>();
        q.add(new pair(beginWord,0));
        Set<String>set=new HashSet<>();
        set.addAll(wordList);
        if(!wordList.contains(endWord)){return 0;}
        set.remove(beginWord);
        while(!q.isEmpty())
        {
            pair temp=q.poll();
            String str=temp.str;
            int count=temp.count;
            if(str.equals(endWord)){return count+1;}
            for(int i=0;i<str.length();++i)
            {
                for(int j=0;j<26;++j)
                {
                    if(str.charAt(i)!=('a'+j))
                    {
                        String s = str.substring(0, i) +(char)('a'+j) + str.substring(i + 1);
                        //System.out.println(s);
                        if(set.contains(s)){q.add(new pair(s,count+1));set.remove(s);}
                    }
                }
            }
        }
        return 0;
    }
}
class Node{
    public Node []num;
    public boolean isEnd;
    public Node(){
        num=new Node[26];
        isEnd=false;
    }
}
class Solution {
    public String longestValidWord(String[] words) {
        // code here
        Node temp=new Node();
        for(int i=0;i<words.length;++i)
        {
            Node tem=temp;
            for(int j=0;j<words[i].length();++j)
            {
                char ch=words[i].charAt(j);
                if(tem.num[ch-'a']==null)
                {
                    tem.num[ch-'a']=new Node();
                }
                tem=tem.num[ch-'a'];
            }
            tem.isEnd=true;
        }
        List<String>list=new ArrayList<>();
        String ans="";
        for(int i=0;i<words.length;++i)
        {
            Node tem=temp;
            boolean flag=false;
            for(int j=0;j<words[i].length()-1;++j)
            {
                char ch=words[i].charAt(j);
                if(!tem.num[ch-'a'].isEnd)
                {
                    flag=true; break;
                }
                tem=tem.num[ch-'a'];
            }
            if(!flag){
                String word=words[i];
                if(ans.length()<word.length()){ans=word;}
                 else if (word.length() == ans.length()
                        && word.compareTo(ans) < 0) {

                    ans = word;
                }
            }
        }
        return ans;
        
    }
}
class Node{
    Node num[];
    public Node()
    {
        num=new Node[26];
    }
}
class Solution {
    public static int countSubs(String s) {
        // code here
        Node temp=new Node();
        int count=0;
        for(int i=0;i<s.length();++i)
        {
            Node tem=temp;
            for(int j=i;j<s.length();++j)
            {
                if(tem.num[s.charAt(j)-'a']==null){
                    ++count;
                    tem.num[s.charAt(j)-'a']=new Node();
                }
                tem=tem.num[s.charAt(j)-'a'];
            }
        }
        return count;
        
    }
}
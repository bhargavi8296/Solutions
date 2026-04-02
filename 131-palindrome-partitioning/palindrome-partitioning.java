class Solution {
    List<List<String>>list;
    public void helper(int i, String s,String st, String en,List<String>res)
    {
        if(i==0)
        {
            st+=s.charAt(i);
            en=s.charAt(i)+en;
            if(st.equals(en))
            {
                List<String>r=new ArrayList<>();
                r.addAll(res);
                r.add(st);
                Collections.reverse(r);
                list.add(r);
            }
            return;
        }
        st+=s.charAt(i);
        en=s.charAt(i)+en;
        if(st.equals(en))
        {
            List<String>r=new ArrayList<>();
            r.addAll(res);
            r.add(st);
            helper(i-1,s,"","",r);
            helper(i-1,s,st,en,res);
            return;
        }
        helper(i-1,s,st,en,res);
    }
    public List<List<String>> partition(String s) {
        list=new ArrayList<>();
        helper(s.length()-1,s,"","",new ArrayList<>());
        return list;
    }
}
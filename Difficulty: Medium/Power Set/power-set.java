// User function Template for Java

class Solution {
    List<String>list;
    public void helper(String str, int i,String temp)
    {
        if(i<0){if(!temp.equals("")){list.add(temp);}return;}
        //if(list.contains(temp)){return;}
        helper(str,i-1,str.charAt(i)+temp);
        helper(str,i-1,temp);
    }
    public List<String> AllPossibleStrings(String s) {
        // Code here
        list=new ArrayList<>();
        helper(s,s.length()-1,"");
        Collections.sort(list);
        return list;
    }
}
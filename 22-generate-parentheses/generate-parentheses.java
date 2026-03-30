class Solution {
    List<String>result;
    public void helper(int c1,int c2, String str)
    {
        if(c1==0&&c2==0){result.add(str);return;}
        if(c1<c2){helper(c1,c2-1,str+')');}
        if(c1>0){helper(c1-1,c2,str+'(');}
    }
    public List<String> generateParenthesis(int n) {
        result=new ArrayList<>();
        helper(n,n,"");
        return result;
    }
}
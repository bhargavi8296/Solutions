class Solution {
    List<List<String>>result;
    List<String>res;
    public boolean check(int r, int c)
    {
        int tr=r;
        int tc=c;
        while(tr>=0){
            if(res.get(tr).charAt(tc)=='Q'){return false;}
            --tr;
        }
        tr=r;tc=c;
        while(tr>=0&&tc>=0)
        {
             if(res.get(tr).charAt(tc)=='Q'){return false;}
            --tr;--tc;
        }
        tr=r;
        tc=c;
        while(tr>=0&&tc<res.size())
        {
             if(res.get(tr).charAt(tc)=='Q'){return false;}
            --tr;++tc;
        }
        return true;
    }
    public void helper(int r, int n)
    {
        if(r==n){List<String>temp=new ArrayList<>();temp.addAll(res);result.add(temp);return ;}
        for(int i=0;i<n;++i)
        {
            if(check(r,i))
            {
                StringBuilder sb = new StringBuilder(res.get(r));
                sb.setCharAt(i, 'Q');
                res.set(r, sb.toString());
                helper(r+1,n);
                sb.setCharAt(i, '.');
                res.set(r, sb.toString());
            }
        }
        return ;
    }
    public List<List<String>> solveNQueens(int n) {
        result=new ArrayList<>();
        res=new ArrayList<>();
        String str=".".repeat(n);
        for(int i=0;i<n;++i){res.add(str);}
        helper(0,n);
        return result;
    }
}
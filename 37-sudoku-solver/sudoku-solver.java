class Solution {
    char b[][];
    public boolean check(int r,int c, char num)
    {
        int sr=(r/3)*3;
        int sc=(c/3)*3;
        for(int i=0;i<9;++i){if(b[r][i]==num||b[i][c]==num){return false;}}
        for(int i=sr;i<sr+3;++i)
        {
            for(int j=sc;j<sc+3;++j)
            {
                if(b[i][j]==num){return false;}
            }
        }
        return true;
    }
    public boolean helper(int r, int c)
    {
        if(r==9){return true;}
        int tr=r;
        int tc=c;
        if(c+1==9){tr=r+1;tc=0;}
        else{tc=c+1;}
        //System.out.println(tr+" "+tc);
        if(b[r][c]=='.')
        {
            for(int i=1;i<=9;++i)
            {
                if(check(r,c,(char)('0' + i)))
                {
                    b[r][c]=(char)('0' + i);
                    if(helper(tr,tc)){return true;}
                    b[r][c]='.';
                }
            }
            return false;
        }
        return helper(tr,tc);
    }
    public void solveSudoku(char[][] board) {
        b=board;
        helper(0,0);
    }
}
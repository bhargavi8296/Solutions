class Solution {
    public void helper(char[][]board,int ro,int co)
    {
        if(board[ro][co]!='O'){return ;}
        //System.out.println(ro+" "+co);
        board[ro][co]='M';
        int r[]={0,1,0,-1};
        int c[]={1,0,-1,0};
        for(int i=0;i<4;++i)
        {
            int tr=ro+r[i];
            int tc=co+c[i];
            if(tr>=0&&tr<board.length&&tc>=0&&tc<board[0].length&&board[tr][tc]=='O')
            {
                helper(board,tr,tc);
            }
        }
    }
    public void solve(char[][] board) {
        for(int i=0;i<board.length;++i)
        {
            if(board[i][0]=='O'){helper(board,i,0);}
            if(board[i][board[0].length-1]=='O'){helper(board,i,board[0].length-1);}
        }
        for(int i=0;i<board[0].length;++i)
        {
            if(board[0][i]=='O'){helper(board,0,i);}
            if(board[board.length-1][i]=='O'){helper(board,board.length-1,i);}
        }
        for(int i=0;i<board.length;++i)
        {
            for(int j=0;j<board[i].length;++j)
            {
                if(board[i][j]=='M')
                {
                    board[i][j]='O';
                }
                 else if(board[i][j]=='O')
                {
                    board[i][j]='X';
                }
            }
        }
        return ;
    }
}
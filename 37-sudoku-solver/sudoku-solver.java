class Solution {
    public boolean verify(char[][]board, int r, int c, char ch)
    {
        for(int i=0;i<9;++i)
        {
            if(board[i][c]==ch||board[r][i]==ch){return false;}
        }
        int sr=(r/3)*3;
        int sc=(c/3)*3;
        for(int i=sr;i<sr+3;++i)
        {
            for(int j=sc;j<sc+3;++j)
            {
                if(board[i][j]==ch){return false;}
            }
        }
        return true;
    }
    public boolean helper(char[][] board,int r, int c){
        if(r==board.length){return true;}
        if(board[r][c]!='.'){
            int tc=c+1==9?0:c+1;
            int tr=c+1==9?r+1:r;
            return helper(board,tr,tc);
        } 
        for(int i=0;i<9;++i)
        {
            if(verify(board,r,c,(char)('0'+i+1))){
                board[r][c]=(char)('0'+i+1);
                int tc=c+1==9?0:c+1;
                int tr=c+1==9?r+1:r;
                if(helper(board,tr,tc)){return true;}
                board[r][c]='.';
            }
        }
        return false;
    }
    public void solveSudoku(char[][] board) {
           helper(board,0,0);
    }
}
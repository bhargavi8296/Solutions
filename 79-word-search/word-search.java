class Solution {
    char b[][];
    String w;
    int visited[][];
    public boolean helper(int r,int c, int ind)
    {
        if(ind==w.length()){return true;}
        int ro[]={0,1,0,-1};
        int co[]={1,0,-1,0};
        for(int i=0;i<4;++i)
        {
            int tr=r+ro[i];
            int tc=c+co[i];
            if(tr>=0&&tr<b.length&&tc>=0&&tc<b[0].length&&b[tr][tc]==w.charAt(ind)&&visited[tr][tc]==0)
            {
                visited[tr][tc]=1;
                if(helper(tr,tc,ind+1)){return true;}
                visited[tr][tc]=0;
            }
        }
        return false;
    }
    public boolean exist(char[][] board, String word) {
        b=board;
        w=word;
        visited=new int[board.length][board[0].length];
        for(int i=0;i<board.length;++i)
        {
            for(int j=0;j<board[i].length;++j)
            {
                if(board[i][j]==word.charAt(0))
                {
                    visited[i][j]=1;
                    if(helper(i,j,1)){return true;}
                    visited[i][j]=0;
                }
            }
        }
        return false;
    }
}
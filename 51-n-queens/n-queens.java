class Solution {
    int mat[][];
    List<List<String>>result;
    public boolean verify(int[][]mat, int r, int c)
    {
        int tr=r-1;
        while(tr>=0)
        {
            if(mat[tr][c]==1){return false;}--tr;
        }
        tr=r-1;
        int tc=c-1;
        while(tr>=0&&tc>=0)
        {
            if(mat[tr][tc]==1){return false;}
            --tr;--tc;
        }
        tc=c+1;
        tr=r-1;
        while(tr>=0&&tc<mat[0].length)
        {
            if(mat[tr][tc]==1){return false;}
            --tr;++tc;
        }
        return true;
    }
    public void addResult(int mat[][])
    {
        result.add(new ArrayList<>());
        for(int i=0;i<mat.length;++i)
        {
            String res="";
            for(int j=0;j<mat[i].length;++j)
            {
                if(mat[i][j]==0)
                {
                    res+='.';
                }
                else{
                    res+='Q';
                }
            }
            result.get(result.size()-1).add(res);
        }
    }
    public void helper(int mat[][], int r){
        if(r==mat.length)
        {
            addResult(mat);return;
        }
        for(int i=0;i<mat[r].length;++i)
        {
            if(verify(mat,r,i))
            {
                mat[r][i]=1;
                helper(mat,r+1);
                mat[r][i]=0;
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        mat=new int[n][n];
        result=new ArrayList<>();
        helper(mat,0);
        return result;
    }
}
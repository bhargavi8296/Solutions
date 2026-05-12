class Solution {
    public int countSquares(int[][] matrix) {
        int m=matrix.length-1;
        int n=matrix[0].length-1;
        int res=0;
        for(int i=m-1;i>=0;--i)
        {
            for(int j=n-1;j>=0;--j)
            {
                if(matrix[i][j]!=0)
                {
                    matrix[i][j]=Math.min(matrix[i+1][j],Math.min(matrix[i][j+1],matrix[i+1][j+1]))+1;
                }
            }
        }
        for(int i=0;i<=m;++i)
        {
            for(int j=0;j<=n;++j)
            {
                res+=matrix[i][j];
            }
        }
        return res;
    }
}
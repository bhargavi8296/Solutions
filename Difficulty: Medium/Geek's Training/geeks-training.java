class Solution {
    public int maximumPoints(int mat[][]) {
        // code here
        for(int i=1;i<mat.length;++i)
        {
            for(int j=0;j<mat[i].length;++j)
            {
                int f=(j+1)%3;
                int s=(j+2)%3;
                mat[i][j]+=Math.max(mat[i-1][f],mat[i-1][s]);
            }
        }
        int result=0;
        for(int j=0;j<mat[0].length;++j)
        {
            result=Math.max(result,mat[mat.length-1][j]);
        }
        return result;
    }
}
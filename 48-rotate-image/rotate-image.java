class Solution {
    public void rotate(int[][] matrix) {
        int [][]t=new int[matrix.length][matrix.length];
        for(int i=0;i<matrix.length;++i)
        {
            for(int j=0;j<matrix[0].length;++j)
            {
                t[j][matrix.length-i-1]=matrix[i][j];
            }
        }
        for(int i=0;i<matrix.length;++i)
        {
            for(int j=0;j<matrix[0].length;++j)
            {
                matrix[i][j]=t[i][j];
            }
        }
    }
}
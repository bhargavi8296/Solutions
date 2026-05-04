class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r=0;
        int c=matrix[0].length-1;
        while(r<matrix.length&&c>=0)
        {
            if(matrix[r][c]==target){return true;}
            else if(matrix[r][c]>target){c-=1;}
            else{r+=1;}
        }
        return false;
    }
}
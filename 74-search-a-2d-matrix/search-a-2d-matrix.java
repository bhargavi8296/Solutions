class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l=0;
        int h=(matrix.length*matrix[0].length)-1;
        while(l<=h)
        {
            int mid=(l+h)/2;
            int r=((mid)/matrix[0].length);
            int c=((mid)%matrix[0].length);
            //System.out.println(mid+" "+r+" "+c);
            if(matrix[r][c]==target){return true;}
            else if(matrix[r][c]>target){h=mid-1;}
            else{l=mid+1;}
        }
        return false;
    }
}
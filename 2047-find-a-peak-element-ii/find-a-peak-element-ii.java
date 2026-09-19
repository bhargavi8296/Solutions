class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int l=0;
        int h=mat[0].length-1;
        int result[]=new int[2];
        while(l<=h)
        {
            int mid=(l+h)/2;
            int ind=0;
            for(int i=0;i<mat.length;++i)
            {
                if(mat[ind][mid]<mat[i][mid])
                {
                    ind=i;
                }
            }
            int left=mid-1<0?Integer.MIN_VALUE:mat[ind][mid-1];
            int right=mid+1>=mat[0].length?Integer.MIN_VALUE:mat[ind][mid+1];
            if(mat[ind][mid]>left&&mat[ind][mid]>right){
                result[0]=ind;
                result[1]=mid;
                break;
            }
            else if(mat[ind][mid]>left){l=mid+1;}
            else{
                h=mid-1;
            }
        }
        return result;
    }
}
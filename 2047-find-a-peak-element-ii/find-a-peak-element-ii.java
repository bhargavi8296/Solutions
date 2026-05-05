class Solution {
    public int max(int[][]mat,int col){
    int row=-1;
    int val=Integer.MIN_VALUE;
    for(int i=0;i<mat.length;++i)
    {
        if(val<mat[i][col]){val=mat[i][col];row=i;}
    }
    return row;
}
    public int[] findPeakGrid(int[][] mat) {
        int low=0;
        int high=mat[0].length-1;
        while(low<=high)
        {
            int mid=(low+high)/2;
            int row=max(mat,mid);
            int left=mid-1>=0?mat[row][mid-1]:Integer.MIN_VALUE;
            int right=mid+1<mat[0].length?mat[row][mid+1]:Integer.MIN_VALUE;
            int val=mat[row][mid];
            //System.out.println(left+" "+right+" "+val);
            if(val>left&&val>right){return new int[]{row, mid};}
            if(val>left){low=mid+1;}
            if(val>right){high=mid-1;}
        }
        return new int[2];
    }
}
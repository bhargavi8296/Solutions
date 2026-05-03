class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r=matrix.length;int c=matrix[0].length;
        int start=0;
        int end=r*c-1;
        
        while(start<=end)
        {
            int mid=(start+end)/2;
            int tr=mid/c;
            int tc=(mid%c);
            //System.out.println(mid+" "+tr+" "+tc+" "+matrix[tr][tc]);
            if(matrix[tr][tc]==target){return true;}
            else if(matrix[tr][tc]>target){end=mid-1;}
            else{start=mid+1;}
        }
        return false;
    }
}
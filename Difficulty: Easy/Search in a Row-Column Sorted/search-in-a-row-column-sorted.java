class Solution {
    public static boolean matSearch(int mat[][], int x) {
        // your code here
        int i=0;
        int j=mat[0].length-1;
        while(i>=0&&i<mat.length&&j>=0&&j<mat[0].length)
        {
            //System.out.print(mat[i][j]+" ");
            if(mat[i][j]>x){j-=1;}
            else if(mat[i][j]<x){i+=1;}
            else{return true;}
        }
        return false;
    }
}

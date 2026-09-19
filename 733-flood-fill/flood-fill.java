class Solution {
    public void helper(int[][] grid, int sr, int sc,int or, int color){
        int r[]={0,1,0,-1};
        int c[]={1,0,-1,0};
        for(int i=0;i<4;++i)
        {
            int tr=sr+r[i];
            int tc=sc+c[i];
            if(tr>=0&&tr<grid.length&&tc>=0&&tc<grid[0].length&&grid[tr][tc]==or&&or!=color)
            {
                grid[tr][tc]=color;
                helper(grid,tr,tc,or,color);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        //if(image[sr][sc]==color){return image;}
        int or=image[sr][sc];
        image[sr][sc]=color;
        helper(image,sr,sc,or,color);
        return image;
    }
}
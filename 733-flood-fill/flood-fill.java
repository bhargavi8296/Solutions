class Solution {
    public void helper(int[][]image,int sr,int sc, int color,int co)
    {
        int r[]={0,1,0,-1};
        int c[]={1,0,-1,0};
        for(int i=0;i<4;++i)
        {
            int tr=r[i]+sr; int tc=c[i]+sc;
            if(tr>=0&&tr<image.length&&tc>=0&&tc<image[sr].length&&image[tr][tc]==co)
            {
                image[tr][tc]=color;
                helper(image,tr,tc,color,co);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int c=image[sr][sc];
        if(color!=c)
        {
            image[sr][sc]=color;
            helper(image,sr,sc,color,c);
        }
        return image;
    }
}
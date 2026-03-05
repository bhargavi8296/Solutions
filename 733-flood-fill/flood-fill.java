class Solution {
    public void helper(int[][] image, int sr, int sc, int color,int old)
    {
        int r[]={1,0,-1,0};
        int c[]={0,1,0,-1};
        for(int i=0;i<4;++i)
        {
            int tr=sr+r[i];int tc=sc+c[i];
            if(tr>=0&&tr<image.length&&tc>=0&&tc<image[0].length&&image[tr][tc]==old)
            {
                image[tr][tc]=color;
                helper(image,tr,tc,color,old);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        //System.out.print(image[sr][sc]+" "+color);
        if(image[sr][sc]==color){return image;}
        int old=image[sr][sc];
        image[sr][sc]=color;
        helper(image,sr,sc,color,old);
        return image;
    }
}
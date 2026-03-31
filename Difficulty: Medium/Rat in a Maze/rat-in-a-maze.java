class Solution {
    ArrayList<String>res;
    int visited[][];
    int[][]m;
    public void helper(int r,int c,String str)
    {
        if(r==m.length-1&&c==m.length-1)
        {
            res.add(str);return;
        }
        int ro[]={1,0,0,-1};
        int co[]={0,-1,1,0};
        char ch[]={'D','L','R','U'};
        for(int i=0;i<4;++i)
        {
            int tr=r+ro[i];
            int tc=c+co[i];
            if(tr>=0&&tc>=0&&tr<m.length&&tc<m[0].length&&visited[tr][tc]==0&&m[tr][tc]==1)
            {
                visited[tr][tc]=1;
                helper(tr,tc,str+ch[i]);
                visited[tr][tc]=0;
                
            }
        }
    }
    public ArrayList<String> ratInMaze(int[][] maze) {
        // code here
        res=new ArrayList<>();
        if(maze[0][0]==0||maze[maze.length-1][maze[0].length-1]==0){return res;}
        visited=new int[maze.length][maze[0].length];
        m=maze;
        visited[0][0]=1;
        helper(0,0,"");
        return res;
    }
}
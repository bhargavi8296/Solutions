class Solution {
    Stack<Integer>res=new Stack<>();
    ArrayList<ArrayList<Integer>>list;
    int vis[];
    public boolean dfs(int i)
    {
        for(int val:list.get(i))
        {
            //System.out.print(val+" "+vis[val]+" ");
            if(vis[val]==0)
            {
                vis[val]=1;
                if(!dfs(val)){return false;}
                vis[val]=2;
            }
            else if(vis[val]==1){ return false;}
        }
        res.push(i);
        return true;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        list=new ArrayList<>();
        vis=new int[numCourses];
        for(int i=0;i<numCourses;++i)
        {
            list.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;++i)
        {
            list.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        for(int i=0;i<numCourses;++i)
        {
            if(vis[i]==0)
            {
               // System.out.print(i+" "+vis[i]+" ");
                vis[i]=1;
                if(!dfs(i)){return new int[0];}
                vis[i]=2;
            }
        }
        
        int result[]=new int[res.size()];
        for(int i=0;i<result.length;++i)
        {
            int val=res.pop();
            System.out.print(val);
            result[i]=val;
        }
        return result;
    }
}
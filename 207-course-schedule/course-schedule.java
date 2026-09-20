class Solution {
    List<List<Integer>>list;
    int visited[];
    int pre[];
    public boolean helper(int i)
    {
        for(int val:list.get(i))
        {
            if(visited[val]==1){return true;}
            if(pre[val]==1){continue;}
            pre[val]=1;
            visited[val]=1;
            if(helper(val)){return true;}
            visited[val]=0;
        }
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        pre=new int[numCourses];
        list=new ArrayList<>();
        for(int i=0;i<numCourses;++i)
        {
            list.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;++i)
        {
            list.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        visited=new int[numCourses];
        for(int i=0;i<numCourses;++i)
        {
            //System.out.println(in[i]);
            if(visited[i]==0)
            {
                visited[i]=1;
                pre[i]=1;
                if(helper(i)){return false;}
                visited[i]=0;
            }
        }
        return true;

    }
}
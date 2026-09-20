class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int result[]=new int[numCourses];
        List<List<Integer>>list=new ArrayList<>();
        List<Integer>r=new ArrayList<>();
        int in[]=new int[numCourses];
        for(int i=0;i<numCourses;++i)
        {
            list.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;++i)
        {
            int f=prerequisites[i][0];
            int s=prerequisites[i][1];
            list.get(s).add(f);
            in[f]++;
        }
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<numCourses;++i)
        {
            if(in[i]==0){r.add(i);q.add(i);}
        }
        while(!q.isEmpty())
        {
            int t=q.poll();
            for(int val:list.get(t))
            {
                in[val]--;
                if(in[val]==0)
                {
                    q.add(val);
                    r.add(val);
                }
            }
        }
        if(r.size()<numCourses){return new int[0];}
        for(int i=0;i<numCourses;++i)
        {
            result[i]=r.get(i);
        }
        return result;
    }
}
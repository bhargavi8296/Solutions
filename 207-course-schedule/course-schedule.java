class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int in[]=new int[numCourses];
        ArrayList<ArrayList<Integer>>list=new ArrayList<>();
        for(int i=0;i<numCourses;++i){list.add(new ArrayList<>());}
        for(int i=0;i<prerequisites.length;++i)
        {
            int f=prerequisites[i][0];
            int s=prerequisites[i][1];
            list.get(s).add(f);
            in[f]++;
        }
        Queue<Integer>q=new LinkedList<>();
        int count=0;
        for(int i=0;i<numCourses;++i){
            if(in[i]==0){q.add(i);++count;}
        }
        while(!q.isEmpty())
        {
            int a=q.poll();
            for(int val:list.get(a))
            {
                in[val]--;
                if(in[val]==0){q.add(val);++count;}
            }
        }
        return count==numCourses;
    }
}
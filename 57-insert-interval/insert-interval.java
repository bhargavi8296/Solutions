class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<List<Integer>>list=new ArrayList<>();
        int start=newInterval[0];
        int end=newInterval[1];
        int i=0;
        boolean flag=false;
        while(i<intervals.length)
        {
            int s=intervals[i][0];
            int e=intervals[i][1];
            if(start<=e&&end>=s)
            {
                int temp=e;
                int j=i;
                while(j<intervals.length&&end>intervals[j][1])
                {
                    temp=intervals[j][0];
                    ++j;
                }
                List<Integer>t=new ArrayList<>();
                t.add(Math.min(start,s));
                temp=j<intervals.length?end<intervals[j][0]?end:intervals[j][1]:Math.max(temp,end);
                t.add(temp);
                list.add(t);
                i=j<intervals.length?end<intervals[j][0]?j-1:j:j;
                flag=true;
            }
            else{
                if(!flag&&start<e&&end<e)
                {
                    List<Integer>t1=new ArrayList<>();
                    t1.add(start);
                    t1.add(end);
                    list.add(t1);flag=true;
                }
                List<Integer>t=new ArrayList<>();
                t.add(s);
                t.add(e);
                list.add(t);
            }
            ++i;
        }
        if(!flag)
        {
            List<Integer>t=new ArrayList<>();
            t.add(start);
            t.add(end);
            list.add(t);
        }
        int result[][]=new int[list.size()][2];
        i=0;
        for(List<Integer>temp:list)
        {
            result[i][0]=temp.get(0);
            result[i][1]=temp.get(1);
            ++i;
        }
        return result;
    }
}
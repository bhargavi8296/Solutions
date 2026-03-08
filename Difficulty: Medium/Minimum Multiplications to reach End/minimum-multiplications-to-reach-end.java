// User function Template for Java

class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {

        // Your code here
        Set<Integer>set=new HashSet<>();
        Queue<int[]>q=new LinkedList<>();
        q.add(new int[]{start,0});
        while(!q.isEmpty())
        {
            int []p=q.poll();
            int s=p[0];
            int d=p[1];
            if(s==end){return d;}
            for(int i=0;i<arr.length;++i)
            {
                int val=(s*arr[i])%100000;
                if(!set.contains(val))
                {
                    set.add(val);
                    q.add(new int[]{val,d+1});
                }
            }
        }
        return -1;
        
    }
}

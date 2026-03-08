// User function Template for Java

class Solution {
    public int[] bellmanFord(int V, int[][] edges, int src) {
        // code here
        int result[]=new int[V];
        Arrays.fill(result,100000000);
        result[src]=0;
        for(int i=0;i<V-1;++i)
        {
            for(int j=0;j<edges.length;++j)
            {
                int f=edges[j][0];
                int s=edges[j][1];
                int d=edges[j][2];
                if(result[f] != 100000000 &&result[f]+d<result[s])
                {
                    result[s]=d+result[f];
                }
            }
        }
        for(int j=0;j<edges.length;++j)
            {
                int f=edges[j][0];
                int s=edges[j][1];
                int d=edges[j][2];
                if(result[f] != 100000000 &&result[f]+d<result[s])
                {
                    return new int[]{-1};
                }
            }
            return result;
    }
}

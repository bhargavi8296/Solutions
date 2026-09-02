class Solution {
    public int helper(int heights[])
    {
        int left[]=new int[heights.length];
        int right[]=new int[heights.length];
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<heights.length;++i)
        {
            while(!st.isEmpty()&&heights[i]<=heights[st.peek()]){st.pop();}
            if(st.isEmpty()){
                left[i]=-1;
            }
            else{
                left[i]=st.peek();
            }
            st.push(i);
        }
        st.clear();
        for(int i=heights.length-1;i>=0;--i)
        {
            while(!st.isEmpty()&&heights[i]<=heights[st.peek()]){st.pop();}
            if(st.isEmpty()){
                right[i]=heights.length;
            }
            else{
                right[i]=st.peek();
            }
            st.push(i);
        }
        int max=0;
        for(int i=0;i<heights.length;++i)
        {
            max=Math.max(max,(right[i]-left[i]-1)*heights[i]);
        }
        return max;
    }
    public int maximalRectangle(char[][] matrix) {
        int arr[]=new int[matrix[0].length];
        int max=0;
        for(int i=0;i<matrix.length;++i)
        {
            for(int j=0;j<matrix[i].length;++j)
            {
                if(matrix[i][j]=='0')
                {
                    arr[j]=0;
                }
                else{
                    arr[j]+=1;
                }
            }
            int temp=helper(arr);
            max=Math.max(max,temp);
        }
        return max;
    }
}
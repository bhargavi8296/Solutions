class Solution {
    public int trap(int[] height) {
        Stack<Integer>st=new Stack<>();
        int res[]=new int[height.length];
        for(int i=0;i<height.length;++i)
        {
            while(!st.isEmpty()&&st.peek()<=height[i]){st.pop();}
            if(st.isEmpty())
            {
                res[i]=height[i];
                st.push(height[i]);
            }
            else{
                res[i]=st.peek();
            }
            //System.out.println(res[i]);
        }
        st.clear();
        for(int i=height.length-1;i>=0;--i)
        {
             while(!st.isEmpty()&&st.peek()<=height[i]){st.pop();}
            if(st.isEmpty())
            {
               // System.out.println(i+"."+res[i]+" "+height[i]);
                res[i]=Math.min(res[i],height[i]);
                st.push(height[i]);
            }
            else{
                res[i]=Math.min(st.peek(),res[i]);
            }
        }
        int sum=0;
        for(int i=0;i<height.length;++i)
        {
            //System.out.println(height[i]+" "+res[i]);
            sum+=(res[i]-height[i]);
        }
        return sum;
    }
}
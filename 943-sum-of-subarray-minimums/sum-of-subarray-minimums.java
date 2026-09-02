class Solution {
    public int sumSubarrayMins(int[] arr) {
        int left[]=new int[arr.length];
        int right[]=new int[arr.length];
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<arr.length;++i)
        {
            while(!st.isEmpty()&&arr[st.peek()]>=arr[i]){st.pop();}
            if(st.isEmpty()){left[i]=-1;}
            else{
                left[i]=st.peek();
            }
            st.push(i);
        }
        st.clear();
        for(int i=arr.length-1;i>=0;--i)
        {
            while(!st.isEmpty()&&arr[st.peek()]>arr[i]){st.pop();}
            if(st.isEmpty()){right[i]=arr.length;}
            else{
                right[i]=st.peek();
            }
            st.push(i);
        }
        int sum=0;
        for(int i=0;i<arr.length;++i)
        {
            //System.out.println(left[i]+" "+right[i]);
            int l=i-left[i];
            int r=right[i]-i;
            int res=(int)((long)l*r)%1000000007;
            sum=(int)((sum+(((long)res*arr[i])%1000000007))%1000000007);
            //System.out.println(res);
        }
        return sum;
    }
}
class Solution {
    public int helper(int[]arr)
    {
        int pre[]=new int[arr.length];
        int post[]=new int[arr.length];
        Stack<Integer>s1=new Stack<>();
        Stack<Integer>s2=new Stack<>();
        for(int i=0;i<arr.length;++i)
        {
            
            while(!s1.isEmpty()&&arr[s1.peek()]>=arr[i]){s1.pop();}
            if(s1.isEmpty()){pre[i]=-1;}
            else{pre[i]=s1.peek();}
            s1.push(i);
            int n=arr.length-1-i;
            while(!s2.isEmpty()&&arr[s2.peek()]>=arr[n]){s2.pop();}
            if(s2.isEmpty()){post[n]=arr.length;}
            else{post[n]=s2.peek();}
            s2.push(n);
            //System.out.println(s1+" "+s2);
        }
        int result=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;++i)
        {
            int temp=post[i]-pre[i]-1;
            //System.out.println(post[i]+" "+pre[i]+" "+arr[i]+" "+temp);
            result=Math.max(result,arr[i]*temp);
        }
        //System.out.println(result+" ");
        //System.out.println(); 
        return result;
    }
    public int maximalRectangle(char[][] matrix) {
        int arr[]=new int[matrix[0].length];
        int result=Integer.MIN_VALUE;
        for(int i=0;i<matrix.length;++i)
        {
            for(int j=0;j<matrix[i].length;++j)
            {
                if(matrix[i][j]!='0')
                {
                    if(i!=0){arr[j]+=1;}
                    else{arr[j]=1;}
                }
                else{
                    arr[j]=0;
                }
                //System.out.println(arr[j]);
            }
            result=Math.max(result,helper(arr));
            //System.out.print(result);
        }
        return result;
    }
}
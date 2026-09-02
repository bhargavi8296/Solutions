class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer>st=new Stack<>();
        for(int i=asteroids.length-1;i>=0;--i)
        {
            boolean flag=false;
            while(!st.isEmpty()&&asteroids[i]>0&&st.peek()<0&&Math.abs(asteroids[i])>=Math.abs(st.peek()))
            {
                int temp=st.pop();
                // System.out.println(flag);
                if(Math.abs(temp)==asteroids[i]){flag=true;break;}
            }
            if(!flag&&(st.isEmpty()||asteroids[i]<0||st.peek()>0)){st.push(asteroids[i]);}
            
        }
        int result[]=new int[st.size()];
        for(int i=0;i<result.length;++i)
        {
            result[i]=st.pop();
        }
        return result;
    }
}
class Solution {
    public int totalFruit(int[] fruits) {
        int i=0;
        int result=0;
        while(i<fruits.length)
        {
            //System.out.println(i);
            int first=fruits[i];
            int count=1;
            int second=-1;
            int count1=0;
            int j=i+1;
            int f=i;
            int s=j;
            while(j<fruits.length)
            {
                //System.out.println(j+"."+first+" "+second+" "+count+" "+count1);
                if(fruits[j]==first){++count;f=j;}
                else if(second==-1||second==fruits[j]){second=fruits[j];++count1;s=j;}
                else{break;}  
                ++j;
            }
            result=Math.max(result,count+count1);
            i=Math.min(f,s)+1;
        }
        return result;
    }
}
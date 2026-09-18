class Solution {
    public int reverse(int x) {
        String str=x+"";
        int flag=1;
        int i=0;
        if(str.charAt(i)=='-'||str.charAt(i)=='+')
        {
            if(str.charAt(i)=='-'){
                flag=-1;
            }
            ++i;
        }
        long result=0;
        int j=str.length()-1;
        while(j>=i)
        {
            result=result*10+(str.charAt(j)-'0');
            if(result*flag>Integer.MAX_VALUE){return 0;}
            if(result*flag<Integer.MIN_VALUE){return 0;}
            --j;
        }
        return (int)(result*flag);
    }
}
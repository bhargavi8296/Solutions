class Solution {
    public boolean lemonadeChange(int[] bills) {
        int total=0;
        int f=0;
        int t=0;
        for(int i=0;i<bills.length;++i)
        {
            if(bills[i]==5){f+=1;}
            else if(bills[i]==10)
            {
                if(f>=1){f-=1;t+=1;}
                else{return false;}
            }
            else{
                if(t>=1&&f>=1){t-=1;f-=1;}
                else if(f>=3){f-=3;}
                else{return false;}
            }
        }
        return true;
    }
}
class Solution {
    public boolean lemonadeChange(int[] bills) {
    //   Arrays.sort(bills);
       int arr[]=new int[5];
       for(int i=0;i<bills.length;++i)
       {
            if(bills[i]!=5){
                int temp=bills[i]-5;
                if(temp==15)
                {
                    if(arr[2]>=1&&arr[1]>=1){arr[2]-=1;arr[1]-=1;}
                    else if(arr[1]>=3){arr[1]-=3;}
                    else{return false;}
                }
                else if(temp==5)
                {
                    if(arr[1]>=1){arr[1]-=1;}
                    else{return false;}
                }
            }
            arr[bills[i]/5]++;
       } 
       return true;
    }
}
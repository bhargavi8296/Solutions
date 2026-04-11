class Solution {
    public boolean lemonadeChange(int[] bills) {
    //   Arrays.sort(bills);
       Map<Integer,Integer>map=new HashMap<>();
       for(int i=0;i<bills.length;++i)
       {
            if(bills[i]!=5){
                int temp=bills[i]-5;
                if(temp==15)
                {
                    if(map.containsKey(10)&&map.containsKey(5)&&map.get(10)>=1&&map.get(5)>=1){map.put(10,map.get(10)-1);map.put(5,map.get(5)-1);}
                    else if(map.containsKey(5)&&map.get(5)>=3){map.put(5,map.get(5)-3);}
                    else{return false;}
                }
                else if(temp==5)
                {
                    if(map.containsKey(5)&&map.get(5)>=1){map.put(5,map.get(5)-1);}
                    else{return false;}
                }
            }
            map.put(bills[i],map.getOrDefault(bills[i],0)+1);
       } 
       return true;
    }
}
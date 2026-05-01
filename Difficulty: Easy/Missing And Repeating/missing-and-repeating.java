class Solution {
    ArrayList<Integer> findTwoElement(int arr[]) {
        // code here
        ArrayList<Integer>list=new ArrayList<>();
        int result=0;
        for(int i=1;i<=arr.length;++i)
        {
            result^=arr[i-1];
            result^=i;
        }
        
        int x=result&(~(result-1));
        int first=0;
        int second=0;
        for(int i=1;i<=arr.length;++i)
        {
            if((x&arr[i-1])!=0){first^=arr[i-1];}
            else{second^=arr[i-1];}
            if((x&i)!=0){first^=i;}
            else{second^=i;}
        }
        for(int val:arr){
            if(val==first){list.add(first);break;}
        }
        if(!list.isEmpty()){list.add(second);}
        else{list.add(second);list.add(first);}
        return list;
    }
}


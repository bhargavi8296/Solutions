class Solution {
    public String addBinary(String a, String b) {
       int i=a.length()-1;int j=b.length()-1;
       int carry=0;
       String str="";
       while(i>=0&&j>=0)
       {
        int ta=a.charAt(i)=='0'?0:1;
        int tb=b.charAt(j)=='0'?0:1;
        int temp=(ta^tb)^carry;
        if(((ta==1)&&(tb==1))||((tb==1)&&(carry==1))||((carry==1)&&(ta==1))){carry=1;}
        else{carry=0;}
           str=temp+str;--i;--j;
       }
       while(i>=0)
       {
            int ta=a.charAt(i)=='0'?0:1;
            int temp=ta^carry;
            if((ta==1)&&(carry==1)){carry=1;}
            else{carry=0;}
            str=temp+str;
            --i;
       }
       while(j>=0)
       {
            int tb=b.charAt(j)=='0'?0:1;
            int temp=tb^carry;
            if((tb==1)&&(carry==1)){carry=1;}
            else{carry=0;}
            str=temp+str;
            --j;
       }
       if(carry==1){str=1+str;}
        return str;
    }
}
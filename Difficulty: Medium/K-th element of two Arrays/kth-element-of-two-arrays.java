class Solution {
    public int kthElement(int a[], int b[], int k) {
        // code here
        int i=0;
        int j=0;
        int val=-1;
        while(i<a.length&&j<b.length)
        {
            if(a[i]<=b[j])
            {
                val=a[i];++i;
            }
            else{val=b[j];++j;}
            --k;if(k==0){break;}
        }
        while(k>0&&i<a.length)
        {
            val=a[i];++i;--k;
        }
        while(k>0&&j<b.length)
        {
            val=b[j];++j;--k;
        }
        return val;
        
    }
}
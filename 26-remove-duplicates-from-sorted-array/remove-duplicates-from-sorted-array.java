class Solution {
    public int removeDuplicates(int[] arr) {
        int i=0;
        int j=i+1;
        while(i<arr.length)
        {
            while(j<arr.length&&arr[i]==arr[j])
            {
                ++j;
            }
            if(j<arr.length&&i+1<j)
            {
                arr[i+1]=arr[j];
            }
            if(j>=arr.length){break;}
            ++i;
        }
        return i+1;

    }
}
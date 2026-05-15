class Solution {
    static void rotateArr(int arr[], int d) {
        // code here
        d=d%arr.length;
        int temp[]=new int[arr.length];
        for(int i=0;i<arr.length;++i)
        {
            temp[i]=arr[(i+d)%arr.length];
          //  System.out.print(temp[i]);
        }
        for(int i=0;i<arr.length;++i)
        {
            arr[i]=temp[i];
          //  System.out.print(temp[i]);
        }
        
    }
}
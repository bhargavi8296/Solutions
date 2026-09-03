class Solution {
    public int lengthOfLongestSubstring(String s) {
        int arr[]=new int[256];
        int i=0;
        int j=0;
        int max=0;
        while(i<s.length())
        {
            while(j<s.length()&&arr[s.charAt(j)]+1<2)
            {
                arr[s.charAt(j)]++;++j;
            }
            //System.out.println(j+" "+i);
            max=Math.max(max,j-i);
            if(j>=s.length()){break;}
            while(i<j&&s.charAt(i)!=s.charAt(j))
            {
                arr[s.charAt(i)]--;
                ++i;
            }
            arr[s.charAt(i)]--;
            ++i;
        }
        return max;
    }
}
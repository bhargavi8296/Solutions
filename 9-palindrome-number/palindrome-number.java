class Solution {
    public boolean isPalindrome(int x) {
        if(x<0){return false;}
        int temp=0;
        int t=x;
        while(x>0)
        {
            temp=(x%10)+temp*10;
            x=(x-(x%10))/10;
        }
        return temp==t;
    }
}
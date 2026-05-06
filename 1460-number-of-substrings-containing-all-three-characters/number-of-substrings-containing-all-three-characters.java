class Solution {
    public int numberOfSubstrings(String s) {
        boolean a=false;
        boolean b=false;
        boolean c=false;
        int i=0;
        int j=0;
        int result=0;
        int ar[]=new int[3];
        while(j<s.length())
        {
            //System.out.print(i+" ");
            char ch=s.charAt(j);
            ar[ch-'a']++;
            switch(ch)
            {
                case 'a': a=true;break;
                case 'b': b=true;break;
                case 'c': c=true;break;
            }
            if(a&&b&&c)
            {
                int temp=(s.length()-j-1)+1;
                result+=(temp);
                while(i<s.length()&&i<=j&&a&&b&&c)
                {
                    char r=s.charAt(i);++i;
                    ar[r-'a']--;
                    if(ar[r-'a']==0)
                    {
                        switch(r)
                        {
                            case 'a': a=false;break;
                            case 'b': b=false;break;
                            case 'c': c=false;break;
                        }
                        break;
                    }
                    result+=temp;
                }
            }++j;
        }
        return result;
    }
}
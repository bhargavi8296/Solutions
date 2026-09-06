class Solution {
    public String countAndSay(int n) {
        String str="1";
        if(n==1){return str;}
        --n;
        while(n>0)
        {
            //System.out.println(str);
            int i=0;
            int j=i+1;
            int count=1;
            StringBuilder temp=new StringBuilder();
            while(j<str.length())
            {
                while(j<str.length()&&str.charAt(j)==str.charAt(i))
                {
                    ++count;++j;
                }
                temp.append(count).append(str.charAt(i));
                i=j;
                ++j;
                count=1;
            }
            if(i<str.length()){
                temp.append(count).append(str.charAt(i));
            }
            str=temp.toString();
            --n;
        }
        return str;
    }
}
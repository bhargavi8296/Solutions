class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        List<String>list=new ArrayList<>();
        int i=0;
        int len=s.length();
        while(i<s.length())
        {
            while(i<s.length()&&s.charAt(i)=='0'){++i;}
            int count=0;
            if(i<s.length()&&s.charAt(i)=='1'){++count;}
            int j=i+1;
            while(j<s.length()&&count<k)
            {
                if(s.charAt(j)=='1'){++count;}
                ++j;
            }
            //System.out.println(count+" "+i+" "+j);
            if(count==k)
            {
                if((j-i)==len){list.add(s.substring(i,j));}
                else if((j-i)<len){list.clear();list.add(s.substring(i,j));len=(j-i);}
            }
            ++i;
        }
        Collections.sort(list);
        //System.out.print(list);
        return list.isEmpty()==true?"":list.get(0);
    }
}
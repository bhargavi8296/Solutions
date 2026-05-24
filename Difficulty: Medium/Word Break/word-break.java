// class Solution {
//     Set<String>set;
//     int dp[];
//     public boolean helper(String s, int i)
//     {
//         if(i>=s.length()){return true;}
//         String str="";
//         if(dp[i]!=-1){return dp[i]==1?true:false;}
//         for(int j=i;j<s.length();++j)
//         {
//             str+=s.charAt(j);
//             if(set.contains(str))
//             {
//                 if(helper(s,j+1))
//                 {
//                     dp[j]=1;
//                     return true;
//                 }
//             }
//         }
//         dp[i]=0;
//         return false;
//     }
//     public boolean wordBreak(String s, String[] dictionary) {
//         // code here
//         set=new HashSet<>();
//         for(String val:dictionary)
//         {
//             set.add(val);
//         }
//         dp=new int[s.length()+1];
//         Arrays.fill(dp,-1);
//         return helper(s,0);
//     }
// }
class Solution {

    HashSet<String> set;
    int dp[];
    int maxLen = 0;

    public boolean helper(String s, int i) {

        if(i == s.length()) {
            return true;
        }

        if(dp[i] != -1) {
            return dp[i] == 1;
        }

        for(int j = i;
            j < Math.min(s.length(), i + maxLen);
            j++) {

            if(set.contains(s.substring(i, j + 1))) {

                if(helper(s, j + 1)) {

                    dp[i] = 1;
                    return true;
                }
            }
        }

        dp[i] = 0;
        return false;
    }

    public boolean wordBreak(String s,
                             String[] dictionary) {

        set = new HashSet<>();

        for(String word : dictionary) {

            set.add(word);

            maxLen = Math.max(maxLen,
                              word.length());
        }

        dp = new int[s.length()];

        Arrays.fill(dp, -1);

        return helper(s, 0);
    }
}
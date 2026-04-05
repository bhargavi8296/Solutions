// User function Template for Java

class Solution {
    // You must implement this function
    static void sieve() {}

    static List<Integer> findPrimeFactors(int N) {
        // code here
         int[] spf = new int[N+1];

    // initialize
    for(int i=1;i<=N;i++) spf[i]=i;

    // sieve
    for(int i=2;i*i<=N;i++) {
        if(spf[i]==i) {
            for(int j=i*i;j<=N;j+=i) {
                if(spf[j]==j) {
                    spf[j]=i;
                }
            }
        }
    }

    // factorization
    List<Integer> res = new ArrayList<>();

    while(N > 1) {
        res.add(spf[N]);
        N = N / spf[N];
    }

    return res;
    }
}

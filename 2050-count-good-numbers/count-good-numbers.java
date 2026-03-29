class Solution {
    static final int MOD = 1000000007;

    public int countGoodNumbers(long chakraLength) {
        if(chakraLength==1){return 5;}
        long evenPositions = (chakraLength + 1) / 2; // like left side of scroll
        long oddPositions = chakraLength / 2;        // right side of scroll
        long evenWays = fastPower(5, evenPositions); // 5 even digits
        long oddWays = fastPower(4, oddPositions);   // 4 prime digits

        return (int)((evenWays * oddWays) % MOD);
    }

    // Chakra Power Boost: Fast Exponentiation
    long fastPower(long base, long power) {
        if(power==0){return 1;}
        if(power%2==0)
        {
            return fastPower((base*base)%MOD,power/2);
        }
        return (base*fastPower((base*base)%MOD,power/2))%MOD;
    }
}
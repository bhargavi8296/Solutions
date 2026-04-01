class CheckBit {
    static boolean checkKthBit(int n, int k) {
        // code here
        //System.out.print((1<<k)&n);
        return (n&(1<<k))>=1;
    }
}
public class ClearRangeBits {
    public static void main(String args[]){
        System.out.println(clearRangeBits(31, 1, 3));

    }

    public static int clearRangeBits(int n, int i,int j){
        int jBitMask = (~0)<<j+1;
        int iBitMask = (1<<i)-1;
        int bitMask = jBitMask | iBitMask;
        return n & bitMask;

    }
}

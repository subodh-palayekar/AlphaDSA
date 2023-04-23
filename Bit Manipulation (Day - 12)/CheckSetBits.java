public class CheckSetBits {
    public static void main(String[] args) {
        System.out.println(checkSetbits(15));
    }

    public static int checkSetbits(int n){
        int count =0;
        while(n>0){
            if((n & 1)!=0){
                count++;
            }
            n=n>>1;
        }
        return count;
    }
}

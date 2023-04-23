public class FastExponential {
    public static void main(String[] args) {
        System.out.println(fastExpo(3, 5));
    }

    public static int fastExpo (int base, int power){
        int ans =1 ;
        while(power>0){
            if((power & 1)!=0){
                ans = ans *base;
            }
            base= base*base;
            power=power>>1;
        }
        return ans;
    }
}

public class PowerOfTwo {
    public static void main(String[] args) {
        System.out.println(powerOfTwo(15));
    }
    public static boolean powerOfTwo(int n){
        return (n& (n-1))==0;
    }
}

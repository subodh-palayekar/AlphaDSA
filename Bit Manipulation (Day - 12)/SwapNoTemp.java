public class SwapNoTemp{
    public static void main(String[] args) {
        
        swapNoTempUse(3, 5);
    }

    public static void swapNoTempUse (int a, int b){
        a=a ^ b;
        b=a ^ b;
        a=a ^ b;
        System.out.println(a+" "+b);
    }
}
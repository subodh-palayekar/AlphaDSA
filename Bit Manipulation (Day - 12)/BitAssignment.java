public class BitAssignment {
    public static void main(String[] args) {
        // add();
        // toLowerCase();
        // swapNoTempUse(4, 10);
        // System.out.println((int)' ');
        // System.out.println((int)'A');
        System.out.println(66 | 32);
    }


    // Question 1 : Swap to number without using temporary variable 
    public static void swapNoTempUse (int a, int b){
        a=a ^ b;
        b=a ^ b;
        a=a ^ b;
        System.out.println(a+" "+b);
    }
    // Question 3 : perform addition of 1 to the number  using bitManipulation

    public static void add( ){
    // addition using bits
        // -x = ~x + 1 --> -~x = x + 1
        int x=5;
        System.out.println( x+" + "+1+" = "+ (-~x) );
        int y=0;
        System.out.println( y+" + "+1+" = "+ (-~y) );
    }

    // Question 4 : convert upperCase to lowerCase
    public static void toLowerCase(){
        for(int ch='A'; ch<='Z' ; ch++){
            
            System.out.print((char)(ch|' '));
        }
    }



}

public class BitManipulation{
    public static void main(String[] args) {
    //   evenOdd(19);  
      
    //   System.out.println(getIBit(10,2));
    //   System.out.println(setIBit(10, 2));
    //   System.out.println(clearIBit(7, 2));
      System.out.println(updateIBit(7, 1, 0));
    }

    // Even Odd
    public static void evenOdd(int n){
        int bitMask = 1;
        if((n & bitMask)==1){
            System.out.println("Number is odd");
        }else{
            System.out.println("Number is even");
        }
    }

    // Get ith Bit

    public static int getIBit(int n,int i){
        int bitMask = 1<<i;
        if((n & bitMask)==0){
            return 0;
        }else{
            return 1;
        }
        
    }

    // Set ith Bit

    public static int setIBit(int n , int i){
        int bitMask = 1<<i;
        return n | bitMask;
    }  

    // Clear ith Bit

    public static int clearIBit(int n ,int i){
        int bitMask = ~(1<<i);

        return n & bitMask;
    }

    // update ith Bit

    public static int updateIBit (int n , int i , int newBit){

        // clear that bit
        n = n & ~(1<<i);
        
        // updating bit
        n = n | (newBit<<i);

        return n;
    }
}
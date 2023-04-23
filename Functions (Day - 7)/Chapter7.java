public class Chapter7 {
    public static void main(String args[]){

        // System.out.println(product(3, 3));
        // System.out.println(factorial(5));
        // System.out.println(binCoeff(5, 2));
        System.out.println(isPrime(99));
        rangePrime(100);
        // BinToDec(1011);
        // DecToBin(10);

    }
    // product of two numbers
    public static int product ( int a,int b){
        return a*b;
    }

    // Factorial of number
    public static int factorial(int a){
        int fact=1;
        while(a>0){
            
             fact= fact*a;
             a--;

        }
        return fact;
    }


    // Binomial Coefficient
    public static int binCoeff(int n,int r){
        int nFact= factorial(n);
        int rFact= factorial(r);
        int nmr= factorial(n-r);
        int biCof= nFact/(rFact*nmr);
        return biCof;

    }

    //Function overloading

    public static int sum (int a,int b){
        return a+b;
    }
    public static int sum (int a,int b,int c){
        return a+b+c;
    }
    public static float sum(float a, float b){
        return a+b;
    }

    //Check Prime of not

    public static boolean isPrime (int n){
        if(n==2){
            return true;
        }

        for (int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }

    // prime in Range

    public static void rangePrime(int n){
        for(int i=2;i<=n;i++){
            if(isPrime(i)==true){
                System.out.print(i+" ");
            }
        }
        System.out.println();
    }

    //Binar to Decimal

    public static void BinToDec(int n) {
        int myNum = n;
        int last;
        int pow=0;
        int dec=0;
        while(n>0){
            last=n%10;
            dec= dec + last*(int)(Math.pow(2, pow));
            pow++;
            n=n/10;
        }
        System.out.println("The Decimal value of binary "+myNum+" is "+dec);
    }

    // Decimal to Binary

    public static void DecToBin (int n){
        int myNum=n;
        int rem;
        int bin=0;
        int pow=0;

        while(n>0){
            rem=n%2;
            bin = bin + rem*(int)(Math.pow(10, pow));
            pow++;
            n=n/2;
        }
        System.out.println("The binary value of decimal "+myNum+" is "+bin);
    }
    





}

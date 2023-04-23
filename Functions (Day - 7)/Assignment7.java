public class Assignment7{

    public static void main(String[] args) {
        // int ans = avg(2,4,6);
        // System.out.println(ans);
        // System.out.println(isEven(7));

        // System.out.println(isPal(121));
        // System.out.println(sumDigits(1213));

        mathFuncs();
    }

    // Average of 3 numbers
    public static int avg (int a,int b,int c){
        int sum = a+b+c;
        return sum/3;
    }

    // Number is Even or odd

    public static boolean isEven(int n){
        if(n%2==0){
            return true;
        } 
        return false;
    }

    // Number is Palindrome or Not 


    // Writing helper function to reverse the number

    public static int reverse (int n){
        int last;
        int rev=0;
        while(n>0){
            last=n%10;
            rev=rev*10+last;
            n=n/10;
        }
        return rev;
    }


    public static boolean isPal (int n){
        int revNum=reverse(n);
        System.out.println(revNum);
        if(n==revNum){
            return true;
        }
        return false;
    }

    // Sum of digits of integer

    public static int sumDigits(int n){
        int last;
        int sum=0;
        while(n>0){
            last=n%10;
            sum=sum+last;
            n=n/10;
        }
        return sum;


    }

    // Math class functions

    public static void mathFuncs(){

        // Math.min
        System.out.println("Min number is "+ Math.min(37, 43));

        // Math.max
        System.out.println("Max number is " + Math.max(+37, 43));

        // Math.sqrt
        System.out.println("Square root of number is " + Math.sqrt(196));

        // Math.pow
        System.out.println("value of base a power b is " + Math.pow(12, 3));

        // Math.avg
        System.out.println("Absolute value of number is " + Math.abs(-43));

    }
}
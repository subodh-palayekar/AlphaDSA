import java.util.Scanner;

public class Assignment5{
  public static void main(String[] args) {
    
    // Question Number (2)

    Scanner sc = new Scanner (System.in);

    // int c ;
    // int evenSum=0;
    // int oddSum=0;
    // int choice;
    

    // do{

    //     System.out.println("Enter a Number");
    //      c = sc.nextInt();

    //     if(c%2==0){
    //         evenSum=evenSum+c;
    //     }else{
    //         oddSum=oddSum+c;
    //     }

    //     System.out.println("Type 1 to continue and 0 to stop");
    //     choice=sc.nextInt();
    // }while(choice==1);

    // System.out.println("Sum of Even numbers " + evenSum);
    // System.out.println("Sum of Odd numbers " + oddSum);

    // ------------------------------------------------------------------------------------------------------

    // int n = sc.nextInt();
    // int sumEven=0 ,sumOdd=0;   
    // for(int i=1;i<=n;i++){

    //     if(i%2==0){
    //         sumEven+=i;
    //     }else{
    //         sumOdd+=i;
    //     }
    // }
    // System.out.println("Sum of Even Numbers " + sumEven);
    // System.out.println("Sum of Odd Numbers " + sumOdd);
   
    // ------------------------------------------------------------------------------------------------------
    
    // Question Number (3) Factorial of a Number
     
    int a = sc.nextInt();
    int factorial = 1;

    while(a>1){
        factorial*=a;
        a--;
    }
    System.out.println("Factorial of a number is " + factorial);

    // ------------------------------------------------------------------------------------------------------
    // Question Number (4) Table of a Number

    // int b = sc.nextInt();
    // for(int i=1;i<=10;i++){
    //     System.out.println(b*i);
    // }

   

  }
}
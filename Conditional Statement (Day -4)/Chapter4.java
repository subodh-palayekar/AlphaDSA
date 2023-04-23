import java.util.Scanner;

public class Chapter4 {
    public static void main(String args[]){

        // Question Number: 1

        Scanner sc = new Scanner(System.in);
        // int number = sc.nextInt();

        // if(number>0){
        //     System.out.println("number is positive");
        // }
        // else{
        //     System.out.println("number is negative");
        // }
        
        // -----------------------------------------------------------------------------------------------------------------------------    

        // Question Number: 2

        // double temp = 103.5;

        // if(temp>100){
        //     System.out.println("You have a fever");
        // }
        // else{
        //     System.out.println("You dont have fever");
        // }
        
        // -----------------------------------------------------------------------------------------------------------------------------    

        // Question Number: 3
        System.out.println("Enter a week number between 1 to 7");
        int Day = sc.nextInt();

        switch(Day){
            case 1: System.out.println("Sunday");
            break;
            case 2: System.out.println("Monday");
            break;
            case 3: System.out.println("Tuesday");
            break;
            case 4: System.out.println("Wednesday");
            break;
            case 5: System.out.println("Thusday");
            break;
            case 6: System.out.println("Friday");
            break;
            case 7: System.out.println("Saturday");
            break;
            default : System.out.println("Invalid Input! Please enter number between 1-7"); 

        }

        // -----------------------------------------------------------------------------------------------------------------------------    

        // Question Number: 5

        // System.out.println("Enter a year");
        // int year = sc.nextInt();

        // if((year%4==0) && (year%100!=0)){
        //   System.out.println(year + ":  is leap year ");
        // }
        // else if((year%4==0) && (year%100==0) && (year%400==0)){
        //   System.out.println(year + ":  is leap year ");
        // }
        // else{
        //   System.out.println(year + ":  is not a leap year "); 
        // }

        // Alternate approach

        // boolean condition1 = (year % 4==0);
        // boolean condition2 = (year % 100!=0);
        // boolean condition3 = (year % 100==0)  && (year % 400 ==0);

        // if(condition1 && (condition2 || condition3)){
        //     System.out.println(year + ":  is leap year ");
        // }
        // else{
        //     System.out.println(year + ":  is not a  leap year ");
        // }
        
    }
}

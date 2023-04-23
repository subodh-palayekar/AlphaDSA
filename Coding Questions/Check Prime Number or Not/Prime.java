import java.util.*;
public class Prime{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num= sc.nextInt();
       boolean isPrime = true;

       if(num==2){
        System.out.println("Is prime"); 
       }
       else{
        for(int i=2;i<Math.sqrt(num);i++){
            if(num%i==0){
            isPrime=false;
            }
        }
        if(isPrime){
            System.out.println("Is prime"); 
         }else{
             System.out.println("not prime");
         }
       }
       
        
    }
}
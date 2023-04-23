import java.util.*;


public class ReverseNum{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        
        int lastNum = 0;
        int reverse = 0;

        while(num>0){
            lastNum=num%10;
            reverse=reverse*10 + lastNum;
            num=num/10;
        }
        System.out.println(reverse);


    }
}
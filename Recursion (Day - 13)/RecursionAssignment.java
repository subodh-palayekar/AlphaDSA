import java.util.Arrays;

import javax.security.auth.Subject;

public class RecursionAssignment {
    public static void main(String[] args) {
        int arr[] = {3, 2, 4, 5, 6, 2, 7, 2, 2};
        // allOccurence(arr, 2, 0);

        // numberToEnglish(2019);

        // System.out.println(stringLength("subodh"));
        // System.out.println(countSubStrings("abcab", 0, 0));
        tower(64, "A", "B", "C");

       
        
        

    }

    // print all occurence of element in array

    public static void allOccurence(int arr[],int key,int index){
        if(index==arr.length){
            return;
        }
        if(arr[index]==key){
            System.out.print(index+" ");
        }
        allOccurence(arr, key, index+1);
    }

    // You are given a number (eg -  2019), convert it into a String of english like “two zero one nine”.
    public static void numberToEnglish (int number){
       
        String arr[] = {"zero","one","two","three","four","five","six","seven","eight","nine"};

        if(number==0){
            return;
        }

        int lastDigit = number%10;
        numberToEnglish(number/10);
        System.out.print(arr[lastDigit]+" ");
    }

    // Write a program to findLength of aStringusing Recursion.

    public static int stringLength(String str){
      if(str.length()==0){
        return 0;
      }
      return stringLength(str.substring(1))+1;
    }

    //count of all contiguous substrings starting and ending with the same character

    public static int countSubStrings(String str,int start,int end){
        if(str.length()==0){
            return 0;
        }

        if(end==str.length()){
            return countSubStrings(str.substring(1), 0,0);
        }
        if(str.charAt(start)==str.charAt(end)){
            return countSubStrings(str, start, end+1) + 1;
        }else{
            return countSubStrings(str, start, end+1);
        }
        
    
    }

    // Tower of Hanoi
    public static void tower(int n,String source,String helper,String destination){
        if(n==1){
            System.out.println("Shift " + n + " from " + source + " to "+ destination);
            return;
        }
        tower(n-1, source, destination, helper);
        System.out.println("Shift " + n + " from " + source + " to "+ destination);
        tower(n-1, helper, source, destination);

    }
}

import java.util.*;

public class StringAssignment{
    public static void main(String[] args) {
       

        // System.out.println(countLower());

        // System.out.println(anagrams("race", "carE"));
        isAnagrams("race", "carE");

    }


    // Question 1 : Count how many times lowercase vowels occurred in a String entered by the user.

    public static int countLower(){
        System.out.println("Enter a String");
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int count=0;
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
                count++;
            } 
        }
        return count;
    }

    // Question 2: Determine if 2 Strings are anagrams of each other

    // BruteForce approach O(n^2)
    public static boolean anagrams (String str1 ,String str2){
        int count=0;
        String firstString = str1.toLowerCase();
        String secondString = str2.toLowerCase();
        for(int i=0;i<firstString.length();i++){

            for(int j=0;j<secondString.length();j++){

                if(firstString.charAt(i)==secondString.charAt(j)){

                    count++;

                }
            }
        }
        if(count==str1.length()){
            return true;
        }
        return false;
    }

    // Optimize approach

    public static void isAnagrams(String str1 , String str2){
        String fString = str1.toUpperCase();
        String sString = str2.toUpperCase();
        
        // Checking whether length of both character is same or not
        if(fString.length()==sString.length()){

        // converting string to character array
        char arr1[] = fString.toCharArray();
        char arr2[] = sString.toCharArray();

        // sorting the character array
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        // if both contains same element in same sequence because they are sorted it will return true otherwise false
        boolean result = Arrays.equals(arr1, arr2);

        if(result){
            System.out.println(str1+" and "+ str2 +" is Anagrams");
        }else{
            System.out.println(str1+" and "+ str2 +" is not Anagrams of each other");
        }
        


    }else{
        // else condition if length of given strings is different
        System.out.println(str1+" and "+ str2 +" is not Anagrams of each other");
    }
    
    }
}
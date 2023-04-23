public class KeyPad {
    public static void main(String[] args) {
        // keypad("23"); // work for 2 Digits only
        keypadCom("234"); // Optimized Code
    }

     // Question 2: Keypad Combination

     public static void keypad (String digit){
        String phone[]= {"","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        String first =  digit.substring(0, 1);
        String second  = digit.substring(1);
        int indexI = Integer.parseInt(first)-1;
        int indexJ = Integer.parseInt(second)-1;
        
        for(int i=0;i<phone[indexI].length();i++){
            for(int j=0;j<phone[indexJ].length();j++){
                System.out.print(phone[indexI].charAt(i)+""+phone[indexJ].charAt(j)+" ");
            }
        }
    }


    // ---------------------------------------------------------------

    public static void keypadCom(String digit){
        char letter[][] = {{},{},{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
        int n = digit.length();
        if(n==0){
            System.out.println("");
            return;
        }
        combination(0,digit,letter,n,new StringBuilder());
    }
    public static void combination(int pos,String digit,char letter[][],int size,StringBuilder ans){
        if(pos==size){
            System.out.print(ans.toString()+" ");
        }else{
           char current[]=letter[Character.getNumericValue(digit.charAt(pos))];
           for(int i=0;i<current.length;i++){
            combination(pos+1, digit, letter, size,new StringBuilder(ans).append(current[i]));
           }
        }
    }

}

public class StringChapter{
    public static void main(String args[]){
        // System.out.println(palindrome("subodh"));
        // System.out.println(isPalindrome("madam"));
        // System.out.println(shortestPath("WNEENESENNN"));
        // String str[] = {"apple", "mango" , "banana"};
        // System.out.println(largest(str));

        // String sentence = "hi welcome to india";
        // System.out.println(uppercase(sentence));

        System.out.println(compression("aaabccdd"));
    }

    // Check if String is palindrome or not

    public static boolean palindrome(String str){
        int n=str.length();
        for(int i=0;i<str.length()/2;i++){
            if(str.charAt(i)!=str.charAt(n-1-i)){
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome(String str){
        int start=0;
        int end=str.length()-1;

        while(start<=end){
            if(str.charAt(start)!=str.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    // shortest path

    public static float shortestPath(String str){
        int x=0;
        int y=0;

        for(int i=0;i<str.length();i++){

            if(str.charAt(i)=='W'){
                x--;
            }else if (str.charAt(i)=='E'){
                x++;
            }
            else if (str.charAt(i)=='N'){
                y++;
            }else{
                y--;
            }
        }
        // distance formulat underoot of (x2 -x1)^2 -(y2-y1)^2   here  x1 and y1 is zero
        return (float) Math.sqrt(x*x + y*y);
    }

   // Print Largest String lexicographically 

    public static String largest(String str[]){

        String largest = str[0];
        for(int i=1;i<str.length;i++){
            if(largest.compareToIgnoreCase(str[i]) < 0 ){
                largest=str[i];
            }
        }
        return largest;
    }

   //  Convert first letter of sentence to uppercase
   
   public static String uppercase(String str){
      StringBuilder sb = new StringBuilder(" ");

      char ch = Character.toUpperCase(str.charAt(0));
      sb.append(ch);

      for(int i=1;i<str.length();i++){
        if( str.charAt(i)==' ' && i<str.length()){
            sb.append(str.charAt(i));
            i++;
            sb.append(Character.toUpperCase(str.charAt(i)));
        }else{

            sb.append(str.charAt(i));
        }
      }
      return sb.toString();
   }

   // String compression

   public static String compression(String str){
    StringBuilder sb = new StringBuilder("");
   

    for(int i=0;i<str.length();i++){
        int count=1;
        while( i<str.length()-1 && str.charAt(i)==str.charAt(i+1)){
            count++;
            i++;
        }
        if(count>1){
            sb.append(str.charAt(i));
            sb.append(count);
         
        }else{
            sb.append(str.charAt(i));
        }
    }
    return sb.toString();
   }
}
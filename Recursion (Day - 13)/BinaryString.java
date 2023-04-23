public class BinaryString {
    public static void main(String[] args) {
        printBinaryString(3, "", 0);
    }

    // Print Binary String without consecutive 1's
    public static void printBinaryString (int size,String str,int lastDigit){

        if(size==0){
            System.out.println(str);     
            return;
        }

        printBinaryString(size-1, str+"0", 0);
        if(lastDigit==0){
          
            printBinaryString(size-1, str+"1", 1);
        }
            
           
    }
}

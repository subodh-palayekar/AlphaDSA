public class SubString {
    public static void main(String[] args) {
        System.out.println(countSubStrings("abcac", 0, 0));

        String str = "abcac";
        int n = str.length();
        System.out.print(countSubstrs(str, 0, n-1, n)); 
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

    public static int countSubstrs(String str, int i, int j, int n) {
        if (n == 1) {
        return 1;
        }
        if (n <= 0) {
        return 0;
        }
        int res = countSubstrs(str, i + 1, j, n - 1) +
        countSubstrs(str, i, j - 1, n - 1) -
        countSubstrs(str, i + 1, j - 1, n - 2);
        if (str.charAt(i) == str.charAt(j)) {
        res++;
        }
        return res;
}

}

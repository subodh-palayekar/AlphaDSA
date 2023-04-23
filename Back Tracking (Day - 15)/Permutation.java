public class Permutation {
    public static void main(String[] args) {
        permutation("abc", "");
    }
    public static void permutation(String given, String ans){
        if(given.length()==0){
            System.out.println(ans);
            return;
        }
        for(int i=0;i<given.length();i++){
            char current = given.charAt(i);
            String newString = given.substring(0, i) + given.substring(i+1);
            permutation(newString, ans+current);

        }
    }
}

public class SubSet {
    public static void main(String[] args) {
        subSet("abc", null, 0);
    }
    public static void subSet(String given , String ans,int index){
      
        if(index==given.length()){
            if(ans.length()==0){
                System.out.println("null");
            }else{
                System.out.println(ans);
            }
            return;
        }
        char ch = given.charAt(index);
        subSet(given, ans+ch, index+1);
        subSet(given, ans, index+1);

    }
}

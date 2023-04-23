import java.util.HashMap;





public class ValidAnagram {
    public static void main(String[] args) {

        String s = "knee";
        String t = "neek";

        System.out.println(isAnagram(s, t));


    }
    public static boolean isAnagram(String s,String t){

        HashMap<Character,Integer> hm = new HashMap<>();

        // insert all the character of string s in hashmap
        for(int i=0;i<s.length();i++){
            hm.put(s.charAt(i),hm.getOrDefault(s.charAt(i), 0)+1);
        }

        // traverse second string t  
        for(int i=0;i<t.length();i++){

        // check whether character is present in hashmap or not
            if(hm.containsKey(t.charAt(i))){
                // if present reduce the frequency the frequency by 1
                hm.put(t.charAt(i),hm.getOrDefault(t.charAt(i), 0)-1);
                // if frequency get zero then remove that char
                if(hm.get(t.charAt(i))==0){
                    hm.remove(t.charAt(i));
                }
            }else{
                //  if char is not present then directly return false
                return false;
            }
        }
        // if hashmap gets empty means both character of s and t are same then return true else false
        return hm.size()==0;
    }
}

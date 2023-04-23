public class RemoveDuplicate {
    public static void main(String[] args) {
        removeDuplicate(new boolean[26], 0, "abbbddccd", new StringBuilder(""));
    }


    // Remove duplicate from string - ( given String contains only lowercase characters )
    
    public static void removeDuplicate(boolean found[],int index,String given,StringBuilder result){
        
        if(index==given.length()){
            System.out.println(result);
            return;
        }
        // Duplicate found
        char currChar = given.charAt(index);
        if(found[currChar-'a']==true){
            removeDuplicate( found,index +1, given,result);
        }else{
            found[currChar-'a']=true;
            removeDuplicate(found,index+1, given, result.append(currChar));
        }
    }
}
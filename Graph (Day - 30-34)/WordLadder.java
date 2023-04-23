import java.util.*;

public class WordLadder {

    static class Pair{
        String st;
        int count;

        Pair(String st,int count){
            this.st=st;
            this.count=count;
        }
    }

    public static int smallestChain(String dictionary[],String start,String target){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(start, 1));

        Set<String> set = new HashSet<>();
    
        for(int i=0;i<dictionary.length;i++){
            set.add(dictionary[i]);
        }

        while(!q.isEmpty()){
            Pair curr = q.remove();
            if(curr.st.equalsIgnoreCase(target)==true){
                return curr.count;
            }
            
            for(int i=0;i<curr.st.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char charArray[] = curr.st.toCharArray();
                    charArray[i]=ch;
                    String replacedChar = new String(charArray);
                    // System.out.println(replacedChar);
                    if(set.contains(replacedChar)==true){
                        set.remove(replacedChar);
                        q.add(new Pair(replacedChar, curr.count+1));
                    }
                }
            }
        }

        return -1;

    }
    public static void main(String[] args) {
        // String dictionary[] = {"POON","PLEE","SAME","POIE","PLEA","PLIE","POIN"};
        String dictionary[] = {"hot","dot","dog","lot","log","cog"};
        // String start ="TOON";  String target="PLEA";
        String start ="hit";  String target="cog";
 

        System.out.println(smallestChain(dictionary, start, target));

    }
}

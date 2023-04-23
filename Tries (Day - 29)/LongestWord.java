public class LongestWord{

    static class Node{
        Node children[] = new Node[26];
        boolean eow = false;

        Node(){
            for(int i=0;i<26;i++){
                children[i]=null;
            }
        }
    }

    public static Node root = new Node();

    public static void insert(String s){
        Node curr = root; 

        for(int level=0;level<s.length();level++){
            int idx = s.charAt(level)-'a';
            if(curr.children[idx]==null){
                curr.children[idx]= new Node();
            }
            curr=curr.children[idx]; 
        }
        curr.eow=true;
    }

    // Longest word with all prefixes in given array
    public static String ans="";

    public static void longestWord(Node root,StringBuilder temp){

        if(root==null){
            return;
        }

        for(int i=0;i<26;i++){
            if(root.children[i]!=null && root.children[i].eow==true){
                char ch =(char) (i+'a');
                temp.append(ch);
                if(temp.length()>ans.length()){
                    ans = temp.toString();
                }
                longestWord(root.children[i], temp);
                temp.deleteCharAt(temp.length()-1);
            }
        }
    }

   public static void main(String[] args) {
     String words[] = {"a","banana","app","appl","ap","apply","apple"};

    //  create trie of given words
     for(int i=0;i<words.length;i++){
        insert(words[i]);
     }
     longestWord(root,new StringBuilder(""));
     System.out.println(ans);

   }
}
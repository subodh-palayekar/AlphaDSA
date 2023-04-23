
public class Tries{

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

    public static boolean search(String key){
        Node curr = root;

        for(int i=0;i<key.length();i++){
            int idx = key.charAt(i)-'a';
            if(curr.children[idx]==null){
                return false;
            }
            curr=curr.children[idx];
        }
        return curr.eow == true;
    }

    public static boolean wordBreak(String key){

        if(key.length() == 0){
            return true; 
        }

        for(int i=1;i<=key.length();i++){
            if(search(key.substring(0,i)) && wordBreak(key.substring(i))){
                return true;
            }
        }
        return false;
    }

    public static boolean startsWithPrefix(Node root,String prefix){  //O(L)
        Node curr =root; 
        for(int i=0;i<prefix.length();i++){
            int idx = prefix.charAt(i)-'a';
            if(curr.children[idx]==null){
                return false;
            }
            curr=curr.children[idx];
        }
        return true;
    }

    public static int countNodes(Node root){
        if(root==null){
            return 0;
        }
        int count=0;
        for(int i=0;i<26;i++){
            if(root.children[i]!=null){
                count+=countNodes(root.children[i]);
            }
        }
        return count +1 ;
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
        // String words[]={"the","a","there","their","any","thee"};

        // for(int i=0;i<words.length;i++){
        //     insert(words[i]);
        // }

        // String key = "any";
        // System.out.println(search(key));

        // --------------------------------------------------------------------------------

        // String words2[] = {"i","like","sam","samsung","mobile","ice"};
        // String key2 = "ilikesamsung";

        // for(int i=0;i<words2.length;i++){
        //     insert(words2[i]);
        // }

        // System.out.println(wordBreak(key2));

        // -----------------------------------------------------------------------------

        // String words3[] = {"apple","app","mango","man","woman"};
        // for(int i=0;i<words3.length;i++){
        //     insert(words3[i]);
        // }
        // System.out.println(startsWithPrefix(root, "apple"));

        // -----------------------------------------------------------------------------
        // uniqueSubstring count
        // String word = "ababa";

        // creating trie by inserting all substring of given word
        // for(int i=0;i<word.length();i++){
        //     String suffix = word.substring(i);
        //     insert(suffix);
        // }

        // System.out.println(countNodes(root));


        String words[] = {"a","banana","app","apple","ap","apply","apple"};

        //  create trie of given words
         for(int i=0;i<words.length;i++){
            insert(words[i]);
         }
         longestWord(root,new StringBuilder(""));
         System.out.println(ans);
    }
}
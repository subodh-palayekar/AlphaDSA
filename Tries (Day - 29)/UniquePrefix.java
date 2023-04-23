public class UniquePrefix {
    static class Node{
        Node children[] = new Node[26];
        boolean eow;
        int freq;

        Node (){
            for(int i=0;i<26;i++){
                this.children[i]=null;
            }
            this.freq=1;
        }
    }
    public static Node root = new Node();

    public static void insert(String s){
        
        Node curr = root;

        for(int i=0;i<s.length();i++){
            int idx = s.charAt(i)-'a';
            if(curr.children[idx]==null){
                curr.children[idx]=new Node();
            }else{
                curr.children[idx].freq++;
            }
            curr=curr.children[idx];
        }
        curr.eow=true;
    }

    public static String uniquePrefix (String s){
        Node curr = root;
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<s.length();i++){
            sb.append(s.charAt(i));
            int idx = s.charAt(i)-'a';
            if(curr.children[idx] != null && curr.children[idx].freq==1){
                break;
            }
            curr=curr.children[idx];
        }
        return sb.toString();
    }

    public static void uniquePrefix(Node root,String ans){  //O(L) levels in my trie
        if(root == null){
            return;
        }
        if(root.freq ==1){
            System.out.println(ans);
            return;
        }

        for(int i=0;i<root.children.length;i++){
            if(root.children[i] != null){
                uniquePrefix(root.children[i],ans+(char)(i+'a'));
            }
        }

    }

    
    public static void main(String[] args) {

        String arr[] ={"zebra","dog","duck","dove"};
        
        for(int i=0;i<arr.length;i++){
           insert(arr[i]);
        }
        root.freq=-1;

        // Iterative approach
        // for(int i=0;i<arr.length;i++){
        //     System.out.print(uniquePrefix(arr[i])+" ");
        // }

        // recursive approach
        uniquePrefix(root, "");


    }
}

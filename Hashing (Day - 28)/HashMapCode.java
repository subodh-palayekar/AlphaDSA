import java.util.ArrayList;
import java.util.LinkedList;

public class HashMapCode{

    static class HashMap<K,V>{

        private class Node{
            K key;
            V value;

            Node(K key, V value){
                this.key=key;
                this.value=value;
            }
        }

        private int n; // n number of nodes
        private int N; // size of bucket
        private LinkedList<Node> buckets[]; //N size of array   (Array of LinkedList)
        

        @SuppressWarnings("unchecked")
        public HashMap(){
            this.N=4;
            this.buckets = new LinkedList[4];

            for(int i=0;i<4;i++){
                this.buckets[i]=new LinkedList<>();
            }
        }

        private int hashFunction(K key){
            int hc = key.hashCode();
            return Math.abs(hc) % N;
        }

        private int searchInLL(K key,int bi){
            LinkedList<Node> ll = buckets[bi];
            int di=0;
            for(int i=0;i<ll.size();i++){
                Node curr = ll.get(i);
                if(curr.key==key){
                    return di;
                }
                di++;
            }
            return -1;
        }

        @SuppressWarnings("unchecked")
        private void rehash(){
            LinkedList<Node> oldBuckt[] = buckets;
            buckets = new LinkedList[2*N];
            N= 2*N;
            for(int i=0;i< buckets.length;i++){
                buckets[i]= new LinkedList<>();
            }

            // adding data of old bucket to new bucket

            for(int i=0;i<oldBuckt.length;i++){
                LinkedList<Node> ll =buckets[i];
                for(int j=0;j<ll.size();j++){
                    Node node = ll.remove();
                    put(node.key, node.value);
                }
            }

        }



        public void put (K key, V value){

            int bi = hashFunction(key); // bucket index
            int di = searchInLL(key,bi);

            if(di!=-1){
                Node node = buckets[bi].get(di);
                node.value=value;
            }else{
                Node newNode = new Node(key, value);
                buckets[bi].add(newNode);
                n++;
            }

            double lambda = (double) n/N;  // total number of node / size of array
            if(lambda>2.0){
                rehash();
            }
        }


        public boolean containsKey(K key){
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if(di!=-1){
                return true;
            }else{
                return false;
            }
        }

        public V get(K key){
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if(di!=-1){
                Node node = buckets[bi].get(di);
                return node.value;
            }else{
                return null;
            }
        }

        public V remove(K key){
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if(di!=-1){
                Node node = buckets[bi].remove(di);
                n--;
                return node.value;
            }else{
                return null;
            }
        }

        public ArrayList<K> keySet(){
            ArrayList<K> keyList = new ArrayList<>();

            for(int i=0;i<buckets.length;i++){ //N = buckets.length
                LinkedList<Node> ll = buckets[i];
                for(Node node : ll ){
                    keyList.add(node.key);
                }
            }
            return keyList;

        }

        public boolean isEmpty(){
            return n==0;
        }

    
    }


    public static void main(String[] args) {
        HashMap<String,Integer> hm = new HashMap<>();
        
        hm.put("Tea", 10);
        hm.put("Samosa", 15);
        hm.put("vadapav", 15);
        hm.put("coffee", 10);
        hm.put("Biscuits", 5);


        ArrayList<String> keys = hm.keySet();
        

        for(String key : keys){
            System.out.println(key);
        }

        System.out.println(hm.get("Tea"));
        System.out.println(hm.remove("coffee"));
        System.out.println(hm.containsKey("coffee"));

        System.out.println(hm.get("coffee"));
    }


    
}
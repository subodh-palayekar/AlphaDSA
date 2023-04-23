import java.util.*;

public class HeapAndPQ {
    static class Heap{

        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data){
            arr.add(data);

            int x = arr.size()-1; // child index
            int par = (x-1)/2;  // parent index

            while(arr.get(x)<arr.get(par)){
                // swap
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par,temp);
                x=par;
                par=(x-1)/2;
            }
            
        }

        public int peek(){
            return arr.get(0);
        }

        private void heapify(int i){

            int leftChild = 2*i+1;  // left child index
            int rightChild = 2*i+2; // right child index
            int minIdx = i; 

            if(leftChild < arr.size() && arr.get(leftChild)<arr.get(minIdx)){
                minIdx=leftChild;
            }
            if(rightChild < arr.size() && arr.get(rightChild)<arr.get(minIdx)){
                minIdx=rightChild;
            }

            if(minIdx!=i){
                // swap
                int temp = arr.get(minIdx);
                arr.set(minIdx, arr.get(i));
                arr.set(i, temp);

                heapify(minIdx);
            }
        }

        public int remove(){

            int data = arr.get(0);

            // step-1 swap first and last index element
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size()-1));
            arr.set(arr.size()-1, temp);

            // step-2 remove last element
            arr.remove(arr.size()-1);

            // heapify
            heapify(0);

            return data;
        }

        public boolean isEmpty(){
            return arr.size()==0;
        }


    }
    public static void main(String[] args) {
        Heap h = new Heap();

        h.add(30);
        h.add(10);
        h.add(-1);

        while(!h.isEmpty()){
            System.out.println(h.peek());
            h.remove();
        }
    }

    
}

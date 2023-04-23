import java.util.ArrayList;

import javax.print.attribute.Size2DSyntax;

public class MergeBST {

    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left=null;
            this.right=null;
        }
    }
    public static void preOrder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(Node root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);


    }
    public static void creatInOrder(ArrayList<Integer> arr , Node root){

        if(root==null){
            return ;
        }

        creatInOrder(arr, root.left);
        arr.add(root.data);
        creatInOrder(arr, root.right);
    }


    public static Node createBalanceBST(ArrayList<Integer> arr,int start,int end){
        if(start>end){
            return null;
        }

        int mid = start + (end-start)/2;

        Node root = new Node(arr.get(mid));

        root.left=createBalanceBST(arr, start, mid-1);
        root.right=createBalanceBST(arr, mid+1, end);

        return root;

    }

    public static Node mergeBST(Node root1, Node root2){

        ArrayList<Integer> arr1 = new ArrayList<>();
        creatInOrder(arr1 , root1);

        ArrayList<Integer> arr2 = new ArrayList<>();
        creatInOrder(arr2 , root2);

        
    
        // merge two arrayList
        ArrayList<Integer> finalMerge = new ArrayList<>();

        int i=0;
        int j=0;

        while(i<arr1.size() && j<arr2.size()){
            if(arr1.get(i)<=arr2.get(j)){
                finalMerge.add(arr1.get(i));
                i++;
            }else{
                finalMerge.add(arr2.get(j));
                j++; 
            }


            while(i<arr1.size()){
                finalMerge.add(arr1.get(i));
                i++;
            }

            while(j<arr2.size()){
                finalMerge.add(arr2.get(j));
                j++;
            }
        }

        return createBalanceBST(finalMerge, 0, finalMerge.size()-1);

    }


    public static void main(String[] args) {
        
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);

        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);

        Node newNode = mergeBST(root1, root2);
        preOrder(newNode);
        System.out.println();
        inOrder(newNode);


    }
}

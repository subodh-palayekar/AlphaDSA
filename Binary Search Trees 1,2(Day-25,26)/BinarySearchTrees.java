import java.util.*;

public class BinarySearchTrees{
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    


    // Level Order Traversal
    public static void levelOrderTraversal(Node root){   
        if(root==null){
            return;
        }
        Queue<Node> q = new LinkedList<>();

        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            Node curr = q.remove();
            if(curr==null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                System.out.print(curr.data+" ");

                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
        }
        System.out.println();
    }

    public static void inOrderTraversal(Node root){
        if(root==null){
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.data+" "); 
        inOrderTraversal(root.right);
    }

    // PreOrder Traversal

    public static void preOrder(Node root){
        if(root==null){
            return ;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }


    public static Node buildBST(Node root,int data){
        if(root==null){
            root = new Node(data);
            return root;
        }

        if(data<root.data){
            root.left = buildBST(root.left, data);
        }else{
            root.right = buildBST(root.right, data);
        }
        return root;
    }

    public static boolean search(Node root,int key){
        if(root==null){
            return false;
        }
        if(root.data==key){
            return true;
        }

        if(key<root.data){
            return search(root.left, key);
        }else{
            return search(root.right, key);
        }
    }

    public static Node deleteNode(Node root,int key){

        if(key<root.data){
            root.left = deleteNode(root.left, key);
        }else if(key>root.data){
            root.right = deleteNode(root.right, key);
        }else{  // we found our node
           
            // case 1 - leaf node
            if(root.left==null && root.right==null){
                return null;
            }
            // case 2 - single children node
            if(root.right==null){
                return root.left;
            }
            else if(root.left==null){
                return root.right;
            }

            // case 3 - both children node
            Node IS = findInorderSuccessor(root.right);
            root.data = IS.data;
            root.right=deleteNode(root.right, IS.data);
        } 
        return root;
    }

    public static Node findInorderSuccessor(Node root){
        while(root.left!=null){
            root=root.left;
        }
        return root;
    }

    public static void printInRange(Node root,int k1,int k2){
        if(root==null){
            return;
        }

        if(root.data>=k1 && root.data<=k2){
            printInRange(root.left, k1, k2);
            System.out.print(root.data+" ");
            printInRange(root.right, k1, k2);
        }else if(root.data<k1){
            printInRange(root.right, k1, k2);
        }else{
            printInRange(root.left, k1, k2);
        }
    }


    public static void rootToleaf(Node root,ArrayList<Integer> path){
        if(root==null){
            return;
        }
        path.add(root.data);

        if(root.left==null && root.right==null){
            System.out.println(path);
            return;
        }
        rootToleaf(root.left, path);
        rootToleaf(root.right, path);
        path.remove(path.size()-1);

    }

    public static boolean isValidBST(Node root , Node min,Node max){
        if(root==null){
            return true;
        }
        if(min!=null && root.data <=min.data){
            return false;
        }
        else if(max!=null && root.data >=max.data){
            return false;
        }

        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }

    public static Node mirrorBST(Node root){
        if(root==null){
            return null;
        }


        Node leftMirror = mirrorBST(root.right);
        Node rightMirror = mirrorBST(root.left);
        root.left= leftMirror;
        root.right=rightMirror;
        return root;
    }

    // arr should be sorted in ascending order

    public static Node buildBalanceBSt(int arr[],int start,int end){
        if(start>end){
            return null;
        }
        int mid = start + (end-start)/2;
        

        Node root = new Node(arr[mid]);

        root.left=buildBalanceBSt(arr, start, mid-1);
        root.right=buildBalanceBSt(arr, mid+1, end);

        return root;
    }


    // helper function 
    public static void inOrder(Node root,ArrayList<Integer> arr){
        if(root==null){
            return;
        }

        inOrder(root.left, arr);
        arr.add(root.data);
        inOrder(root.right, arr);
    }

    // create balance BST from unbalance bst - helper function
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
    // create balance BST from unbalance bst
    public static Node balanceBST(Node root){

        ArrayList<Integer> arr = new ArrayList<>();

        inOrder(root,arr); 

        return root = createBalanceBST(arr,0,arr.size()-1);

    }

    public static void main(String[] args) {

        int values[] ={8,5,10,3,6,11,14};

        Node root=null;

        for(int i=0;i<values.length;i++){
            root = buildBST(root, values[i]);
        }

        // levelOrderTraversal(root);

        // inOrderTraversal(root);
        // System.out.println();

        // System.out.println(search(root, 8));

        // root = deleteNode(root, 4);

        // inOrderTraversal(root);

        // printInRange(root, 2, 5);

        // ArrayList<Integer> path= new ArrayList<>();

        // rootToleaf(root, path);
        // System.out.println(isValidBST(root, null, null));
        
        // preOrder(root);
        // System.out.println();
        // root = mirrorBST(root);
        // // levelOrderTraversal(root2);
        // preOrder(root);

        int arr[]={3,5,6,8,10,11,12};
        root = buildBalanceBSt(arr, 0, arr.length-1);
        
        // inOrderTraversal(root);


        Node unblanace = new Node(8);
        unblanace.left = new Node(6); 
        unblanace.left.left = new Node(5); 
        unblanace.left.left.left = new Node(3); 

        unblanace.right = new Node(10); 
        unblanace.right.right = new Node(11); 
        unblanace.right.right.right = new Node(12); 

         /* Unbalanced BST   This is a valid BST but not balance
                         8 
                       /   \
                      6     10
                     /       \
                    5         11
                   /           \
                  3             12
        */


        // preOrder(unblanace);

        unblanace = balanceBST(unblanace);

        preOrder(unblanace);


    }
}
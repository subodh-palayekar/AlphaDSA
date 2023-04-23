public class BinaryTreesAssignment {

    static class Node{
        int data;
        Node right;
        Node left;

        Node(int data){
            this.data=data;
            this.right=null;
            this.left=null;
        }
    }

    public static boolean isUnivalued (Node root){
        if(root==null){
            return true;
        }
        if(root.left!=null && root.data!=root.left.data){
            return false;
        }
        if(root.right!=null && root.data!=root.right.data){
            return false;
        }
        return isUnivalued(root.left) && isUnivalued(root.right);
    }

    public static Node mirrorTree(Node root){

        if(root==null){
            return null;
        }
        if(root.left==null && root.right==null){
            return root;
        }

        Node left = mirrorTree(root.left);
        Node right = mirrorTree(root.right);

        root.left=right;
        root.right=left;

        return root;
    }

    public static void preOrder(Node root){
        if(root==null){
            return;
        }

        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static Node deleteXvalueLeaf(Node root,int x){

        if(root==null){
            return null;
        }
        root.left = deleteXvalueLeaf(root.left, x);
        root.right = deleteXvalueLeaf(root.right, x);
        
        if(root.data==x && root.left==null && root.right==null){
            return null;
        }
        return root;
    }
    public static int maxSum = Integer.MIN_VALUE;

    public static int maxPathSum(Node root){

        if(root==null || root.data<=0 ){
            return 0;
        }

        int leftMax = maxPathSum(root.left);
        int rightMax = maxPathSum(root.right);
        int sum = root.data + leftMax + rightMax;

        maxSum = Math.max(maxSum, sum);

        return Math.max(rightMax, leftMax) + root.data;
    }
    public static void main(String[] args) {
        // Node root = new Node(2);
        // root.left= new Node(2);
        // root.right = new Node(2);

        // root.left.left = new Node(5);
        // root.left.right = new Node(2);

        // System.out.println(isUnivalued(root));


        Node root = new Node(1);
        root.left= new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        /*
                         1 
                       /   \
                      2     3
                     / \   / \
                    4   5 6   7
                             
        */


        Node root2 =  new Node(1);
        root2.left= new Node(3);
        root2.left.left = new Node(3);
        
        root2.right = new Node(3);

        /*
                         1 
                       /   \
                      3     3
                     / 
                    3     
        */

        // preOrder(root);
        // System.out.println();

        // mirrorTree(root);
        // preOrder(root2);
        // System.out.println();

        // root=deleteXvalueLeaf(root2,3);

        // preOrder(root2);
        // System.out.println();

        // maxPathSum(root);
        // System.out.println(maxSum);






    }

}


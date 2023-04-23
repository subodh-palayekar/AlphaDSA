import java.util.*;

public class BinTrees {

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

    public static int height(Node root){
        if(root == null){
            return 0;
        }

        int left = height(root.left);
        int right= height(root.right);

        return (Math.max(left, right)) +1;
    }

    // Method 1 to calculate diameter of tree O(n^2)

    public static int diameter(Node root){
        if(root==null){
            return 0;
        }
        int leftDiameter = diameter(root.left);
        int rightDiameter = diameter(root.right);

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        int selfDiameter = leftHeight + rightHeight +1;

        return Math.max(Math.max(leftDiameter, rightDiameter), selfDiameter);
    }


    // Method 2 to calculate diameter of tree O(n)

    static class Info{
        int diameter;
        int height;

        Info(int diameter,int height){
            this.diameter=diameter;
            this.height=height;
        }
    }

    public static Info diameterOpt (Node root){
        if(root == null){
            return new Info(0, 0);
        }
        Info leftInfo = diameterOpt(root.left);
        Info rightInfo = diameterOpt(root.right);
        int height = Math.max(leftInfo.height, rightInfo.height)+1; 

        int selfDiameter = leftInfo.height +rightInfo.height +1;
        int finalDiameter = Math.max(selfDiameter, Math.max(leftInfo.diameter, rightInfo.diameter));


        return new Info(finalDiameter, height);

    }


    public static boolean isIdentical(Node root,Node subRoot) {

        if(root==null && subRoot == null ){
            return true;
        }else if(root == null || subRoot == null || root.data != subRoot.data){
            return false;
        }
        if(!isIdentical(root.left, subRoot.left)){
            return false;
        }
        if(!isIdentical(root.right, subRoot.right)){
            return false;
        }
        return true;
    }


    public static boolean isSubTree(Node root,Node subRoot){

        if(root == null){
            return false;
        }
        if(root.data == subRoot.data){
            if(isIdentical(root,subRoot)){
                return true;
            }
        }
        return isSubTree(root.left, subRoot) || isSubTree(root.right, subRoot);
       
    }

    static class Details{
        int hzDistance;
        Node node;

        public Details(int hzDistance,Node node){
            this.hzDistance = hzDistance;
            this.node=node;
        }
    }

    public static void topView(Node root){

        // Queue <Details>  q =  new LinkedList<>();

        HashMap<Integer,Node> map = new HashMap<>();

        int min=0;
        int max=0; 
        Queue<Details> q = new java.util.LinkedList<>();
        q.add(new Details(0,root));
        q.add(null);
        

        while(!q.isEmpty()){
           Details curr = q.remove();

           if(curr==null){
            if(q.isEmpty()){
                break;
            }else{
                q.add(null);
            }
           }else{
            if(!map.containsKey(curr.hzDistance)){
                map.put(curr.hzDistance, curr.node);
               }
               if(curr.node.left!=null){
                  q.add(new Details(curr.hzDistance-1, curr.node.left));
                  min = Math.min(min, curr.hzDistance-1);
               }
               if(curr.node.right!=null){
                q.add(new Details(curr.hzDistance+1, curr.node.right));
                max = Math.max(max, curr.hzDistance+1);
               }
           }
           
           
        }

        for(int i=min ;i<=max;i++){
            System.out.print(map.get(i).data+" ");
        }
        System.out.println();


    }

    public static void kLevel(Node root,int level,int k){
        if( root == null){
            return;
        }
        if(level==k){
            System.out.print(root.data+" ");
            return;
        }
        kLevel(root.left, level+1, k);
        kLevel(root.right, level+1, k);
    }


    //  fina lowest common Ancestor T.C O(n)  S.P O(n)

    public static  Node lowestCommonAncestor(Node root,int n1,int n2){
        
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root,n1,path1);
        getPath(root,n2,path2);

        int i=0;
        for(;i<path1.size() && i<path2.size();i++){
            if(path1.get(i)!=path2.get(i)){
                break;
            }
        }
        return path1.get(i-1);
    }


    public static boolean getPath(Node root,int n,ArrayList<Node> path){
        if(root==null){
            return false;
        }
        path.add(root);
        if(root.data == n){
            return true;
        }
        boolean foundLeft = getPath(root.left, n, path);
        boolean foundRight = getPath(root.right, n, path);
        if(foundLeft || foundRight){
            return true;
        }
        path.remove(path.size()-1);
        return false;
    }


    //  fina lowest common Ancestor Method 2 T.C O(n)  S.P O(1)

    public static  Node lca2(Node root,int n1,int n2){
    
        if(root == null || root.data==n1 || root.data==n2){
            return root;
        }

        Node leftLca = lca2(root.left, n1, n2);
        Node rightLca = lca2(root.right, n1, n2);

        if(rightLca==null){
            return leftLca;
        }
        if(leftLca==null){
            return rightLca;
        }

        // when both left and right return some node i.e. Not null value
        return root;
    
    }

    //  Minimum distance between two nodes

    public static int minDistance(Node root,int n1,int n2){
        if(root==null){
            return 0;
        }
        // first calculate lca for two values
        Node lca = lca2(root, n1, n2);

       int dis1 = lcaDistance(lca,n1);
       int dis2 = lcaDistance(lca,n2);

       return dis1 +dis2;

    }

    public static int lcaDistance(Node lca,int n){

        if(lca==null){
            return -1;
        }
        if(lca.data==n ){
            return 0;
        }
        int left = lcaDistance(lca.left, n);
        int right = lcaDistance(lca.right, n);
        if(left ==-1 && right==-1){
            return -1;
        }else if(left==-1){
            return right+1;
        }else{
            return left+1;
        }

    }

    // Kth ancestor of Node

    public static int kAncestor (Node root , int k,int n){
        if(root==null){
            return -1;
        }
        if(root.data==n){
            return 0;
        }
        
        int left =  kAncestor(root.left, k, n);
        int right = kAncestor(root.right, k, n);

        if(left==-1 && right==-1){
            return -1;
        }
        int max = Math.max(left, right);

        if(max+1==k){
            System.out.println(root.data);
        }
        return max+1;


    }

    public static int transformSum (Node root){
        if(root==null){
            return 0;
        }
        // if(root.left==null && root.right==null){
        //     return 0;
        // }

        int oldData = root.data;
        int left = transformSum(root.left);
        int right=transformSum(root.right);

        root.data=left+right;

        return left+right+oldData;
    }

    // level order traversal

    public static void levelOrderTraversal(Node root){

        Queue<Node> q = new java.util.LinkedList<>();

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


    

    public static void main(String[] args) {


        /*
                         1 
                       /   \
                      2     3
                     / \   / \
                    4   5 6   7
                               \
                                8 
        */

        Node root = new Node(1);
        root.left= new Node(2); 
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left= new Node(6);
        root.right.right= new Node(7);
        root.right.right.right = new Node (8);


        /*
        
                         3
                        / \
                       6   7
                            \
                             8
        
        */


        Node subRoot = new Node(3);
        subRoot.left= new Node(6);
        subRoot.right= new Node(7);
        subRoot.right.right = new Node (8);



        // System.out.println(height(root));

        // System.out.println(diameterOpt(root).diameter);

        // System.out.println(isSubTree(root, subRoot));

        // topView(root);

        // kLevel(root, 1, 2);

        // System.out.println(lowestCommonAncestor(root, 4, 5).data);
        // System.out.println(lca2(root, 4, 7).data);

        // System.out.println(minDistance(root, 4, 8));
        
        // kAncestor(root, 3, 8);

        transformSum(root);
        levelOrderTraversal(root);


    
    }

}

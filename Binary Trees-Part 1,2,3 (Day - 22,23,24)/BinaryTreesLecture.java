import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreesLecture{
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

    static class BinaryTree{
        static int index=-1;
        public static Node buildTreePreorder(int nodes[]){
            index++;

            // Base case
            if(nodes[index]==-1){
                return null;
            }

            Node newNode= new Node(nodes[index]);
            newNode.left=buildTreePreorder(nodes);
            newNode.right=buildTreePreorder(nodes);

            return newNode;
        }

        // root left right
        public static void preorderTraversal(Node root){
        
            if(root==null){
                // System.out.print("-1 ");
                return;
            }
            System.out.print(root.data+" ");
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }


        public static void inorderTraversal(Node root){

            if(root==null){
                return;
            }
            inorderTraversal(root.left);
            System.out.print(root.data+" ");
            inorderTraversal(root.right);
            
        }

        public static void postorderTraversal(Node root){
             
            if(root==null){
                return;
            }

            postorderTraversal(root.left);
            postorderTraversal(root.right);
            System.out.print(root.data + " ");
        }


        public static void levelOrderTraversal(Node root){

            if(root==null){
                return;
            }

            Queue<Node> q = new LinkedList<>();

            q.add(root);
            q.add(null);

            while(!q.isEmpty()){
                Node currNode = q.remove();

                if(currNode==null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                }else{
                    System.out.print(currNode.data+" ");

                    if(currNode.left!=null){
                        q.add(currNode.left);
                    }
                    if(currNode.right!=null){
                        q.add(currNode.right);
                    }
                }
            }
        }

        public static int treeHeight(Node root){
            if(root==null){
                return 0;
            }
            int leftHeight = treeHeight(root.left);
            int rightHeight =treeHeight(root.right);
            int finalHeight = Math.max(leftHeight, rightHeight);
 
            return finalHeight +1;
        }

        public static int countNodes(Node root){
            if(root==null){
                return 0;
            }
            int leftCount = countNodes(root.left);
            int rightCount =countNodes(root.right);
 
            return leftCount + rightCount +1;
        }

        public static int NodeSum(Node root){
            if(root==null){
                return 0;
            }
            int leftSum = NodeSum(root.left);
            int rightSum =NodeSum(root.right);
 
            return leftSum + rightSum + root.data;
        }


        public static int diameter(Node root){
            if(root==null){
                return 0;
            }
            int leftDiameter = diameter(root.left);
            int leftHeight = treeHeight(root.left);

            int rightDiameter = diameter(root.right);
            int rightHeight = diameter(root.right);

            int selfDiameter = leftHeight+rightHeight+1;

            return Math.max(selfDiameter, Math.max(leftDiameter, rightDiameter));
        }
    }


    

    
    public static void main(String[] args) {
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};

        BinaryTree tree = new BinaryTree();

        Node root = tree.buildTreePreorder(nodes);

        // System.out.println(root.data);

        // tree.preorderTraversal(root);

        // tree.inorderTraversal(root);

        // tree.postorderTraversal(root);

        // tree.levelOrderTraversal(root);

        // System.out.println(tree.treeHeight(root));

        // System.out.println(tree.countNodes(root));

        // System.out.println(tree.NodeSum(root));

        System.out.println(tree.diameter(root));
    }
}

import java.util.Stack;


public class StackAssignment {
    public static class Node{
        int data;
        Node next;

         Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    public static Node head;
    
    public static void main(String[] args) {
        Node head1 = new Node(1);
        Node head2 =new Node(2);
        Node head3 =new Node(1);

        head1.next=head2;
        head2.next=head3;

        System.out.println(isPalindrome(head1));

        // System.out.println(decodeString("3[b2[vu]]"));

        // System.out.println(decode("3[b2[vu]]"));

        // System.out.println(simplifyPath("/home/subodh/"));

        int [] heights = {7,0,4,2,5,0,6,4,0,5};
        System.out.println(trappingRainWater(heights));

        System.out.println(trappingWaterStack(heights));
    }

    
    // palindrome using stack

    public static boolean isPalindrome (Node head){
         Stack<Integer> s = new Stack<>();
         Node temp =head;

         while(temp!=null){
            s.push(temp.data);
            temp=temp.next;
         }
         while(head!=null){
            int i = s.pop();
           if(i!=head.data){
            return false;
           }
           head=head.next;
         }
         return true;
    }

    // String decode
    public static String decodeString(String str){
           

        Stack<String> charStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        String ans="";
        int i=0;
        while(i<str.length()){
            if(Character.isDigit(str.charAt(i))){
                int count=0;
                while(Character.isDigit(str.charAt(i))){
                    count=10*count + (str.charAt(i)-'0');
                    i++;

                }
                numStack.push(count);
            }else if(str.charAt(i)=='[' ){
                charStack.push(ans); 
                ans="";
                i=i+1;
            }else if(str.charAt(i)==']'){
                StringBuilder temp = new StringBuilder(charStack.pop());
                int digit = numStack.pop();
                for(int j=0;j<digit;j++){
                    temp.append(ans);
                }
                ans=temp.toString();
                i=i+1;
            }else{
                ans=ans+str.charAt(i);
                i=i+1;

            }
        }
        return ans;
    }

    public static String decode(String str){
        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        int i=0;
        String ans="";
        while(i<str.length()){

            if(Character.isDigit(str.charAt(i))){
                int count=0;
                while(Character.isDigit(str.charAt(i))){
                    count=10*count+str.charAt(i)-'0';
                    i++;
                }
                numStack.push(count);
            }else if(str.charAt(i)=='['){
                strStack.push(ans);
                ans="";
                i++;
            }else if(str.charAt(i)==']'){
                int digit=numStack.pop();
                StringBuilder temp = new StringBuilder(strStack.pop());
                for(int j=0;j<digit;j++){
                    temp.append(ans);
                }
                ans = temp.toString();
                i++;
            }else{
                ans+=str.charAt(i);
                i++;
            }
        }
        return ans;
    }

    // Simplify path
    public static String simplifyPath(String path){
        Stack<String>s = new Stack<>();
        int i=1;
        String finalPath ="";
        while(i<path.length()){
            if(path.charAt(i)=='/'){
                s.push(finalPath);
                finalPath="";
                if( i<path.length()-2 && path.charAt(i+1)=='/'){
                    finalPath+='/';
                }else{
                    finalPath+='/';
                }
                i++;
            }else if(path.charAt(i)=='.'){

                int count=1;
                while(path.charAt(i)!='.'){
                    i++;
                    count++;
                }
                for(int j=0;j<count && !s.isEmpty();i++){
                    s.pop();
                }
            }else{
                finalPath+=path.charAt(i);
                i++;
            }
        }
        while(!s.isEmpty()){
            finalPath+=s.pop();
        }
        if(finalPath.charAt(finalPath.length()-1)=='/'){
            finalPath=finalPath.substring(0, finalPath.length()-1);
        }
        return finalPath;
    }



    public static int trappingRainWater(int heights[]){
        // left boundary
        Stack<Integer> leftBoundary = new Stack<>();
        int maxLeft = Integer.MIN_VALUE;
        for(int i=heights.length-1 ;i>=0;i--){
            maxLeft=Math.max(maxLeft, heights[i]);
            leftBoundary.push(maxLeft);
        }
       
        // right boundary
        Stack<Integer> rightBoundary = new Stack<>();
        int maxRight = Integer.MIN_VALUE;
        for(int i=0;i<heights.length;i++){
            maxRight=Math.max(maxRight, heights[i]);
            rightBoundary.push(maxRight);
        }
        
        //water Calculation
        int area=0;
        int finalHeight=0;
        for(int i=0;i<heights.length;i++){
           finalHeight=Math.min(leftBoundary.pop(), rightBoundary.pop())- heights[i];
           if(finalHeight<0){
            finalHeight=0;
           }
           area=area+finalHeight*1; // area = height*width
        }
        return area;

        
    }
    // trapping rainwater 2nd approach
        
    public static int trappingWaterStack(int heights[]){
        Stack<Integer> s = new Stack<>();
        int ans=0;

        for(int i=0;i< heights.length;i++){

            while(!s.isEmpty() && heights[s.peek()]<heights[i]){
                int top=heights[s.pop()];
                if(s.isEmpty()){
                    break;
                }
                int width = i-s.peek()-1;
                int minHeight = Math.min(heights[s.peek()], heights[i]) - top;

                ans = ans +  width*minHeight;

            }
            s.push(i);
        }
        return ans;
    } 

}

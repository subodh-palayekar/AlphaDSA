import java.util.Arrays;
import java.util.Stack;

public class CollectionsStack {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();

        s.push(1);
        s.push(2);
        s.push(3);
        s.push(10);
        System.out.println(s);
        reverseStack(s);
        System.out.println(s);


        // System.out.println(s.peek());

        // pushAtBottom(s, 4);
        
        // System.out.println(s);

        // String str="abcd";

        // System.out.println(reverseString(str));

        // int stocks[] = {100,80,60,70,60,85,100};
        // stockSpan(stocks);
       

        // int arr[] = {6,8,0,1,3};
        // nextGreater(arr);

        // String par = "(){}";
        // System.out.println(validParentheses(par));

        // String dubPar = "(((a+b)+(c+d)))";
        // System.out.println(duplicateParenthese(dubPar));

        // int heights[] = {2,1,5,6,2,3};
        // System.out.println(maxAreaHistogram(heights));

    }

    // push given element at bottom
    public static void pushAtBottom(Stack<Integer> s,int data){
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int prevData = s.peek();
        s.pop();
        pushAtBottom(s, data);
        s.push(prevData);

    }

    // Reverse a string using stack
    public static String reverseString(String str){
        Stack<Character> ch = new Stack<>();
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<str.length();i++){
            ch.push(str.charAt(i));
        }
        while(!ch.isEmpty()){
            ans.append(ch.pop());
        }
        return ans.toString();
    }

    // Reverse a stack

    public static void reverseStack(Stack<Integer> s){
        if(s.isEmpty()){
            return;
        }

        int data = s.pop();
        reverseStack(s);
        pushAtBottom(s, data);
        
    }


    //stock span

    public static void stockSpan(int [] stock){
        Stack<Integer> s = new Stack<>();

        int span[] = new int[stock.length];

        s.push(0);

        span[0]=1;

        for(int i=1;i<stock.length;i++){
            int currPrice=stock[i];
            while(!s.isEmpty() && currPrice > stock[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                span[i]=i+1;
            }else{
                int prevHigh = s.peek();
                span[i]=i-prevHigh;
            }
            s.push(i);
        }
        System.out.println(Arrays.toString(span));
    }

    // Next Greater On RightSide Element

    public static void nextGreater(int arr[]){

        int nextGreater[] = new int[arr.length];

        Stack<Integer> s = new Stack<>();

        for(int i=arr.length-1;i>=0;i--){

            while(!s.isEmpty() && arr[s.peek()]<=arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nextGreater[i]=-1;
            }else{
                nextGreater[i]=arr[s.peek()];
            }
            s.push(i);
        }
        System.out.println(Arrays.toString(nextGreater));
    }

    // Similar Questions
    // next Greater left
    // next Smaller Right
    // next Smaller left


    // valid Parentheses
    public static boolean validParentheses(String str){
        Stack<Character> s = new Stack<>();

        for(int i=0;i<str.length();i++){
            char curr = str.charAt(i);
            if(curr=='(' || curr=='[' ||curr== '{'){
                s.push(curr);
            }else{
                if(s.isEmpty()){
                    return false;
                }
                if((curr==')' && s.peek()=='(')  ||  (curr==']' && s.peek()=='[') || (curr=='}' && s.peek()=='{')){
                    s.pop();
                }else{
                    return false;
                }
            }
           
        }

        if(s.isEmpty()){
            return true;
        }
        return false;
    }

    // Duplicate Parenthese 

    public static boolean duplicateParenthese(String str){

        Stack<Character> s = new Stack<>();

        if(!s.isEmpty() && s.peek()==')'){
            return false;
        }

        for(int i=0;i<str.length();i++){

            char curr = str.charAt(i);
           
            if(curr==')'){
                // assuming string is valid
                int count=0;
                while( s.pop()!='('){
                    count++;
                }
                if(count<1){
                    return true; // duplicate found
                }
            }else{
                // push opening and char
                s.push(curr);
            }
 
        }

       return false;
    }


    //Max area in Histogram

    public static int maxAreaHistogram(int heights[]){
        // next smaller left
        int nSleft[] = new int[heights.length];

        Stack<Integer> left = new Stack<>();
        

        for(int i=0;i<heights.length;i++){

            while(!left.isEmpty() && heights[left.peek()] >= heights[i]){
                left.pop();
            }
            if(left.isEmpty()){
                nSleft[i]=-1;
            }else{
                nSleft[i]=left.peek();
            }
            left.push(i);
        }

        // next smaller right

        int nSright[] = new int[heights.length];

        Stack<Integer> right = new Stack<>();

        for(int i=heights.length-1;i>=0;i--){

            while(!right.isEmpty() && heights[right.peek()] >= heights[i]){
                right.pop();
            }
            if(right.isEmpty()){
                nSright[i]=heights.length;
            }else{
                nSright[i]=right.peek();
            }
            right.push(i);
        }

        // width Calculation 

        int maxArea = Integer.MIN_VALUE;

        for(int i=0;i<heights.length;i++){
            int width = nSright[i]-nSleft[i]-1;
            int area = width*heights[i];
            maxArea=Math.max(maxArea, area);
        }
        return maxArea;
    }
}

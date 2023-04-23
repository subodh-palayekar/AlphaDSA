public class RecursionBasic{
    public static void main(String[] args) {
        int arr[] = {1,4,5,3,3,3,6,7,3};
        // System.out.println(lastOccur(arr, 0, 10));
        // System.out.println(optPower(2, 5));

        // System.out.println(tilling(4));
        
        // removeDuplicate(new boolean[26], 0, "abcccdddefghhh", new StringBuilder());

        System.out.println(friendsPair(2));
        printBinaryString(3, "", 0);
    }
    
    // printing number in Decreasing order
    public static void printDec(int n){
        if(n==1){
            System.out.print(1);
            return;
        }
        System.out.print(n+" ");
        printDec(n-1);
    }

    // printing number in Increasing order

    public static void printInc(int n){
        if(n==1){
            System.out.print(1+" ");
            return ;
        }
        printInc(n-1);
        System.out.print(n+" ");
    }

    public static int printIncrease(int n){
        if(n==1){
            return 1;
        }
        int prevNumber = printIncrease(n-1);
        System.out.println(prevNumber);
        return n;
    }


    // print factorial of n
    public static int factorial(int n){
        if(n==1 || n==0){
            return 1;
        }
        return n*factorial(n-1);
    }
    
    // print sum of n Natural Numbers

    public static int naturalSum(int n){
        if(n==1){
            return 1;
        }
        return n + naturalSum(n-1);
    }

    // print Nth fibbonaci Number

    public static int fibbonaci(int n){
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        return fibbonaci(n-1)+fibbonaci(n-2);
    }

    // Check if given array is sorted or not 

    public static boolean isSorted(int arr[] , int startIndex){
        if(startIndex==arr.length-1){
            return true;
        }
        if(arr[startIndex]>arr[startIndex+1]){
            return false;
        }
        return isSorted(arr, startIndex+1);
    }

    // first occurence of element in array

    public static int firstOccur(int arr[],int index,int key){
        if(arr[index] == key){
            return index;
        }
        if(index == arr.length-1){
            return -1;  
        }
        return firstOccur(arr, index+1, key);
    }

    // last occurence of element in array

    public static int lastOccur(int arr[],int index,int key){
        if(index==arr.length){
            return -1;
        }

        int ans = lastOccur(arr, index+1, key);

        if(ans==-1 && arr[index]==key){
          return index;
        }

        return ans;
    }
    // Base power n (bruteForce Approach  O(n)) 
    public static int power(int base,int n){
        if(n==0){
            return 1;
        }
        return base*power(base, n-1);
    }


    // Base power n (optimized Approach  O(logN))
    public static int optPower(int base,int n){
        if(n==0){
            return 1;
        }
        int halfPower = optPower(base,n/2);
        if(n%2==0){
            return halfPower*halfPower; 
        }else{
            return base*halfPower*halfPower;
        }
    }

    // Tiling problem (floor size 2*n) (tiles size 2*1) print number of ways to tile the floor
    public static int tilling(int n){
        if(n==0 || n==1){
            return 1;
        }

        int vertical = tilling(n-1);
        int horizontal = tilling(n-2);
        return vertical + horizontal;
    }

    // Remove duplicate from string - ( given String contains only lowercase characters )
    
    public static void removeDuplicate(boolean found[],int index,String given,StringBuilder result){
        
        if(index==given.length()){
            System.out.println(result);
            return;
        }
        // Duplicate found
        char currChar = given.charAt(index);
        if(found[currChar-'a']==true){
            removeDuplicate( found,index +1, given,result);
        }else{
            found[currChar-'a']=true;
            removeDuplicate(found,index+1, given, result.append(currChar));
        }
    }

    // Friends pair (n number of friends)

    public static int friendsPair(int n){
        if(n==1 || n==2){
            return n;
        }
        int single = friendsPair(n-1);
        int pair = friendsPair(n-2);
        int pairways = (n-1)*pair;
        return single+pairways;
    }

    // Print Binary String without consecutive 1's
    public static void printBinaryString (int size,String str,int lastDigit){

        if(size==0){
            System.out.println(str);     
            return;
        }

        printBinaryString(size-1, str+"0", 0);
        if(lastDigit==0){
          
            printBinaryString(size-1, str+"1", 1);
        }
            
           
    }



}
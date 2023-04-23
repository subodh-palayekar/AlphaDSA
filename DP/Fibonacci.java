public class Fibonacci{

    // fib normal recursive way O(2^n)

    public static int fib(int n){

        if(n==0 || n==1){
            return n;
        }

        return fib(n-1) + fib(n-2);
    }

    // fib  dp - memoization way O(n)

    public static int fibMemo(int n,int f[]){

        if(n==0 || n==1){
            return n;
        }

        if(f[n]!=0){        // reusing stored value
            return f[n];  
        }

        f[n] = fib(n-1)+fib(n-2); // storing the value

        return f[n];
    }

    // fib dp-tabulation way O(n)
    public static int fibTab(int n){
        
        int dp[] = new int[n+1]; // initialization
        dp[0]=0;
        dp[1]=1;

        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    } 


    public static void main(String[] args) {
        int n=6;
        // System.out.println(fib(n));

        int f[] = new int[n+1];

        // System.out.println(fibMemo(n, f));

        System.out.println(fibTab(n));
    }
}
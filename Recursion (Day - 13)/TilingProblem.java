public class TilingProblem{
    public static void main(String[] args) {
        System.out.println(tilling(3));
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
}
public class Pairs {
    public static void main(String[] args) {
        int arr[]= {2,3,4,5,1,6};
        printPairs(arr);
    }

    public static void printPairs(int arr[]) {

        int n= arr.length;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                System.out.print( " ["+arr[i] +","+arr[j]+"]");
            }
            System.out.println();
        }
        
    }
}

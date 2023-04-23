
public class Pattern{
    public static void main(String[] args) {
        int n=4;
        //  Star pattern pyramid
        // for(int i=1;i<=n;i++){
        //     for(int j=1;j<=i;j++){
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }


        //Inverted Star pattern-1

        // for(int i=1;i<=n;i++){
        //     for(int j=n;j>=i;j--){
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }

        //Inverted Star pattern-2

        // for(int i=1;i<=n;i++){
        //     for(int j=1;j<=n-i+1;j++){
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }

        //Number half Pyramid

        // for(int i=1;i<=n;i++){
        //     for(int j=1;j<=i;j++){
        //         System.out.print(j);
        //     }
        //     System.out.println();
        // }

        //Character Pyramid

        char ch='A';
    
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(ch);
                ch++;
            }
            System.out.println();
        }


    }
}
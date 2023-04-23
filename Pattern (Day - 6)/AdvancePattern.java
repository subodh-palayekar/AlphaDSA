public class AdvancePattern {
    public static void main(String[] args) {

        // Hollow  Reactangle
        int num1=5;
        // for(int i=1;i<=num1;i++){
        //     for(int j=0;j<=num1;j++){
        //         if(i==1 || i==num1 ||j==0 || j==num1 ){
        //             System.out.print("*");
        //         }else{
        //             System.out.print(" ");
        //         }
        //     }
        //     System.out.println();
        // }

        // Inverted and Rotated half Pyramid Pattern

        // for(int i=1;i<=num1;i++)
        // {
        //     for(int j=1;j<=num1-i;j++){

        //         System.out.print(" ");
        //     }
        //     for(int j=1;j<=i;j++){

        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }

        // Inverted Half Pyramid with Number Pattern

        // for(int i=1;i<=num1;i++){
        //     for(int j=1;j<=num1-i+1;j++){
        //         System.out.print(j);
        //     }
        //     System.out.println();
        // }

        // Flyod's Triangle pattern

        // int a=1;
        // for(int i=1;i<=num1;i++){
        //     for(int j=1;j<=i;j++){
        //         System.out.print(a+" ");
        //         a++;
        //     }
        //     System.out.println();
        // }

        //0-1 Triangle Pattern

        // for(int i=1;i<=num1;i++){
        //     for(int j=1;j<=i;j++){
        //         if((i+j)%2==0){
        //             System.out.print("1");
        //         }else{
        //             System.out.print("0");
        //         }
        //     }
        //     System.out.println();
        // }

        //ButterFly Pattern

        for(int i=1;i<=num1;i++){
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            for(int j=1;j<=2*(num1-i);j++){
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i=num1;i>0;i--){
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            for(int j=1;j<=2*(num1-i);j++){
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }

        // Rhombus Pattern

        // for(int i=1;i<=num1;i++){
        //     for(int j=1;j<=num1-i;j++){
        //         System.out.print(" ");
        //     }
        //     for(int j=1;j<=num1;j++){
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }
    
        // Hollow Rhombus Pattern

        // for(int i=1;i<=num1;i++){
        //     for(int j=1;j<num1-i+1;j++){
        //         System.out.print(" ");
        //     }
        //     for(int j=1;j<=num1;j++){
        //         if((i==1||i==num1||j==1||j==num1))
        //          System.out.print("*");
        //         else{
        //          System.out.print(" ");   
        //         }
        //     }
        //     System.out.println();
        // }

        // Diamond Pattern

        // for(int i=1;i<=num1;i++){
        //     for(int j=1;j<=num1-i;j++){
        //         System.out.print(" ");
        //     }
        //     for(int j=1;j<=2*i-1;j++){
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }
        // for(int i=num1;i>0;i--){
        //     for(int j=1;j<=num1-i;j++){
        //         System.out.print(" ");
        //     }
        //     for(int j=1;j<=2*i-1;j++){
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }

        //Number Pyramid Pattern

        // int counter=1;

        // for(int i=1;i<=num1;i++){
        //     for(int j=1;j<num1-i+1;j++){
        //         System.out.print(" ");
        //     }
        //     for(int j=1;j<=i;j++){
        //         System.out.print(counter+" ");
        //     }
        //     counter++;
        //     System.out.println();
        // }

        // Palindromic Pattern with Number Pattern
        // int counter2;
        
        // for(int i=1;i<=num1;i++){
        //     counter2=i;
        //     for(int j=1;j<num1-i+1;j++){
        //         System.out.print("  ");
        //     }
        //     int disp = 2;
        //     for(int j=1;j<=2*i-1;j++){ 
               
        //      if(counter2>=1){
        //         System.out.print(counter2+" ");
        //         counter2--;
        //      }
        //      else if(counter2<=0){
        //         System.out.print(disp+" ");
        //         disp++;
        //      }
        //     }
        //     System.out.println();
        // }
    }
}
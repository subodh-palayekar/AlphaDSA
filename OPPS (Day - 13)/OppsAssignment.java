public class OppsAssignment{
    public static void main(String[] args) {
        Complex num1 = new Complex(3,-6);
        Complex num2 = new Complex(4,10);
        
    //    Complex.diff(num1,num2);
       Complex e = Complex.addition(num1,num2);
       e.print();
      
}
    }

    
class Complex{
    int real;
    int imaginary;
     

    Complex(int real , int imaginary){
        this.real=real;
        this.imaginary = imaginary;
    }

    static void sum (Complex num1 , Complex num2 ,int real1 , int imaginary1 , int real2, int imaginary2){
        int totalReal = num1.real+num2.real;
        int totalImg = num1.imaginary+num2.imaginary;
        printComplex(totalReal, totalImg);
    }
    static  void diff (Complex num1 , Complex num2 ){
        int totalReal = num1.real-num2.real;
        int totalImg = num1.imaginary-num2.imaginary;
        printComplex(totalReal, totalImg);
    }
    static void multiplication (Complex num1 , Complex num2 ){
        int totalReal = num1.real*num2.real -(num1.imaginary*num2.imaginary);
        int totalImg = num1.real*num2.imaginary + num1.imaginary*num2.real;
        printComplex(totalReal, totalImg);
       
       
    }
    static Complex addition(Complex num1 , Complex num2 ){
        return new Complex( (num1.real+num2.real),(num1.imaginary+num2.imaginary));
    }
    static void printComplex(int totalReal,int totalImg){
        if(totalImg>0){
            System.out.println(totalReal+" + i"+totalImg);
        }else{
            System.out.println(totalReal+" - i"+ Math.abs(totalImg));
        }
    }
    void print(){
        if(imaginary>0){
            System.out.println(real+" + i"+imaginary);
        }else{
            System.out.println(real+" - i"+ Math.abs(imaginary));
        }
    }
    
 }
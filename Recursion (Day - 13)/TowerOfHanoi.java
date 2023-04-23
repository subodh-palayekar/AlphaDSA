public class TowerOfHanoi {
    public static void main(String[] args) {
        tower(3, "A", "B", "C");
    }
    
    // Tower of Hanoi
    public static void tower(int n,String source,String helper,String destination){
        if(n==1){
            System.out.println("Shift " + n + " from " + source + " to "+ destination);
            return;
        }
        tower(n-1, source, destination, helper);
        System.out.println("Shift " + n + " from " + source + " to "+ destination);
        tower(n-1, helper, source, destination);

    }
}

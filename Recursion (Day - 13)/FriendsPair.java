public class FriendsPair{
    public static void main(String[] args) {
        System.out.println(friendsPair(3));
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
}
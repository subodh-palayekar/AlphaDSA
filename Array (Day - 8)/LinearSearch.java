public class LinearSearch {
    public static void main(String[] args) {
        int arr[]={7,6,8,9,3};
        String menu[] = {"Dosa","Samosa","Maggie","Sandwich"};
        // int index = linearSearch(arr, 9);
        int index = linearSearch(menu, "Samosa");

        System.out.println(index);

    }

    // Time complexity O(n)
    public static int linearSearch (int arr[] , int key){
        int n= arr.length;
        for(int i=0;i<n;i++){
            if(arr[i]==key){
                return i;
            }
        }
        return -1;
    }

    public static int linearSearch(String menu[],String dish){
        int n = menu.length;
        for(int i=0;i<n;i++){
            if(menu[i]==dish){
                return i;
            }
        }
        return -1;
    }

}

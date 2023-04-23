import java.util.Arrays;

public class SortAssignment {
    public static void main(String[] args) {
        int arr[]={3,6,2,1,8,7,4,5,3,1};
        bubbleSort(arr);
        // countingSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    // Question 1 : Bubble sort

   public static void bubbleSort(int arr[]){
    int n=arr.length;
    for(int i=0;i<n-1;i++){
        for(int j=0;j<n-1-i;j++){
            if(arr[j]<arr[j+1]){
                int temp = arr[j];
                arr[j]=arr[j+1];
                arr[j+1]=temp;
            }
        }
    }
   }

   // Qustion 2 : Selection sort

   public static void selectionSort (int arr[]){
    int n=arr.length;
    for(int i=0;i<n;i++){
        int minIndex=i;
        for(int j=i+1;j<n;j++){
            if(arr[minIndex]<arr[j]){
                minIndex=j;
            }
        }
        int temp=arr[minIndex];
        arr[minIndex]=arr[i];
        arr[i]=temp;
    }
   }

   // Qustion 3 : Insertion sort
   public static void insertionSort(int arr[]){
    int n = arr.length;

    for(int i=1;i<n;i++){
        int curr = arr[i];
        int prev =i-1;
    while(prev>=0 &&arr[prev]<curr){
        arr[prev+1]=arr[prev];
        prev--;
    }
    arr[prev+1]=curr;
   }

   }

   // Question 4 : Counting sort

   public static void countingSort(int arr[]){
    int n=arr.length;
    int max=Integer.MIN_VALUE;
    for(int i=0;i<n;i++){
        max=Math.max(max, arr[i]);
    }

    int curr[]=new int[max+1];

    for(int i=0;i<n;i++){
        curr[arr[i]]++;
    }
    int j=0;
    for(int i=curr.length-1;i>=0;i--){
        while(curr[i]>0){
            arr[j]=i;
            j++;
            curr[i]--;
        }
    }
   }
}

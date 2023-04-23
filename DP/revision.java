import java.util.Arrays;

public class revision {

    public static int mergSort(int arr[],int si,int ei){
        if(si==ei){
            return 0;
        }
        int count=0;

        int mid = si + (ei-si)/2;

        count+=mergSort(arr, si, mid);
        count+=mergSort(arr, mid+1, ei);

        count+=merge(arr,si,ei,mid);

        return count;

    }


    public static int merge(int arr[],int si,int ei,int mid){
        int i=si;
        int j=mid+1;
        int temp[] = new int[(ei-si)+1];
        int k=0;
        int count=0;
        while(i<=mid && j<=ei){
            if(arr[i]<arr[j]){
                temp[k]=arr[i];
                i++;
            }else{
                temp[k]=arr[j];
                j++;
                count+=mid-i+1;

            }
            k++;
        }

        while(i<=mid){
            temp[k++]=arr[i++];
         
        }

        while(j<=ei){
            temp[k++]=arr[j++];
        
        }

        for(k=0 ,i=si;k<temp.length;k++,i++){
            arr[i]=temp[k];
        }
        return count;
    }
    public static void main(String[] args) {
        int []arr ={2,4,1,3,5};
       System.out.println( mergSort(arr, 0, arr.length-1));

        System.out.println(Arrays.toString(arr));


    }
}

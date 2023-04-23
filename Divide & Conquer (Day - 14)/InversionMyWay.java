public class InversionMyWay{
    public static void main(String[] args){

        int arr[]={5,5,5};
        System.out.println(inversion(arr, 0, arr.length-1));
    }

    public static int inversion(int arr[],int si , int ei){

        int count =0;
        if(ei>si){
            int mid = si +(ei-si)/2;
            count = inversion(arr, si, mid);
            count += inversion(arr, mid+1, ei);
            count += merge(arr, si,mid,ei);
        }
        return count;
    }

    public static int merge(int[] arr, int si, int mid, int ei) {
        int i=si;
        int j=mid+1;
        int k=0;
        int count=0;
        int[] temp = new int[(ei-si)+1];

        while(i<=mid && j<=ei){
            if(arr[i]<=arr[j]){
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
        for(i=si,k=0;k<temp.length;k++,i++){
            arr[i]=temp[k];
        }


        return count;
    }
}
import java.util.Arrays;

public class SumSegmentTree{

    // Query:- find Sum of number between index qi and qj
    static int tree[];

    public static void init(int n){
        tree = new int[4*n];
    }

    public static void buildST(int arr[] ,int i,int si,int sj ){   // given array,tree index,segment tree node range
        if(si==sj){
            tree[i]=arr[si];
            return;
        }
        int mid = si +(sj-si)/2;
        buildST(arr, 2*i+1, si, mid);
        buildST(arr, 2*i+2, mid+1, sj);
        tree[i]=tree[2*i+1]+tree[2*i+2];
        return;
    }

    public static int getSumQueryUtil(int arr[],int i,int si,int sj,int qi,int qj){

        
        if(qj<=si || qi>=sj){   // not overlap
            return 0 ;
        }else if(si>=qi && sj<=qj){ //complete overlap
            return tree[i];
        }else{  // partial overlap
            int mid = si +(sj-si)/2;
            int left = getSumQueryUtil(arr, 2*i+1, si, mid, qi, qj);
            int right = getSumQueryUtil(arr, 2*i+2, mid+1, sj, qi, qj);
            return left + right;
        }
    }

    public static int getSumQuery(int arr[],int qi,int qj){
        int n = arr.length;
        return getSumQueryUtil(arr, 0, 0,n-1, 2, 5);
    }


    public static void updateUtil(int indexUpdated,int i,int si,int sj,int diff){

        if(indexUpdated<si || indexUpdated >sj){  //not in range
            return;
        }
        tree[i]+=diff; 
        if(si!=sj){  // non-leaf node
            int mid = si +(sj-si)/2;
            updateUtil(indexUpdated, 2*i+1, si, mid, diff); //left
            updateUtil(indexUpdated, 2*i+2, mid+1, sj, diff);  //right
        }

    }
    public static void update(int arr[],int indexUpdated,int newValue){
        int n = arr.length;
        int diff = newValue - arr[indexUpdated];
        arr[indexUpdated]=newValue;

        updateUtil(indexUpdated, 0, 0, n-1, diff);
    }


    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8};
        int n = arr.length;
        init(n);
        buildST(arr, 0, 0, n-1);

        // System.out.println(Arrays.toString(tree));

        System.out.println(getSumQuery(arr, 2, 5));

        // update
        update(arr, 2, 2);
        System.out.println(getSumQuery(arr, 2, 5));
        

    }
}
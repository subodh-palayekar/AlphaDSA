import java.util.*;

public class MaxSegmentTree {

    static int tree[];
    public static void init(int n){
        tree = new int[4*n];
    }

    public static void buildST(int arr[],int i,int si,int sj){
        if(si==sj){
            tree[i]=arr[si];
            return;
        }
        int mid = si + (sj-si)/2;
        buildST(arr, 2*i+1, si, mid);
        buildST(arr, 2*i+2, mid+1, sj);
        tree[i]=Math.max(tree[2*i+1],tree[2*i+2]);
    }
    public static int getMaxQueryUtil(int i ,int qi,int qj,int si,int sj){

        if(qj<si || qi>sj){  //not-overlap
            return Integer.MIN_VALUE;  
        }else if(si>=qi && sj<=qj){  // Completely Overlap
            return tree[i];
        }else{  // partial overlap
            int mid = si + (sj-si)/2;
            int left = getMaxQueryUtil(2*i+1, qi, qj, si, mid);
            int right = getMaxQueryUtil(2*i+2, qi, qj, mid+1, sj);
            return Math.max(left, right);
        }

    }
    public static void updateUtil(int i ,int si,int sj,int indexUpdated,int newValue){
        if(indexUpdated<si || indexUpdated>sj){
            return;
        }
        if(si==sj){
            tree[i]=newValue;
        }

        if(si!=sj){
            tree[i]=Math.max(tree[i], newValue);
            int mid = si +(sj-si)/2;
            updateUtil(2*i+1, si, mid, indexUpdated, newValue);
            updateUtil(2*i+2, mid+1, sj, indexUpdated, newValue);
        }

    }

    public static void update(int arr[],int indexUpdated,int newValue){
     
        int n = arr.length;
        arr[indexUpdated]= newValue;
        updateUtil(0, 0, n-1, indexUpdated, newValue);
    }

    public static int getMaxQuery(int arr[],int qi,int qj){
        int n = arr.length;
        return getMaxQueryUtil(0,qi,qj,0,n-1);
    }
    public static void main(String[] args) {
        int arr[] ={6,8,-1,2,17,1,3,2,4};

        int n = arr.length;
        init(n);
        buildST(arr, 0, 0, n-1);

        System.out.println(Arrays.toString(tree));

        System.out.println(getMaxQuery(arr, 2, 5));

        //update
        update(arr, 3, 20);

        System.out.println(getMaxQuery(arr, 2, 5));

    }
}

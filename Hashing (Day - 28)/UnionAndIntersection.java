import java.util.HashSet;

public class UnionAndIntersection {
    public static void main(String[] args) {
        int arr1[] = {7,3,9};
        int arr2[] = {6,3,9,2,9,4};

        HashSet<Integer> union = new HashSet<>();

        for(int i=0;i<arr1.length;i++){
            union.add(arr1[i]);
        }

        for(int i=0;i<arr2.length;i++){
            union.add(arr2[i]);
        }

        System.out.println(union);
        System.out.println(union.size());


        HashSet<Integer> intersection = new HashSet<>();

        for(int i=0;i<arr1.length;i++){
            intersection.add(arr1[i]);
        }

        int count=0;
        for(int i=0;i<arr2.length;i++){
            if(intersection.contains(arr2[i])){
                count++;
                intersection.remove(arr2[i]);
            }
        }
        System.out.println(count);

    }
}

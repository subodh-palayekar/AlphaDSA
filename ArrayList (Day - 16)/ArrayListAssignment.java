import java.util.ArrayList;
import java.util.Collections;

public  class ArrayListAssignment {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(2);
        list.add(2);
         
        list.add(2);
        list.add(2);
        list.add(3);
        // System.out.println(list);
        System.out.println(isMonotonic(list));
        // System.out.println(lonleyNumber(list));
        // System.out.println(maxFreNumKey (list, 1));
    }

    public static boolean isMonotonic (ArrayList<Integer> list){
        int inCount=0;
        int deCount=0;
        for(int i=0;i<list.size()-1;i++){
            if(list.get(i)<=list.get(i+1)){
              inCount++;
            }
            if(list.get(i)>=list.get(i+1)){
                deCount++;
            }
        }
        // for(int i=0;i<list.size()-1;i++){
        //     if(list.get(i)>=list.get(i+1)){
        //         deCount++;
        //     }
        // }
        if(inCount==list.size()-1 ||deCount==list.size()-1){
            return true;
        }
        return false;

    }

    public static ArrayList<Integer> lonleyNumber(ArrayList<Integer> list){
       
        Collections.sort(list);
        ArrayList<Integer> ans = new  ArrayList<>();

        for(int i=1;i<list.size()-1;i++){

            if(list.get(i-1)+1<list.get(i) && list.get(i)+1 <list.get(i+1)){
    
                ans.add(list.get(i));
                
            }
        }
        if(list.size()==1){
            ans.add(list.get(0));
        }
        if(list.size()>1){
            if(list.get(0)+1< list.get(1)){
                ans.add(list.get(0));
            }
            if(list.get(list.size()-2)+1<list.get(list.size()-1)){
                ans.add(list.get(list.size()-1));
            }

        }
        return ans;
    }
    public static int maxFreNumKey(ArrayList<Integer> list , int key){

       int [] targetList = new int[1000];
       int max= Integer.MIN_VALUE;
       int ans=0;
       
        for(int i=0;i<list.size()-1;i++){
            if(list.get(i)==key){
                targetList[list.get(i+1)-1]++;  
            }
        }

        for(int i=0;i<1000;i++){
            if(targetList[i]>max){
                max=targetList[i];
                ans=i+1;
            }
        }
        return ans;
    }
}

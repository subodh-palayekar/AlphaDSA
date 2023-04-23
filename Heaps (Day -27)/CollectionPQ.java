import java.util.*;
public class CollectionPQ{

    static class Student implements Comparable<Student> {
        int rank;
        String name;

        public Student(int rank, String name){
            this.rank=rank;
            this.name=name;
        }
        @Override
        public int compareTo(Student s2){
            return this.rank - s2.rank;
        }
    }
    public static void main(String[] args) {

        // PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(1);
        pq.add(7);
        pq.add(80);
        pq.add(0);

        // while(!pq.isEmpty()){
        //     System.out.println(pq.peek());
        //     pq.remove();
        // }


        PriorityQueue<Student> std = new PriorityQueue<>();

        std.add(new Student(2, "jack"));
        std.add(new Student(1000, "Jim"));
        std.add(new Student(60, "Tom"));
        std.add(new Student(83, "harry"));


        while(!std.isEmpty()){
            System.out.println(std.peek().rank);
            std.remove();
        }

    }
}
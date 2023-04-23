public class SortedMatrixSearch {
    public static void main(String[] args) {
        int matrix[][]={{10,20,30,40},
                        {15,25,35,45},
                        {27,29,37,48},
                        {32,33,39,50}};
        
        
        System.out.println(stairCaseSearch2(matrix, 20));
        
    }


    // Considering top Right corner as starting point
    public static boolean stairCaseSearch(int matrix[][],int key){
        int n = matrix.length;

       
        int row=0; // startRow
        int column=n-1; //endColumn

        while(row<n && column>=0){
            if(key==matrix[row][column]){
                System.out.println("key found at "+row+" "+column);
                return true;
            }
           
            if(key<matrix[row][column]){
                column--;   // left shift
            }else if(key>matrix[row][column]){
                row++;   // bottom shift
            } 

        }
        System.out.println("key not found");
        return false;
    }
    // Considering bottom left corner as starting point
    public static boolean stairCaseSearch2(int matrix[][],int key){
        int n = matrix.length;

       
        int row=n-1; // endRow
        int column=0; // startColumn

        while(row>=0 && column<n){
            if(key==matrix[row][column]){
                System.out.println("key found at "+row+" "+column);
                return true;
            }
           
            if(key<matrix[row][column]){
                row--;   // left shift
            }else if(key>matrix[row][column]){
                column++;   // bottom shift
            } 

        }
        System.out.println("key not found");
        return false;
    }
}

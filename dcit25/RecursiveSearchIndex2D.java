
package dcit25;

/**
 *
 * @author Brice
 */
public class RecursiveSearchIndex2D {
    public static void main(String[] args){
        int A[][] = {{1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15}};
        
        System.out.println(RecursiveSearchIndex2D.searchIndex(A, 1));
    }
    
    private static boolean searchIndex(int A[][], int e){
        return searchIndex(A, e, 0, 0);
    }
    private static boolean searchIndex(int A[][], int e, int i, int j){
        if(A[i][j] == e){
            return true;
        }
        if(i < A[i].length -1){
            return searchIndex(A, e, i, j+1);
        }else{
            return false;
        }
    }
    
}

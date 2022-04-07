
package dcit25;

/**
 *
 * @author Brice
 */
public class RecursiveSearchIndex {
    public static void main(String[] args){
        int A[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        
        System.out.println(RecursiveSearchIndex.searchIndex(A, 1));
    }
    
    private static int searchIndex(int A[], int e){
        return searchIndex(A, e, 0);
    }
    private static int searchIndex(int A[], int e, int i){
        if(A[i] == e){
            return i;
        }
        if(i < A.length -1){
            return searchIndex(A, e, i+1);
        }else{
            return -1;
        }
    }
    
}

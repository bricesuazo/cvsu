
package dcit25;
/**
 *
 * @author Brice
 */
public class BinarySearch2D {
    public static int search(int[][] arr, int x){
        for (int i = 0; i < arr.length; i++) {
            int lo = 0;
            int hi = arr[i].length - 1;
            
            while(lo <= hi){
                int mid = lo + (hi - lo) / 2;
                if (arr[i][mid] == x) {
                    return i * arr[i].length + mid;
                }
                if (arr[i][mid] > x) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
        }
        
        return -1;
    }
 
    public static void main (String[] args) throws java.lang.Exception{
        int A[][] = {
            { 1,  6,  7,  9},
            { 9, 13, 15, 17},
            {18, 21, 33, 43},
            {45, 65, 76, 80}
        };
        
        System.out.println(BinarySearch2D.search(A, 13));
    }
}


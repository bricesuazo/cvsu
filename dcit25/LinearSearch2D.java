
package dcit25;
/**
 *
 * @author Brice
 */
public class LinearSearch2D {
    public static int search(int[][] arr, int x){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++){
                if(arr[i][j] == (x)){
                    return i * arr[i].length + j;
                }
            }
        }
        return -1;
    }
}

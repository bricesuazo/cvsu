
package dcit25;
/**
 *
 * @author Brice
 */
public class SelectionSort2D {
    public static void sort(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                for (int k = 0; k < arr.length; k++) {
                    for (int l = 0; l < arr[k].length; l++) {
                        if(arr[i][j] < arr[k][l]){
                            int temp = arr[i][j];
                            arr[i][j] = arr[k][l];
                            arr[k][l] = temp;
                        }
                    }
                }
            }
        }
    }
 
    public static void main (String[] args) throws java.lang.Exception
    {
        int A[][] = {
            {13, 17, 43, 76},
            {18, 14,  9, 21},
            {4, 2,  3, 1},
        };
       
        for(int[] rows: A){
            for(Integer a: rows){
                System.out.print(a + " ");
            }
            System.out.println();
        }

        System.out.println();

        SelectionSort2D.sort(A);

        for(int[] rows: A){
            for(Integer a: rows){
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }
}


//  sorting by row
//    public static void sort(int[][] arr){
//        for (int[] outer : arr) {
//            for (int i = 0; i < outer.length - 1; i++) {
//                int k = outer[i];
//                for (int j = i + 1; j < outer.length; j++) {
//                    if (k > outer[j]) {
//                        k = outer[j];
//                    }
//                }
//                int temp = outer[i];
//                for (int l = 0; l < outer.length; l++) {
//                    if (k == outer[l]) {
//                        outer[l] = temp;
//                    }
//                }
//                outer[i] = k;
//            }
//        }
//    }
package dcit25;
import java.util.Scanner;

public class FindInGroup {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String firstLine[] = in.nextLine().trim().split("\\s+");
        int noOfGroup = Integer.parseInt(firstLine[0]);
        int noOfSearch = Integer.parseInt(firstLine[1]);

        if(noOfGroup == 0 || noOfSearch == 0) {
            for(int i = 0; i < noOfSearch; i++){
                System.out.println(-1);
            }
        }else{
            String secondLine[] = in.nextLine().trim().split("\\s+");

            int data[][] = new int[noOfGroup][];

            for (int i = 0; i < data.length; i++) {
                if (secondLine[i].isEmpty() || secondLine[i].equals("")) {
                    for (int j = 0; j < noOfSearch; j++) {
                        System.out.println(-1);
                    }
                    System.exit(0);
                }else{
                    data[i] = new int[Integer.parseInt(secondLine[i])];
                }
            }

            // storing all inputs to data[][]
            for (int[] data1 : data) {
                if(data1.length != 0){
                    String thirdLine[] = in.nextLine().trim().split("\\s+");
                    for (int j = 0; j < data1.length; j++) {
                        int temp = Integer.parseInt(thirdLine[j]);
                        data1[j] = temp;
                    }
                }
            }

            // sorting: selection sort
            FindInGroup.SelectionSort2D(data);

            int output[] = new int[noOfSearch];
            // search: binary search
            for (int i = 0; i < noOfSearch; i++) {
                int search = in.nextInt();
                output[i] = FindInGroup.BinarySearchRecursive2D(data, search);
            }

            // printing all data
            for (int output1 : output) {
                System.out.println(output1);
            }
        }
    }

    private static void SelectionSort2D(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                for (int k = i; k < arr.length; k++) {
                    for (int l = j; l < arr[k].length; l++) {
                        if (arr[i][j] > arr[k][l]) {
                            swap(arr[i], j, l);
                        }
                    }
                    break;
                }
            }
        }
    }
    // helper method: swapping elements of array
    private static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static int BinarySearchRecursive2D(int arr[][], int search) {
        if (arr.length == 0) {
            return -1;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!(BinarySearchRecursive2D(arr, search, 0, arr[i].length - 1, i) == -1)) {
                return BinarySearchRecursive2D(arr, search, 0, arr[i].length - 1, i);
            }
        }
        return -1;
    }

    private static int BinarySearchRecursive2D(int arr[][], int search, int lo, int hi, int i) {
        if (hi >= lo) {
            int mid = lo + (hi - lo) / 2;
            if (arr[i][mid] == search) {
                return i + 1;
            } else if (arr[i][mid] > search) {
                return BinarySearchRecursive2D(arr, search, lo, mid - 1, i);
            } else {
                return BinarySearchRecursive2D(arr, search, mid + 1, hi, i);
            }
        } else {
            return -1;
        }
    }

}

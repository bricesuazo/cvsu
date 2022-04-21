package dcit25;

public class CountingSort {
    public static void main(String[] args) {
        int arr[] = {4, 6, 1, 0, 2, 8, 9, 12, 0, 10, 2};
        System.out.print("Given Array:  ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        
        int max = 0;
        for (int i : arr) {
            if(max < i){
                max = i;
            }
        }
        
        CountingSort(arr, max);
        
        System.out.print("Sorted Array: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    
    private static void CountingSort(int arr[], int max){
        int indexArr[] = new int[max+1];
        for (int i = 0; i < arr.length; i++) {
            indexArr[arr[i]]++;
        }

        for (int i = 1; i < indexArr.length; i++) {
            indexArr[i] = indexArr[i-1] + indexArr[i];
        }

        int temp[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            temp[indexArr[arr[i]]-1] = arr[i];
            indexArr[arr[i]]--;
        }
        System.arraycopy(temp, 0, arr, 0, arr.length);
    }
}

import java.util.Scanner;

public class SortaWhat {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int firstLine = in.nextInt();
        int arr[] = new int[firstLine], arrPos[] = new int[firstLine];
        
        in.nextLine();
        if(arr.length != 0 && arrPos.length != 0){
            String secondLine[] = in.nextLine().trim().split("\\s+"); 
            String thirdLine[] = in.nextLine().trim().split("\\s+");
            
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(secondLine[i]);
            }
            for (int i = 0; i < arrPos.length; i++) {
                arrPos[i] = Integer.parseInt(thirdLine[i]);
            }
            int sortedArr[] = new int[arr.length];
            System.arraycopy(arr, 0, sortedArr, 0, arr.length);
            mergesort(sortedArr);
            
            int matched = 0;
            try {
                for (int i = 0; i < arr.length; i++) {
                    if(sortedArr[arrPos[i]] == arr[i]){
                        matched++;
                    }
                }
            }catch(ArrayIndexOutOfBoundsException e){
                
            }
            if(matched == arr.length){
                System.out.println("Sorta Right");
            }else{
                System.out.println("Sorta Wrong");
            }
        }
            
    }
    
    private static void mergesort(int arr[]){
        mergesort(arr, 0, arr.length-1);
    }
    
    private static void mergesort(int arr[], int left, int right){
        if (right > left){
            int mid = (right + left) / 2;
            mergesort(arr, left, mid);
            mergesort(arr, mid + 1, right);
            merge(arr, left, mid + 1, right);
        }
    }
    
    private static void merge(int [] arr, int left, int mid, int right){
        int [] temp = new int[arr.length];
        int i, leftEnd, numElements, tmpPos;
    
        leftEnd = mid - 1;
        tmpPos = left;
        numElements = right - left + 1;
    
        while (left <= leftEnd && mid <= right){
            if (arr[left] <= arr[mid]){
                temp[tmpPos++] = arr[left++];
            }else{
                temp[tmpPos++] = arr[mid++];
            }
        }

        while (left <= leftEnd){
            temp[tmpPos++] = arr[left++];
        }

        while (mid <= right){
            temp[tmpPos++] = arr[mid++];
        }
 
        for (i = 0; i < numElements; i++){
            arr[right] = temp[right];
            right--;
        }
    }
}

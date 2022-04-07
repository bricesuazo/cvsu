package dcit25;

public class RecursiveDivisible {
    public static void main(String[] args){
        int A[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        
        RecursiveDivisible.divisible(A, 2);
        
    }
    
    public static int divisible(int A[], int d){
        return divisible(A, d, 0);
    }
    public static int divisible(int A[], int d, int i){
        if(A[i] % d == 0){
            System.out.println(A[i]);
        }
        if (i < A.length - 1){
            return divisible(A, d, i + 1);
        }
        return -1;
    }
}

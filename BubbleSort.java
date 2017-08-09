import java.util.*;
 
public class BubbleSort {
    public int[] bubbleSort(int[] A, int n) {
         
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n-1-i; j++){
                if(A[j]> A[j+1]){
                    int temp = A[j];
                    A[j] = A[j+1];
                    A[j+1] = temp;
                }
            }
             
        }
        return A;
    }
}
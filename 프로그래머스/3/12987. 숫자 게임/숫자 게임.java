import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int n = A.length;
        for(int i=0; i<n/2; i++){
            int temA = A[i];
            int temB = B[i];
            A[i] = A[n-1-i];
            B[i] = B[n-1-i];
            A[n-1-i] = temA;
            B[n-1-i] = temB;
        }
        
        int j = 0;
        int answer = 0;
        for(int i=0; i<n; i++){
            while(j<n && A[j]>=B[i]){
                j++; 
            }
            if(j>=n)
                break;
            j++;
            answer++;
        }
        return answer;
    }
}
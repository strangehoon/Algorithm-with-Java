>  문제 : [GenomicRangeQuery](https://app.codility.com/programmers/lessons/5-prefix_sums/genomic_range_query/)</br>
유형 : Lesson 5(Prefix Sums) </br>

# GenomicRangeQuery
누적합 개념을 사용한다.

```java
class Solution {
    public int[] solution(String S, int[] P, int[] Q) {
        int strLen = S.length();
        int[][] preSum = new int[4][strLen+1];
        int[] answer = new int[P.length];

        for(int i=1; i<=strLen; i++){
            for(int j=0; j<4; j++){
                preSum[0][i] = preSum[0][i-1];
                preSum[1][i] = preSum[1][i-1];
                preSum[2][i] = preSum[2][i-1];
                preSum[3][i] = preSum[3][i-1];
            }
            char ch = S.charAt(i-1);
            switch (ch){
                case 'A':
                    preSum[0][i]++;
                    break;
                case 'C':
                    preSum[1][i]++;
                    break;
                case 'G':
                    preSum[2][i]++;
                    break;
                case 'T':
                    preSum[3][i]++;
            }
        }


        for(int i=0; i<P.length; i++){
            int p = P[i]+1;
            int q = Q[i]+1;
            int Adiff = preSum[0][q]-preSum[0][p-1];
            int Cdiff = preSum[1][q]-preSum[1][p-1];
            int Qdiff = preSum[2][q]-preSum[2][p-1];
            int Tdiff = preSum[3][q]-preSum[3][p-1];
            if(Adiff!=0)
                answer[i] = 1;
            else if(Cdiff!=0)
                answer[i] = 2;
            else if(Qdiff!=0)
                answer[i] = 3;    
            else if(Tdiff!=0)
                answer[i] = 4;    
        }
        return answer;
    }
}
```

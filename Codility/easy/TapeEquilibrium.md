>  문제 : [TapeEquilibrium](https://app.codility.com/programmers/lessons/3-time_complexity/tape_equilibrium/) </br>
유형 : Lesson 3(Time Complexity) </br>




# TapeEquilibrium
누적합 사용해서 O(n)으로 풀면된다.

```java
import java.util.*;

class Solution {
    public int solution(int[] A) {
        int n = A.length;
        int[] preSum = new int[n+1];

        for(int i=1; i<=n; i++){
            preSum[i] = A[i-1]+preSum[i-1];
        }

        int totalSum = preSum[n];
        int minValue = Integer.MAX_VALUE;
        for(int i=1; i<n; i++){
            int tem = totalSum-preSum[i];
            int diff = Math.abs(tem-preSum[i]);
            minValue = Math.min(diff, minValue);
        }

        return minValue;

    }
}


```

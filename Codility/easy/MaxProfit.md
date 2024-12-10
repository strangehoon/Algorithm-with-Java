>  문제 : [MaxProfit](https://app.codility.com/programmers/lessons/9-maximum_slice_problem/max_profit/)</br>
유형 : Lesson 9(Maximum slice problem) </br>

# MaxProfit
최소값 minValue 변수의 초기값을 A[0]으로 선언한다. 그 다음 순차적으로 배열을 순회하며 현재 인덱스를 최대값으로 가정하여 share(최대-최소)를 갱신하고 minValue도 갱신해준다.

```java
import java.util.*;

class Solution {
    public int solution(int[] A) {
        if(A.length==0)
            return 0;
        int minValue = A[0];
        int share = Integer.MIN_VALUE;
        for(int i=1; i<A.length; i++){
            share = Math.max(share, A[i]-minValue);
            if(minValue>A[i])
                minValue = A[i];
        }
        if(share>0)
            return share;
        else
            return 0;
    }
}
```

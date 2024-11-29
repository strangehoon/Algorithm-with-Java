>  문제 : [PermMissingElem](https://app.codility.com/programmers/lessons/3-time_complexity/perm_missing_elem/) </br>
유형 : Lesson 3(Time Complexity) </br>



# PermMissingElem
형변환 연산에 주의하자. 단순히 long 자료형을 사용한다고 해결되지 않는다. (long)이 없으면 (n+1)*(n+2) 연산에서 오버플로우가 발생한다.


```java
import java.util.*;

class Solution {
    public int solution(int[] A) {
        int n = A.length;
        long sum = (long)(n+1)*(n+2)/2;
        long sumA = 0;

        for(int i=0; i<n; i++){
            sumA += A[i];
        }

        return (int)(sum-sumA);
    }
}
```

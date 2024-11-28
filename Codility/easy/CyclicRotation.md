>  문제 : [CyclicRotation](https://app.codility.com/programmers/lessons/2-arrays/cyclic_rotation/) </br>
유형 : Lesson 1(Arrays) </br>

# CyclicRotation

덱 자료구조를 활용해서 풀었다. 대안으로는 1차원 배열에서 shift 연산을 구현해주면 된다.

```java
import java.util.*;

class Solution {
    public int[] solution(int[] A, int K) {
        
        Deque<Integer> dq = new ArrayDeque<>();
        int[] answer = new int[A.length];
        for(int i=0; i<A.length; i++){
            dq.offerLast(A[i]);
        }

        while(K-->0 && !dq.isEmpty()){
            dq.offerFirst(dq.pollLast());
        }

        int idx = 0;
        while(!dq.isEmpty()){
            answer[idx++] = dq.pollFirst();
        }

        return answer;

    }
}
```

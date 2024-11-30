>  문제 : [TieRopes](https://app.codility.com/programmers/lessons/16-greedy_algorithms/tie_ropes/)</br>
유형 : Lesson 16(Greedy) </br>

# TieRopes
그리디 유형의 문제다. for문으로 순차탐색 하면서 sum이 K보다 크거나 같으면 카운트하고 sum을 다시 0으로 초기화하면 된다.


```java
import java.util.*;


class Solution {
    public int solution(int K, int[] A) {
        int sum = 0;
        int cnt = 0;
        for(int i=0; i<A.length; i++){
            sum += A[i];
            if(sum>=K){
                sum = 0;
                cnt ++;
            }
        }
        return cnt;
    }
}
```

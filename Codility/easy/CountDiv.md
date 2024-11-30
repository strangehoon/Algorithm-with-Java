>  문제 : [CountDiv](https://app.codility.com/programmers/lessons/5-prefix_sums/count_div/)</br>
유형 : Lesson 5(Prefix Sums) </br>

# CountDiv
숫자의 범위가 20억까지이므로 순차탐색으로 풀면 안된다. 수식으로 O(1)로 풀면 된다.
```java
class Solution {
    public int solution(int A, int B, int K) {
        int answer = B/K -A/K;
        return A%K==0 ? answer+1 : answer; 
    }
}
```

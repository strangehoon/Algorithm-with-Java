>  문제 : [MissingInteger](https://app.codility.com/programmers/lessons/4-counting_elements/missing_integer/)</br>
유형 : Lesson 4(Counting Elements) </br>


# MissingInteger
for 문으로 순차탐색(O(N))하면 된다.

```java
import java.util.*;

class Solution {
    public int solution(int[] A) {
        Arrays.sort(A);
        int num = 1;

        for(int i=0; i<A.length; i++){
            if(num<A[i]){
                return num;
            }
            else if(num==A[i]){
                num++;
            }
        }
        return num;
    }
}


```

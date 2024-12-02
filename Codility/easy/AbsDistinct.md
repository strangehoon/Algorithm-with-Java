>  문제 : [AbsDistinct](https://app.codility.com/programmers/lessons/15-caterpillar_method/abs_distinct/) </br>
유형 : Lesson 15(Caterpillar method) </br>

# AbsDistinct
HashSet에 절대값을 넣어 풀었다.

```java
import java.util.*;

class Solution {
    public int solution(int[] A) {
        HashSet<Integer> set = new HashSet<>();

        for(int a : A){
            set.add(Math.abs(a));
        }

        return set.size();
    }
}
```

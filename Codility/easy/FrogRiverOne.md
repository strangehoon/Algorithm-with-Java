>  문제 : [FrogRiverOne](https://app.codility.com/programmers/lessons/4-counting_elements/frog_river_one/)</br>
유형 : Lesson 4(Counting Elements) </br>

#  FrogRiverOne
Set 자료구조를 활용하면 된다.

```java
import java.util.*;

class Solution {
    public int solution(int X, int[] A) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=1; i<=X; i++){
            set.add(i);
        }

        int answer = -1;
        for(int i=0; i<A.length; i++){
            if(set.contains(A[i])){
                set.remove(A[i]);
            }
            
            if(set.size()==0){
                answer = i;
                break;
            }
        }
        return answer;
    }
}
```

>  문제 : [OddOccurrencesInArray](https://app.codility.com/programmers/lessons/2-arrays/odd_occurrences_in_array/) </br>
유형 : Lesson 2(Arrays) </br>


# OddOccurrencesInArray
HashSet 자료구조를 활용하여 set에 원소가 있으면 기존 원소 삭제, set에 원소가 없으면 추가하는 방식으로 구현하면 된다,

```java
import java.util.*;

class Solution {
    public int solution(int[] A) {
        HashSet<Integer> set = new HashSet<>();

        for(int i=0; i<A.length; i++){
            if(set.contains(A[i])){
                set.remove(A[i]);
            }
            else{
                set.add(A[i]);
            }
        }
        int answer = 0;
        Iterator iter = set.iterator();
        while(iter.hasNext()){          
	        answer = (int)(iter.next());
        }
        return answer;
    }
}
```

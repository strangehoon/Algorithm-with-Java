>  문제 : [CountDistinctSlices](https://app.codility.com/programmers/lessons/15-caterpillar_method/count_distinct_slices/)</br>
유형 : Lesson 15(Caterpillar method) </br>

# CountDistinctSlices
투포인터 활용 문제, left, right 인덱스를 잘 조절해주면 된다.

```java
import java.util.*;

class Solution {
    public int solution(int M, int[] A) {
        
        int left = 0;
        int right = 0;
        HashSet<Integer> set = new HashSet<>();
        int cnt = 0;
        while(right<A.length){
            if(set.contains(A[right])){
                set.remove(A[left]);
                left++;
            }
            else{
                set.add(A[right]);
                cnt += (right-left+1);
                right++;
                if(cnt>=1000000000)
                    return 1000000000;
            }
        }
        return cnt;
    }
}
```

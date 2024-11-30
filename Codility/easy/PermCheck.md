>  문제 : [PermCheck](https://app.codility.com/programmers/lessons/4-counting_elements/perm_check/)</br>
유형 : Lesson 4(Counting Elements) </br>


# PermCheck
set 자료구조를 활용하면 된다.

```java
import java.util.*;

class Solution {
    public int solution(int[] A) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=1; i<=A.length; i++){
            set.add(i);
        }
        boolean flag = true;
        for(int i=0; i<A.length; i++){
            if(set.contains(A[i])){
                set.remove(A[i]);
            }
            else{
                flag = false;
                break;
            }
        }
        return flag==true ? 1 : 0;
    }
}
```

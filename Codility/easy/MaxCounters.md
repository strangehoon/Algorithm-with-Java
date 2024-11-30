>  문제 : [MaxCounters](https://app.codility.com/programmers/lessons/4-counting_elements/max_counters/)</br>
유형 : Lesson 4(Counting Elements) </br>


# MaxCounters
max counter 연산을 수행할 때 for문을 다시 돌리면 전체 시간복잡도가 O(N^2)이 되어 시간초과 판정이 뜸을 유의하자.

```java
class Solution {
    public int[] solution(int N, int[] A) {
        int[] arr = new int[N];
        int maxValue = 0;
        int std = 0;

        for(int i=0; i<A.length; i++){
            int num = A[i]-1;
            if(num==N){
                std = maxValue;
            }
            else{
                if(arr[num]<std){
                    arr[num] = std;
                }
                arr[num]++;
                maxValue = Math.max(maxValue, arr[num]);
            }
        }

        for(int i=0; i<arr.length; i++){
            if(arr[i]<std){
                arr[i] = std;
            }
        }

        return arr;
    }
}
```

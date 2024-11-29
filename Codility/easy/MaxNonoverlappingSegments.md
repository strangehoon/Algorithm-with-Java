>  문제 : [MaxNonoverlappingSegments](https://app.codility.com/programmers/lessons/16-greedy_algorithms/max_nonoverlapping_segments/)</br>
유형 : Lesson 16(Greedy) </br>

# MaxNonoverlappingSegments
그리디 알고리즘, 강의실 배정 문제의 일종이다. 1)하나의 강의실에 최대한 많은 강의를 담기, 2)가장 적은 강의실을 이용하기 유형이 있는데 전자가 이 문제에 해당한다.

```java
class Solution {
    public int solution(int[] A, int[] B) {
        
        int nowEnd = -1;
        int cnt = 0;
        for(int i=0; i<B.length; i++){
            if(A[i]>nowEnd){
                nowEnd = B[i];
                cnt++;
            }
        }
        return cnt;
    }
}
```

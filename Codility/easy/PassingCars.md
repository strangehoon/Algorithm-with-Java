>  문제 : [PassingCars](https://app.codility.com/programmers/lessons/5-prefix_sums/passing_cars/)</br>
유형 : Lesson 5(Prefix Sums) </br>


# PassingCars
이중 for문 사용하면 O(N^2)으로 시간 초과 발생, 따라서 누적합을 사용하면 된다.
```java
class Solution {
    public int solution(int[] A) {
        int len = A.length;
        int[] preSum = new int[len];
        preSum[0] = A[0];

        for(int i=1; i<len; i++){
            preSum[i] = preSum[i-1] + A[i];
        }

        int cnt = 0;
        for(int i=0; i<len; i++){
            if(A[i]==0){
                cnt += preSum[len-1] - preSum[i];
                if(cnt>1000000000)
                    return -1;
            }
        }
        return cnt;
    }
}
```

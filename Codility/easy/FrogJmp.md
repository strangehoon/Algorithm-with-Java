>  문제 : [FrogJmp](https://app.codility.com/programmers/lessons/3-time_complexity/frog_jmp/start/) </br>
유형 : Lesson 3(Time Complexity) </br>

# FrogJmp
수식을 활용하면 O(1)로 풀 수 있다.

```java
class Solution {
    public int solution(int X, int Y, int D) {
        if((Y-X)%D==0)
            return (Y-X)/D;
        else
            return ((Y-X)/D)+1;
    }
}
```

>  문제 : [BinaryGap](https://app.codility.com/programmers/lessons/1-iterations/binary_gap/) </br>
유형 : Lesson 1(Iterations) </br>

# BinaryGap

자바 String 클래스의 toBinaryString 함수를 이용해 정수를 이진수로 변환한다. 그리고 변환된 이진수를 for문으로 순차탐색하여 '1' 사이에 있는 '0'의 개수를 갱신하면 된다.

```java
class Solution {
    public int solution(int N) {
        String binaryStr = Integer.toBinaryString(N);
        
        int len = binaryStr.length();
        int cnt = 0;
        int result = 0;
        
        int startIdx = -1;
        for(int i=0; i<len; i++){
            if(binaryStr.charAt(i)=='1'){
                startIdx = i;
                break;
            }
        }

        for(int i=startIdx+1; i<len; i++){
            if(binaryStr.charAt(i)=='1'){
                cnt = i-startIdx-1;
                startIdx = i;
                result = Math.max(cnt, result);
            }
        }

        return result;
    }
}
```

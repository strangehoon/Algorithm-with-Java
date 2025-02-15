> [Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/description/?envType=problem-list-v2&envId=rab78cw1)

# Longest Substring Without Repeating Characters

이중 for 문을 사용하여 완전탐색하면 O(n^2)으로 시간초과 판정이 뜬다. 그래서 나는 투포인터 & HashSet 자료구조를 활용해서 문제를 해결했다.

1. 중복된 문자를 처리하기 위해 HashSet을 선언한다.
2. 문자열을 순차적으로 탐색하면서 </br>
if 현재 문자가 이미 set에 있으면, 중복된 문자가 나올 때까지 idx를 이동시켜 부분 문자열을 갱신한다. </br>
else if 현재 문자가 set에 없으면, set에 해당 문자를 추가한다. </br>
then 문자열의 길이를 갱신한다.

시간복잡도 : O(n)




```java
import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int longestLen = 0;
        int idx = 0;
        for(int i=0,len=s.length(); i<len; i++){
            if(set.contains(s.charAt(i))){
                while(idx<i){
                    if(s.charAt(idx)==s.charAt(i)){
                        idx++;
                        break;
                    }
                    else{
                        set.remove(s.charAt(idx));
                        idx++;
                    }
                }
            }
            else{
                set.add(s.charAt(i));
            }
            longestLen = Math.max(longestLen, i-idx+1);
        }               
        return longestLen;
    }
}


```

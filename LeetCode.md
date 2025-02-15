> 문제 : [Two Sum](https://leetcode.com/problems/two-sum/?envType=problem-list-v2&envId=rab78cw1)


# Two Sum
단순하게 이중 for 문을 사용하여 완전탐색하면 O(N^2)으로 시간초과 판정이 뜬다. 그래서 나는 투포인터를 활용해 문제를 해결했다. 

1. 배열을 오름차순으로 정렬한다.
2. 배열의 처음 인덱스(idx)와 마지막 인덱스(jdx)를 설정한다.
3. 두 인덱스의 숫자의 합과 target을 비교한다.
   if 두 수의 합이 target보다 작으면, idx를 증가시킨다.
   else if 두 수의 합이 target보다 크면, jdx를 감소시킨다.
   else if 두 수의 합이 target과 같으면, 정답이다.

시간복잡도는 정렬로 인해 O(nlogn)이다. 참고로 HashMap을 활용하면 O(n)으로 풀 수 있다.

```java
import java.util.*;
class Solution {

    public class Num implements Comparable<Num>{
        int order;
        int value;

        public Num(int order, int value){
            this.order = order;
            this.value = value;
        }
        @Override
        public int compareTo(Num n){
            return this.value - n.value;
        }
    }

    public int[] twoSum(int[] nums, int target) {
        
        Num[] arrNum = new Num[nums.length];
        for(int i=0, len=nums.length; i<len; i++){
            arrNum[i] = new Num(i, nums[i]);
        }
        
        Arrays.sort(arrNum);

        int idx = 0;
        int jdx = arrNum.length-1;
        int[] answers = new int[2];

        while(idx<jdx){
            int sum = arrNum[idx].value + arrNum[jdx].value;
            if(sum<target){
                idx++;
            }
            else if(sum>target){
                jdx--;
            }
            else if(sum==target){
                answers[0] = arrNum[idx].order;
                answers[1] = arrNum[jdx].order;
                break;
            }
        }
        return answers;
    }
}
```

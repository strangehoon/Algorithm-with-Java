> [383. Ransom Note](https://leetcode.com/problems/ransom-note/description/?envType=problem-list-v2&envId=rab78cw1)

# Ransom Note
HashMap을 사용했다.
magazine 문자열의 문자와 등장 횟수를 map에 저장한 후, ransomNote의 문자를 하나씩 대조하여 cnt를 차감하는 방식으로 풀이했다.

시간복잡도 : O(n)

```java
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0, len =magazine.length(); i<len; i++){
            char ch = magazine.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        for(int i=0, len=ransomNote.length(); i<len; i++){
            char ch = ransomNote.charAt(i);
            if(!map.containsKey(ch))
                return false;
            
            map.put(ch, map.get(ch)-1);
            if(map.get(ch)==0)
                map.remove(ch);
        }
        return true;
    }
}
```

// 4:22
import java.util.*;
class Solution {
    
    public String calculate(int n, int x){
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        while(x>=n){
            int tem = x%n;
            list.add(String.valueOf(tem));
            x /= n;
        }
        list.add(String.valueOf(x));
        
        for(int i=0; i<list.size(); i++){
            String element = list.get(i);
            switch (element) {
                case "10":
                    sb.append("A");
                    break;
                case "11":
                    sb.append("B");
                    break;
                case "12":
                    sb.append("C");
                    break;
                case "13":
                    sb.append("D");
                    break;
                case "14":
                    sb.append("E");
                    break;
                case "15":
                    sb.append("F");
                    break;
                default:
                    sb.append(element);
                    break;
            }
        }
        return sb.reverse().toString();
    }
    
    public String solution(int n, int t, int m, int p) {
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<100000; i++){
            sb.append(calculate(n, i));
        }
        String str = sb.toString();
        
        StringBuilder result = new StringBuilder();
        int cnt = t;
        while(cnt>0){
            result.append(String.valueOf(str.charAt(p-1)));
            p= p+m;
            cnt--;
        }
        return result.toString();
    }
}
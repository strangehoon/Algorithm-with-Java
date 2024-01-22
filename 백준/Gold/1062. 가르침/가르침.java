import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static String[] arr;
    static int max_value = Integer.MIN_VALUE;
    static int K;
    static List<Character> alpha;
    static List<Character> choiceAlpha;
    public static void DFS(int pos, int cnt){
        if(cnt==K){
            max_value = Math.max(calculate(), max_value);
            return;
        }
        if(pos>alpha.size())
            return;
        for(int i=pos; i<alpha.size(); i++){
            choiceAlpha.add(alpha.get(i));
            DFS(i+1, cnt+1);
            choiceAlpha.remove(alpha.get(i));
        }
    }

    public static int calculate(){
        int cnt = 0;
        for(int i=0; i<arr.length; i++){
            String tem = arr[i];
            boolean flag = true;
            for(int j=0; j<tem.length(); j++){
                if(!choiceAlpha.contains(tem.charAt(j))){
                    flag = false;
                    break;
                }
            }
            if(flag==true){
                cnt++;
            }
        }
        return cnt;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // a,n,t,i,c는 무조건 있어야함
        if(K<5){
            System.out.println(0);
            return;
        }

        arr = new String[N];
        alpha = new ArrayList<>();
        for(int i=0; i<N; i++){
            String str = br.readLine();
            arr[i] = str;
            for(int j=0; j<str.length(); j++){
                if(str.charAt(j)!='a' && str.charAt(j)!='n' && str.charAt(j)!='t' && str.charAt(j)!='i'
                && str.charAt(j)!= 'c' && !alpha.contains(str.charAt(j))){
                    alpha.add(str.charAt(j));
                }
            }
        }
        // K가 지나치게 클 경우 모든 문자열을 배울 수 있음
        if(alpha.size()+5<K) {
            System.out.println(arr.length);
            return;
        }
        choiceAlpha = new ArrayList<>();
        choiceAlpha.add('a');
        choiceAlpha.add('n');
        choiceAlpha.add('t');
        choiceAlpha.add('i');
        choiceAlpha.add('c');

        DFS(0, 5);
        System.out.println(max_value);
    }
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static List<Long> list;

    public static void dfs(long num){
        list.add(num);
        for(int i=0; i<num%10; i++){
            dfs(num*10+i);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();

        if(n<10){
            System.out.println(n);
            return;
        }
        else if(n>=1023){
            System.out.println(-1);
            return;
        }

        for(int i=0; i<=9; i++){
            dfs(i);
        }

        Collections.sort(list);
        System.out.println(list.get(n));
    }
}
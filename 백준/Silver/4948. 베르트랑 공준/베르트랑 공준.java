import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Integer> list = new ArrayList<>();
        while (true){
            int n = Integer.parseInt(br.readLine());
            if(n==0)
                break;
            else
                list.add(n);
        }
        // 에라토스테네스의 체
        boolean[] check = new boolean[123456*2+1];
        check[1] = true;
        for(int i=2; i<=Math.sqrt(123456*2); i++){
            for(int j=i*2; j<=123456*2; j=j+i){
                check[j] = true;
            }
        }
        
        // 소수 카운팅 및 출력
        for(int i=0; i<list.size(); i++){
            int cnt = 0;
            int x = list.get(i);
            for(int j=x+1; j<=2*x;j++){
                if(check[j]==false){
                    cnt++;
                }
            }
            bw.write(String.valueOf(cnt)+"\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}
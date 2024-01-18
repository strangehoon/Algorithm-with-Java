import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        List<Integer> breakdown = new ArrayList<>();
        if(M!=0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<M; i++){
                breakdown.add(Integer.parseInt(st.nextToken()));
            }
        }
        int cnt = 0;
        // case 1 : +버튼 or -버튼
        int result = Math.abs(N-100);
        while (cnt<result){
            // case 2 : 리모콘 채널 입력 -> -버튼
            int plus = N+cnt;
            boolean flag1 = true;
            String plusString = String.valueOf(plus);
            for(int i=0; i<plusString.length(); i++){
                int tem = plusString.charAt(i)-'0';
                if(breakdown.contains(tem)){
                    flag1 = false;
                }
            }
            if(flag1==true) {
                result = Math.min(result, cnt + plusString.length());
            }
            // case 3 : 리모콘 채널 입력 -> +버튼
            int minus = N-cnt;
            boolean flag2 = true;
            if(minus<0){
                cnt++;
                continue;
            }
            String minusString = String.valueOf(minus);
            for (int i = 0; i < minusString.length(); i++) {
                int tem = minusString.charAt(i) - '0';
                if (breakdown.contains(tem)) {
                    flag2 = false;
                }
            }
            if (flag2 == true) {
                result = Math.min(result, cnt + minusString.length());
            }

            if(flag1==true || flag2==true){
                break;
            }
            cnt++;
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}
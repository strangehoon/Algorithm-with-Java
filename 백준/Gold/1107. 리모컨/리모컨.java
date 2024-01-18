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
        int cnt = Math.abs(N-100);
        for(int i=0; i<=1000000; i++){
            String tem = String.valueOf(i);
            boolean flag = true;
            for(int j=0; j<tem.length(); j++){
                if(breakdown.contains(tem.charAt(j)-'0')){
                    flag=false;
                    break;
                }
            }
            if(flag==true){
                int x = Math.abs(N-i)+tem.length();
                cnt = Math.min(cnt, x);
            }
        }
        bw.write(String.valueOf(cnt));

        bw.flush();
        bw.close();
        br.close();
    }
}
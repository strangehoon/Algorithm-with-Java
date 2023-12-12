import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        char[][] arr = new char[H][W];
        int[][] results = new int[H][W];
        // 입력
        for(int i=0; i<H; i++){
            String str = br.readLine();
            for(int j=0; j<W; j++){
                arr[i][j] = str.charAt(j);
            }
        }
        // 초기화
        for(int i=0; i<H; i++){
            for(int j=0; j<W; j++){
                results[i][j] = -1;
            }
        }
        // 구름 이동
        for(int i=0; i<H; i++){
            int cnt = 0;
            boolean flag = false;
            for(int j=0; j<W; j++){
                if(arr[i][j]=='c'){
                    results[i][j] = 0;
                    cnt = 1;
                    flag = true;
                } else if (arr[i][j]=='.' && flag == true) {
                    results[i][j] = cnt++;
                }
            }
        }
        // 출력
        for(int i=0; i<H; i++){
            for(int j=0; j<W; j++){
                bw.write(String.valueOf(results[i][j]) +" ");
            }
            bw.write(String.valueOf("\n"));
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

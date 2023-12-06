import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] arr_input = new int[n][21];
        for(int i=0; i< n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j< 21; j++){
                arr_input[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int i =0;
        while(i <n) {
            int cnt = 0;
            ArrayList<Integer> arrayList = new ArrayList<>();
            // 맨 앞 한명 배정
            arrayList.add(arr_input[i][1]);
            for (int j = 2; j < 21; j++) {
                boolean flag = true;
                for (int k = 0; k < arrayList.size(); k++) {
                    if (arr_input[i][j] < arrayList.get(k)) {
                        cnt += arrayList.size() - k;
                        arrayList.add(k, arr_input[i][j]);
                        flag = false;
                        break;
                    }
                }
                if(flag == true)
                    arrayList.add(arr_input[i][j]);
            }
            bf.write(String.valueOf(i + 1) + " ");
            bf.write(String.valueOf(cnt) + "\n");
            i++;
        }

        bf.flush();
        bf.close();
        br.close();


    }
}
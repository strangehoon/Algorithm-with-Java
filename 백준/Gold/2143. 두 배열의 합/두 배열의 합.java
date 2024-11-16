import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.valueOf(br.readLine());
        int n = Integer.valueOf(br.readLine());
        int[] Aarr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            Aarr[i] = Integer.valueOf(st.nextToken());
        }

        int m = Integer.valueOf(br.readLine());
        int[] Barr = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            Barr[i] = Integer.valueOf(st.nextToken());
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<m; i++){
            int sum = 0;
            for(int j=i; j<m; j++){
                sum += Barr[j];
                map.put(sum, map.getOrDefault(sum, 0)+1);
            }
        }
        long cnt = 0;
        for(int i=0; i<n; i++){
            int sum = 0;
            for(int j=i; j<n; j++){
                sum += Aarr[j];
                int rest = T-sum;
                if(map.containsKey(rest)){
                    cnt += map.get(rest);
                }
            }
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
        br.close();
    }
}
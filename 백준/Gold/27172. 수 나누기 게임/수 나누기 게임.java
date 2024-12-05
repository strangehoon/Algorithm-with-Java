import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.valueOf(br.readLine());
        final int INF = Integer.MAX_VALUE;
        int[] arr = new int[1000001];

        Arrays.fill(arr, Integer.MAX_VALUE);
        List<Integer> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int num = Integer.valueOf(st.nextToken());
            arr[num] = 0;
            list.add(num);
        }

        for(int i=1; i<=1000000; i++){
            if(arr[i]!=INF){
                for(int j=i+i; j<=1000000; j+=i){
                    if(arr[j]!=INF){
                        arr[i]++;
                        arr[j]--;
                    }
                }
            }
        }

        for(int i=0; i<list.size(); i++){
            bw.write(String.valueOf(arr[list.get(i)])+" ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] arrSort = new int[N];
        HashMap<Integer, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            arrSort[i] = arr[i];
        }
        Arrays.sort(arrSort);

        for(int i=1; i<N; i++){
            if(arrSort[i]>arrSort[i-1])
                map.put(arrSort[i], map.getOrDefault(arrSort[i-1], 0)+1);
            else if (arrSort[i]==arrSort[i-1])
                map.put(arrSort[i], map.getOrDefault(arrSort[i-1], 0));
        }

        for(int i=0; i<N; i++){
            bw.write(String.valueOf(map.getOrDefault(arr[i], 0) +" "));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
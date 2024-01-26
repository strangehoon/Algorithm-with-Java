import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] arr;
    static List<List<Integer>> list;
    public static void Sol(int a, int b, int level){
        int mid = (a+b)/2;
        list.get(level).add(arr[mid]);
        if(a<=mid-1){
            Sol(a, mid-1, level+1);
        }
        if(mid+1<=b){
            Sol(mid+1, b, level+1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int K = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for(int i=0; i<K; i++){
            list.add(new ArrayList<>());
        }

        n = (int)Math.pow(2, K)-1;
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Sol(0, n-1, 0);
        for(int i=0; i<K; i++){
            for(int j=0; j<list.get(i).size(); j++){
                bw.write(String.valueOf(list.get(i).get(j))+" ");
            }
            bw.write(String.valueOf("\n"));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
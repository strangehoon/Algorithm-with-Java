import java.io.*;
import java.util.*;

public class Main {

    static int[] arr;
    public static int Find(int v){
        if(arr[v]==v){
            return v;
        } else {
            return arr[v] = Find(arr[v]);
        }
    }

    public static void Union(int v1, int v2){
        int f1 = Find(v1);
        int f2 = Find(v2);
        if(f1!=f2){
            arr[f1]= f2;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n+1];
        for(int i=0; i<n+1; i++){
            arr[i] = i;
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            if(x==0)
                Union(v1, v2);
            else if (x==1) {
                int f1 = Find(v1);
                int f2 = Find(v2);
                if(f1==f2)
                    bw.write(String.valueOf("YES\n"));
                else
                    bw.write(String.valueOf("NO\n"));
            }
        }

        bw.flush();
        bw.close();
        br.close();

    }
}

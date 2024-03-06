import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static int[] parent;

    public static void union(int a, int b){
        a = find(a);
        b = find(b);
        parent[b]=a;
    }
    public static int find(int x){
        if(x==parent[x]){
            return parent[x];
        }
        else{
            return parent[x] = find(parent[x]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        parent = new int[N];
        for(int i=0; i<N; i++){
            parent[i] = i;
        }
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                int x = Integer.parseInt(st.nextToken());
                if(x==1){
                    union(i, j);
                }
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int tem = find(Integer.parseInt(st.nextToken())-1);
        boolean flag = true;
        while (st.hasMoreTokens()){
            int x = Integer.parseInt(st.nextToken())-1;
            if(tem!=find(x)){
                flag = false;
                break;
            }
        }
        bw.write(String.valueOf(flag==true ? "YES" : "NO"));

        bw.flush();
        bw.close();
        br.close();
    }
}
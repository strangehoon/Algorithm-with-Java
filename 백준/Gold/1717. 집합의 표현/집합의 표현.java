import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static int[] parent;
    public static int find(int x){
        if(x==parent[x])
            return parent[x];
        else
            return parent[x] = find(parent[x]);
    }

    public static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a!=b){
            parent[b]= a;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parent = new int[n+1];
        for(int i=0; i<=n; i++){
            parent[i] = i;
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int cal = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(cal==0){
                union(a, b);
            } else if (cal==1) {
                if(find(a)==find(b)){
                    bw.write(String.valueOf("YES")+"\n");
                }
                else
                    bw.write(String.valueOf("NO")+"\n");
            }
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}
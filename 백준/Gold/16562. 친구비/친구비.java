import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static int[] arr, cost;
    public static int totalCost;

    public static int find(int x){
        if(arr[x]==x){
            return arr[x];
        }
        else{
            return arr[x] = find(arr[x]);
        }
    }

    public static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(cost[a]<cost[b]){
            arr[b] = a;
        }
        else{
            arr[a] = b;
        }

        if(a==0){
            totalCost += cost[b];
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());
        int k = Integer.valueOf(st.nextToken());

        totalCost = 0;
        arr = new int[n+1];
        for(int i=0; i<=n; i++){
            arr[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        cost = new int[n+1];
        for(int i=1; i<=n; i++){
            cost[i] = Integer.valueOf(st.nextToken());
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int v = Integer.valueOf(st.nextToken());
            int w = Integer.valueOf(st.nextToken());
            union(v, w);
        }

        for(int i=1; i<=n; i++){
            if(find(0)!=find(i)){
                union(0, i);
            }
        }

        if(totalCost>k)
            bw.write("Oh no");
        else
            bw.write(String.valueOf(totalCost));

        bw.flush();
        bw.close();
        br.close();
    }
}
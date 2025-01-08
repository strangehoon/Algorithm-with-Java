import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static int[] arr;
    public static boolean[] visited;
    public static StringBuilder sb = new StringBuilder();
    public static int n,m;

    public static void sol(int level){

        if(level==m){
            for(int x:arr){
                sb.append(x).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1; i<=n; i++){
            if(!visited[i]){
                arr[level] = i;
                sol(level+1);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        visited = new boolean[n+1];

        sol( 0);
        System.out.println(sb.toString());

    }
}
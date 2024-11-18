import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    
    public static boolean[] visited;
    public static int[] arr;
    public static int cnt;
    
    public static void Dfs(int startIdx, int curIdx){
        visited[curIdx] = true;
        int num = arr[curIdx];
        if(!visited[num]){
            Dfs(startIdx, num);
        }
        else if (visited[num] && num!=startIdx) {
            Count(startIdx, num);
        }
    }
    public static void Count(int startIdx, int endNum){
        cnt++;

        if(endNum!=arr[startIdx]){
            Count(arr[startIdx], endNum);
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T =Integer.valueOf(br.readLine());
        while (T-->0){
            int n = Integer.valueOf(br.readLine());
            arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++){
                int num = Integer.valueOf(st.nextToken())-1;
                arr[i] = num;
            }

            cnt = 0;
            visited = new boolean[n];
            for(int i=0; i<n; i++){
                if(!visited[i]){
                    Dfs(i, i);
                }
            }
            bw.write(String.valueOf(cnt)+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static List<List<Integer>> graph;
    public static int[] awardList;
    public static int[] answer;

    public static void dfs(int num, int award){

        answer[num] = awardList[num] + award;
        for(int tem : graph.get(num)){
            dfs(tem, answer[num]);
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());

        graph = new ArrayList<>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            int num = Integer.valueOf(st.nextToken());
            if(num==-1)
                continue;
            graph.get(num).add(i);
        }

        awardList = new int[n+1];
        answer = new int[n+1];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.valueOf(st.nextToken());
            int b = Integer.valueOf(st.nextToken());
            awardList[a] += b;
        }

        dfs(1, 0);

        for(int i=1; i<=n; i++){
            bw.write(String.valueOf(answer[i])+" ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
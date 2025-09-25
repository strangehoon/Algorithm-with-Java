import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int n,s, virusCnt, blankCnt;
    public static int[][] graph;
    public static List<int[]> virusList;
    public static int result;

    public static void comb(int idx, int[] virusIdxs, int cnt){

        if(cnt==s){
            solve(virusIdxs);
            return;
        }

        for(int i=idx; i<virusCnt; i++){
            virusIdxs[cnt] = i;
            comb(i+1, virusIdxs, cnt+1);
            virusIdxs[cnt] = 0;
        }
    }

    public static void solve(int[] virusIdxs){
        int changedVirus = 0;
        int[][] dist = new int[n][n];

        for(int i=0; i<n; i++){
            Arrays.fill(dist[i], -1);
        }

        Queue<int[]> queue = new LinkedList<>();
        for(int virusIdx: virusIdxs){
            int[] tem = virusList.get(virusIdx);
            dist[tem[0]][tem[1]] = 0;
            queue.offer(tem);
        }

        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};

        int time = 1;
        while (!queue.isEmpty() && changedVirus!=blankCnt){
            int size = queue.size();
            while (size-->0 && changedVirus!=blankCnt){
                int[] pos = queue.poll();

                for(int i=0; i<4; i++){
                    int nx = pos[0]+dx[i];
                    int ny = pos[1]+dy[i];

                    if(0<=nx && nx<n && 0<=ny && ny<n && graph[nx][ny]!=1 && dist[nx][ny]==-1){
                        if(graph[nx][ny]==0){
                            changedVirus++;
                        }
                        dist[nx][ny] = time;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
            time++;
        }

        if (blankCnt == changedVirus) {
            result = Math.min(result, time-1);
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        graph = new int[n][n];
        virusList = new ArrayList<>();
        blankCnt = 0;

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
                if(graph[i][j]==2){
                    virusList.add(new int[]{i, j});
                }
                else if(graph[i][j]==0){
                    blankCnt++;
                }
            }
        }
        virusCnt = virusList.size();
        result = Integer.MAX_VALUE;

        comb(0, new int[s], 0);

        if(result==Integer.MAX_VALUE)
            System.out.println(-1);
        else {
            System.out.println(result);
        }
    }
}
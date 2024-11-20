import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static int[][][] graph;
    public static int R,C,T;
    public static int[] machine;

    public static void airMove(int t){
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(graph[i][j][t]<=0){
                    continue;
                }
                int tem = graph[i][j][t]/5;
                graph[i][j][t+1] += graph[i][j][t];
                for(int k=0; k<4; k++){
                    int nx = i+dx[k];
                    int ny = j+dy[k];
                    if(0<=nx && nx<R && 0<=ny && ny<C && graph[nx][ny][0]!=-1){
                        graph[nx][ny][t+1] += tem;
                        graph[i][j][t+1] -= tem;
                    }
                }
            }
        }
    }

    public static void machineRun(int t){
        int upMachineIdx = machine[0];
        int dwnMachineIdx = machine[1];

        for(int i=upMachineIdx-1; i>=0; i--){
            graph[i+1][0][t+1] = graph[i][0][t+1];
        }

        for(int i=1; i<C; i++){
            graph[0][i-1][t+1] = graph[0][i][t+1];
        }

        for(int i=1; i<=upMachineIdx; i++){
            graph[i-1][C-1][t+1] = graph[i][C-1][t+1];
        }

        for(int i=C-2; i>=1; i--){
            graph[upMachineIdx][i+1][t+1] = graph[upMachineIdx][i][t+1];
        }
        graph[upMachineIdx][0][t+1] = 0;
        graph[upMachineIdx][1][t+1] = 0;

        for(int i=dwnMachineIdx+1; i<R; i++){
            graph[i-1][0][t+1] = graph[i][0][t+1];
        }

        for(int i=1; i<C; i++){
            graph[R-1][i-1][t+1] = graph[R-1][i][t+1];
        }

        for(int i=R-2; i>=dwnMachineIdx; i--){
            graph[i+1][C-1][t+1] = graph[i][C-1][t+1];
        }

        for(int i=C-2; i>=1; i--){
            graph[dwnMachineIdx][i+1][t+1] = graph[dwnMachineIdx][i][t+1];
        }

        graph[dwnMachineIdx][0][t+1] = 0;
        graph[dwnMachineIdx][1][t+1] = 0;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.valueOf(st.nextToken());
        C = Integer.valueOf(st.nextToken());
        T = Integer.valueOf(st.nextToken());
        graph = new int[R][C][T+1];
        for(int i=0; i<R; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<C; j++){
                graph[i][j][0] = Integer.valueOf(st.nextToken());
            }
        }
        
        machine = new int[2];
        int idx = 0;
        for(int i=0; i<R; i++){
            if(graph[i][0][0]==-1){
                machine[idx++] = i;
            }
        }

        for(int i=0; i<T; i++){
            airMove(i);
            machineRun(i);
        }

        int sum = 0;
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(graph[i][j][T]>0){
                    sum += graph[i][j][T];
                }
            }
        }

        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
        br.close();
    }
}
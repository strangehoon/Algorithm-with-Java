import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] graph = new int[n][n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] isCloud = new boolean[n][n];
        List<int[]> clouds = new ArrayList<>();
        clouds.add(new int[]{n-1, 0});
        clouds.add(new int[]{n-1, 1});
        clouds.add(new int[]{n-2, 0});
        clouds.add(new int[]{n-2, 1});

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken())-1;
            int s = Integer.parseInt(st.nextToken());

            // 1) 구름 이동 후 비 내림, 구름 사라짐
            int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
            int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
            for(int[] cloud : clouds){
                int x = cloud[0];
                int y = cloud[1];
                int nx = (x+ n+(dx[d]*s)%n)%n;
                int ny = (y+ n+(dy[d]*s)%n)%n;
                isCloud[nx][ny] = true;
                graph[nx][ny] +=1;
            }
            clouds.clear();

            // 3) 대각선 방향 물 계산
            dx = new int[]{-1, -1, 1, 1};
            dy = new int[]{-1, 1, -1, 1};
            for(int j=0; j<n; j++){
                for(int k=0; k<n; k++){
                    if(isCloud[j][k]){
                        int cnt = 0;
                        for(int l = 0; l<4; l++){
                            int nx = j+dx[l];
                            int ny = k+dy[l];

                            if(0<=nx && nx<n && 0<=ny && ny<n && graph[nx][ny]!=0){
                                cnt++;
                            }
                        }
                        graph[j][k] += cnt;
                    }
                }
            }

            // 4) 구름 업데이트
            for(int j=0; j<n; j++){
                for(int k=0; k<n; k++){
                    if(isCloud[j][k]){
                        isCloud[j][k]=false;
                    }
                    else if(!isCloud[j][k] && graph[j][k]>=2){
                        graph[j][k]-=2;
                        clouds.add(new int[]{j, k});
                    }
                }
            }
        }

        int answer = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                answer += graph[i][j];
            }
        }

        System.out.println(answer);
    }
}
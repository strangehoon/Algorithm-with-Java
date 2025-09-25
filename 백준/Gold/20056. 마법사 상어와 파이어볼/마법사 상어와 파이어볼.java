import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<int[]> fireBallList = new ArrayList<>();
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            fireBallList.add(new int[]{Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
            });
        }

        Map<Integer, List<int[]>> graph = new HashMap<>();
        for(int i=0; i<N*N; i++){
            graph.put(i, new ArrayList<>());
        }

        int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

        for(int i=0; i<K; i++){
            // 1. 파이어볼 이동
            for(int[] fireBall : fireBallList){
                int r = fireBall[0];
                int c = fireBall[1];
                int m = fireBall[2];
                int s = fireBall[3]%N;
                int d = fireBall[4];

                int nr = (r+ dx[d]*s + N)%N;
                int nc = (c+ dy[d]*s + N)%N;

                int idx = nr*N+nc;
                graph.get(idx).add(new int[]{nr, nc, m, fireBall[3], d});
            }
            fireBallList.clear();

            // 2. 파이어볼 업데이트
            for(int j=0; j<N*N; j++){
                List<int[]> values = graph.get(j);

                if(values.size()==0)
                    continue;
                else if(values.size()==1) {
                    fireBallList.add(values.get(0));
                    graph.get(j).clear();
                    continue;
                }
                int r = values.get(0)[0];
                int c = values.get(0)[1];
                int sumM = 0;
                int sumS = 0;
                int stdD =values.get(0)[4]%2;
                boolean flagD = true;
                for(int[] value : values){
                    sumM += value[2];
                    sumS += value[3];
                    if(stdD!=value[4]%2){
                        flagD = false;
                    }
                }
                int m = sumM/5;
                int s = sumS/ values.size();

                if(m==0) {
                    graph.get(j).clear();
                    continue;
                }
                if(flagD){
                    fireBallList.add(new int[]{r, c, m, s, 0});
                    fireBallList.add(new int[]{r, c, m, s, 2});
                    fireBallList.add(new int[]{r, c, m, s, 4});
                    fireBallList.add(new int[]{r, c, m, s, 6});
                }
                else{
                    fireBallList.add(new int[]{r, c, m, s, 1});
                    fireBallList.add(new int[]{r, c, m, s, 3});
                    fireBallList.add(new int[]{r, c, m, s, 5});
                    fireBallList.add(new int[]{r, c, m, s, 7});
                }

                graph.get(j).clear();
            }
        }

        int answer = 0;
        for(int[] x : fireBallList){
            answer += x[2];
        }

        System.out.println(answer);
    }
}
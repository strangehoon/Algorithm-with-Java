import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int n;
    public static int[][] graph;
    public static List<HashSet<Integer>> likeStuNum;
    public static List<Integer> stuArr;
    public static int result = 0;

    public static class Pos implements Comparable<Pos>{
        int x;
        int y;
        int likeCnt;
        int blankCnt;

        public Pos(int x, int y, int likeCnt, int blankCnt){
            this.x = x;
            this.y = y;
            this.likeCnt = likeCnt;
            this.blankCnt = blankCnt;
        }

        @Override
        public int compareTo(Pos o) {
            if(o.likeCnt!=this.likeCnt){
                return o.likeCnt-this.likeCnt;
            }
            else {
                if(o.blankCnt!=this.blankCnt){
                    return o.blankCnt-this.blankCnt;
                }
                else{
                    if(this.x!=o.x){
                        return this.x-o.x;
                    }
                    else{
                        return this.y-o.y;
                    }
                }
            }
        }
    }

    public static void setPos(){
        for(int i=0; i<n*n; i++){
            int num = stuArr.get(i);
            PriorityQueue<Pos> pq = new PriorityQueue<>();
            for(int j=0; j<n; j++){
                for(int k=0; k<n; k++){
                    if(graph[j][k]!=0){
                        continue;
                    }
                    int likeCnt = 0;
                    int blankCnt = 0;
                    for(int l=0; l<4; l++){
                        int nx = j+dx[l];
                        int ny = k+dy[l];
                        if(0<=nx && nx<n && 0<=ny && ny<n){
                            if(likeStuNum.get(num).contains(graph[nx][ny])){
                                likeCnt++;
                            } else if (graph[nx][ny]==0) {
                                blankCnt++;
                            }
                        }
                    }
                    pq.offer(new Pos(j, k, likeCnt, blankCnt));
                }
            }
            Pos pos = pq.poll();
            graph[pos.x][pos.y] = num;
        }
    }

    public static void calculateScore(){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                int num = graph[i][j];
                int cnt = 0;
                for(int k=0; k<4; k++){
                    int nx = i+dx[k];
                    int ny = j+dy[k];
                    if(0<=nx && nx<n && 0<=ny && ny<n){
                        if(likeStuNum.get(num).contains(graph[nx][ny])){
                            cnt++;
                        }
                    }
                }
                if (cnt==1)
                    result+=1;
                else if (cnt==2)
                    result+=10;
                else if (cnt==3)
                    result+=100;
                else if (cnt==4)
                    result+=1000;
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 초기화 세팅 작업
        n = Integer.valueOf(br.readLine());
        graph = new int[n][n];
        likeStuNum = new ArrayList<>();
        for(int i=0; i<=n*n; i++){
            likeStuNum.add(new HashSet<>());
        }
        stuArr = new ArrayList<>();
        for(int i=0; i<n*n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.valueOf(st.nextToken());
            stuArr.add(num);
            for(int j=0; j<4; j++){
                likeStuNum.get(num).add(Integer.valueOf(st.nextToken()));
            }
        }

        // 자리 정하기
        setPos();

        // 만족도 계산
        calculateScore();

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}

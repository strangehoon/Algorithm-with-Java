import java.util.*;

class Solution {

    // 비트 마스크 헬퍼
    private boolean hasPillar(int[][] g, int x, int y){ return (g[x][y] & 1) != 0; }
    private boolean hasBeam(int[][] g, int x, int y){ return (g[x][y] & 2) != 0; }

    // 기둥 설치 가능 여부
    public boolean isPillar(int x, int y, int n, int[][] g){
        if (y == 0) return true;                         // 바닥
        if (y - 1 >= 0 && hasPillar(g, x, y - 1)) return true;   // 아래 기둥
        if (x - 1 >= 0 && hasBeam(g, x - 1, y)) return true;     // 왼쪽 보 끝 위
        if (hasBeam(g, x, y)) return true;                       // 오른쪽 보 끝 위
        return false;
    }

    // 보 설치 가능 여부 (보의 왼쪽 끝이 (x,y))
    public boolean isBeam(int x, int y, int n, int[][] g){
        boolean leftOnPillar  = (y - 1 >= 0) && hasPillar(g, x, y - 1);
        boolean rightOnPillar = (x + 1 <= n && y - 1 >= 0) && hasPillar(g, x + 1, y - 1);
        if (leftOnPillar || rightOnPillar) return true;

        boolean leftBeam  = (x - 1 >= 0) && hasBeam(g, x - 1, y);
        boolean rightBeam = (x + 1 <= n) && hasBeam(g, x + 1, y);
        return leftBeam && rightBeam;
    }

    // 특정 좌표들의 구조물들이 모두 유효한지 검사
    private boolean allValid(int n, int[][] g, List<int[]> checks){
        for (int[] c : checks){
            int x = c[0], y = c[1], a = c[2]; // a: 0 pillar, 1 beam
            if (a == 0) {
                if (hasPillar(g, x, y) && !isPillar(x, y, n, g)) return false;
            } else {
                if (hasBeam(g, x, y) && !isBeam(x, y, n, g)) return false;
            }
        }
        return true;
    }

    public int[][] solution(int n, int[][] build_frames) {

        int[][] graph = new int[n + 1][n + 1]; // bit mask: 1=pillar, 2=beam

        for (int[] frame : build_frames){
            int x = frame[0];
            int y = frame[1];
            int a = frame[2];
            int b = frame[3];

            if (a == 0 && b == 1) { // 기둥 설치
                if (isPillar(x, y, n, graph)) graph[x][y] |= 1;
            }
            else if (a == 1 && b == 1) { // 보 설치
                if (isBeam(x, y, n, graph)) graph[x][y] |= 2;
            }
            else if (a == 0 && b == 0) { // 기둥 삭제
                int prev = graph[x][y];
                graph[x][y] &= ~1; // 기둥 비트 내림

                // 영향 받는 이웃: (x,y+1) 기둥, (x-1,y+1) 보, (x,y+1) 보
                List<int[]> checks = new ArrayList<>();
                if (y + 1 <= n) checks.add(new int[]{x, y + 1, 0});
                if (y + 1 <= n && x - 1 >= 0) checks.add(new int[]{x - 1, y + 1, 1});
                if (y + 1 <= n) checks.add(new int[]{x, y + 1, 1});

                if (!allValid(n, graph, checks)) {
                    graph[x][y] = prev; // 롤백
                }
            }
            else if (a == 1 && b == 0) { // 보 삭제
                int prev = graph[x][y];
                graph[x][y] &= ~2; // 보 비트 내림

                // 영향 받는 이웃: (x-1,y) 보, (x+1,y) 보, (x,y) 기둥, (x+1,y) 기둥
                List<int[]> checks = new ArrayList<>();
                if (x - 1 >= 0) checks.add(new int[]{x - 1, y, 1});
                if (x + 1 <= n) checks.add(new int[]{x + 1, y, 1});
                checks.add(new int[]{x, y, 0});
                if (x + 1 <= n) checks.add(new int[]{x + 1, y, 0});

                if (!allValid(n, graph, checks)) {
                    graph[x][y] = prev; // 롤백
                }
            }
        }

        // 결과 수집: 3(둘 다)이면 두 줄로 분해
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i <= n; i++){
            for (int j = 0; j <= n; j++){
                if ((graph[i][j] & 1) != 0) list.add(new int[]{i, j, 0});
                if ((graph[i][j] & 2) != 0) list.add(new int[]{i, j, 1});
            }
        }

        // 정렬: x → y → a(기둥 0이 보 1보다 먼저)
        list.sort((u, v) -> {
            if (u[0] != v[0]) return Integer.compare(u[0], v[0]);
            if (u[1] != v[1]) return Integer.compare(u[1], v[1]);
            return Integer.compare(u[2], v[2]);
        });

        int[][] answer = new int[list.size()][3];
        for (int i = 0; i < list.size(); i++) answer[i] = list.get(i);
        return answer;
    }
}

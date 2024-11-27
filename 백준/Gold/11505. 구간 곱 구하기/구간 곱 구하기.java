import java.io.*;
import java.util.*;

public class Main {

    public static long[] tree;

    public static long getSum(int s, int e) {
        long partSum = 1;

        while (s <= e) {
            if (s % 2 == 1) {
                partSum = (partSum * tree[s]) % 1000000007;
                s++;
            }
            if (e % 2 == 0) {
                partSum = (partSum * tree[e]) % 1000000007;
                e--;
            }
            s /= 2;
            e /= 2;
        }
        return partSum;
    }

    public static void changeValue(int idx, long value) {
        tree[idx] = value; // 리프 노드 값 갱신
        idx /= 2;
        while (idx > 0) {
            tree[idx] = (tree[idx * 2] * tree[idx * 2 + 1]) % 1000000007; // 상위 노드 갱신
            idx /= 2;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int height = (int) Math.ceil(Math.log(N) / Math.log(2));
        int size = (int) Math.pow(2, height + 1);
        int leftNodeStartIdx = size / 2 - 1;
        tree = new long[size];
        Arrays.fill(tree, 1);

        // 리프 노드 입력
        for (int i = leftNodeStartIdx + 1; i <= leftNodeStartIdx + N; i++) {
            tree[i] = Long.parseLong(br.readLine());
        }

        // 세그먼트 트리 초기화
        for (int i = leftNodeStartIdx; i > 0; i--) {
            tree[i] = (tree[i * 2] * tree[i * 2 + 1]) % 1000000007;
        }

        // 쿼리 처리
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            long e = Long.parseLong(st.nextToken());

            if (a == 1) { // 값 변경
                changeValue(leftNodeStartIdx + s, e);
            } else if (a == 2) { // 구간 곱 구하기
                s += leftNodeStartIdx;
                e += leftNodeStartIdx;
                bw.write(getSum(s, (int) e) + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

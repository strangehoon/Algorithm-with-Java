import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static int[] sequence;
    private static boolean[] used;
    private static StringBuilder sb = new StringBuilder();

    private static void generate(int n, int m, int depth) {
        if (depth == m) {
            for (int num : sequence) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!used[i]) {
                used[i] = true;
                sequence[depth] = i;
                generate(n, m, depth + 1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        sequence = new int[m];
        used = new boolean[n + 1];

        generate(n, m, 0);
        System.out.print(sb);
    }
}
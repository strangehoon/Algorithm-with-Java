import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static int N, M, A[], numbers[];
	static boolean selected[];
	static Set<String> set = new HashSet<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		A = new int[N];
		selected = new boolean[N];
		numbers = new int[M];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(A);
		
		recursion(0);
	}

	static void recursion(int cnt) {
		
		if (cnt == M) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < M; i++) {
				sb.append(numbers[i]).append(" ");
			}
			sb.append("\n");
			String result = sb.toString();
			if (!set.contains(result)) {
				System.out.print(result);
				set.add(result);
			}
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (selected[i]) continue;
			
			numbers[cnt] = A[i];
			selected[i] = true;
			recursion(cnt + 1);
			selected[i] = false;
		}
		
	}

}
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(st.nextToken());

        // 에라토스테네스의 체, true : 소수x, false 소수
        boolean[] arr = new boolean[4000001];
        arr[1] = true;
        for(int i=2; i<=4000000; i++){
            for(int j=i+i; j<=4000000; j+=i){
                arr[j] = true;
            }
        }

        // 리스트 초기화
        List<Integer> list = new ArrayList<>();
        for(int i=2; i<=4000000; i++){  // 여기서 i=2로 시작해야 합니다.
            if(!arr[i])
                list.add(i);
        }

        // 핵심 로직
        int front = 0;
        int back = 0;
        int sum = list.get(0);  // 첫 번째 소수를 sum에 포함시킵니다.
        int result = 0;
        int size = list.size();

        while (back < size) {
            if (sum == N) {
                result++;
                sum -= list.get(back++);
            } else if (sum < N) {
                if (front + 1 < size) {
                    sum += list.get(++front);
                } else {
                    break;
                }
            } else {
                sum -= list.get(back++);
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}
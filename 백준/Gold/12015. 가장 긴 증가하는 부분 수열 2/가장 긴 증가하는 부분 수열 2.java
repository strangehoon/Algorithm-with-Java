import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.valueOf(br.readLine());
        int[] A = new int[N];
        List<Integer> arr = new ArrayList<>();
        arr.add(0);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            A[i] = Integer.valueOf(st.nextToken());
        }

        for(int i=0; i<N; i++){
            int tem = A[i];
            if(arr.get(arr.size()-1)<tem){
                arr.add(tem);
            }
            else{
                int lt = 0;
                int rt = arr.size();
                while (lt<=rt){
                    int mid = (lt+rt)/2;
                    if(arr.get(mid)<tem){
                        lt = mid+1;
                    }
                    else if (arr.get(mid)>=tem) {
                        if (arr.get(mid - 1) < tem) {
                            arr.set(mid, tem);
                            break;
                        } else {
                            rt = mid-1;
                        }
                    }
                }
            }
        }

        bw.write(String.valueOf(arr.size()-1));

        bw.flush();
        bw.close();
        br.close();
    }
}

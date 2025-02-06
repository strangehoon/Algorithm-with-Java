import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] aArr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            aArr[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] bArr = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            bArr[i] = Integer.parseInt(st.nextToken());
        }
        int aIdx = 0;
        int bIdx = 0;
        List<Integer> list = new ArrayList<>();
        while (true) {
            int maxValue = 0;
            int maxValueAIdx = 0;
            int maxValueBIdx = 0;
            for(int i=aIdx; i<n; i++){
                for(int j=bIdx; j<m; j++){
                    if(aArr[i]==bArr[j] && aArr[i]>maxValue){
                        maxValue = aArr[i];
                        maxValueAIdx = i;
                        maxValueBIdx = j;
                    }
                }
            }

            if(maxValue!=0){
                list.add(maxValue);
                aIdx = maxValueAIdx+1;
                bIdx = maxValueBIdx+1;
            }
            else{
                break;
            }
        }
        System.out.println(list.size());
        for(int x : list)
            System.out.print(x+" ");
    }
}
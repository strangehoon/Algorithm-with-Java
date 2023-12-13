import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static class Record{
        int num;
        int time;

        public Record(int num, int time){
            this.num = num;
            this.time = time;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Record[] records = new Record[N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            String str = st.nextToken();
            String[] strArr = str.split(":");
            int time = Integer.parseInt(strArr[0])*60 + Integer.parseInt(strArr[1]);
            records[i] = new Record(num, time);
        }

        int[] num = new int[2];
        int[] time = new int[2];
        num[records[0].num-1] ++;
        for(int i=1; i<N; i++){
            if(num[0]>num[1]){
                time[0] += records[i].time-records[i-1].time;
            } else if (num[0]<num[1]) {
                time[1] += records[i].time-records[i-1].time;
            }
            num[records[i].num-1]++;
        }

        if(num[0]>num[1]){
            time[0] += 48*60-records[N-1].time;
        } else if (num[0]<num[1]) {
            time[1] += 48*60-records[N-1].time;
        }
        bw.write(String.format("%02d:%02d\n", time[0]/60, time[0]%60));
        bw.write(String.format("%02d:%02d\n", time[1]/60, time[1]%60));
        bw.flush();
        bw.close();
        br.close();
    }
}

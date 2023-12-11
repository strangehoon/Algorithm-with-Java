import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(st1.nextToken());
        int C = Integer.valueOf(st1.nextToken());
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<N; i++){
            int x = Integer.parseInt(st2.nextToken());
            arrayList.add(x);
            arrayList2.add(x);
            map.put(x, map.getOrDefault(x, 0)+1);
        }
        Collections.sort(arrayList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(map.get(o1).equals(map.get(o2))){
                    return arrayList2.indexOf(o1)-arrayList2.indexOf(o2);
                }
                else{
                    return map.get(o2) - map.get(o1);
                }
            }
        });
        for(Integer x : arrayList){
            bw.write(x +" ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

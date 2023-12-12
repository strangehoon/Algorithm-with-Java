import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        ArrayList<Integer> results = new ArrayList<>();
        for (int i = 0; i < T; i++) {
            HashMap<Integer, Integer> cntMap = new HashMap<>();
            HashMap<Integer, Integer> scoreMap = new HashMap<>();

            int N = Integer.parseInt(br.readLine());
            ArrayList<Integer> arrayList = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int x = Integer.parseInt(st.nextToken());
                arrayList.add(x);
                cntMap.put(x, cntMap.getOrDefault(x, 0) + 1);
            }
            ArrayList<Integer> forRemove = new ArrayList<>();
            for (Integer x : cntMap.keySet()) {
                if (cntMap.get(x) < 6) {
                    for (int j = 0; j < cntMap.get(x); j++) {
                        arrayList.remove(x);
                    }
                    forRemove.add(x);
                }
            }
            for(Integer x:forRemove)
                cntMap.remove(x);
            int[] arr = new int[201];
            for (int j = 0; j < arrayList.size(); j++) {
                int x = arrayList.get(j);
                if (0 <= arr[x] && arr[x] < 4) {
                    scoreMap.put(x, scoreMap.getOrDefault(x, 0) + (j + 1));
                    arr[x]++;
                } else if (arr[x] == 4) {
                    arr[x] = j + 1;
                }
            }

            ArrayList result = new ArrayList<>(cntMap.keySet());
            Collections.sort(result, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    if (scoreMap.get(o1).equals(scoreMap.get(o2))) {
                        return arr[o1] - arr[o2];
                    } else {
                        return scoreMap.get(o1) - scoreMap.get(o2);
                    }
                }
            });
            results.add((Integer) result.get(0));
        }
        for(Integer x: results){
            System.out.println(x);
        }

    }
}

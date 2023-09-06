import java.io.*;
import java.util.*;

public class Solution {
    public static <AraayList> void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int tc = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= tc; t++) {
            bw.write("#" + t + "\n");
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            HashSet<String> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                set.add(st.nextToken());
            }
            ArrayList<String> list = new ArrayList<>(set);
            Collections.sort(list, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    if (o1.length() != o2.length())
                        return o1.length() - o2.length();
                    return o1.compareTo(o2);
                }
            });
            for (String s : list) {
                bw.write(s + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

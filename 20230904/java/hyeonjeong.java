import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B5373 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(in.readLine());
            String[] move = new String[n];
            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < n; i++) {
                move[i] = st.nextToken();
            }

            char[][] cube = {
                    { 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w' },
                    { 'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r' },
                    { 'g', 'g', 'g', 'g', 'g', 'g', 'g', 'g', 'g' },
                    { 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b' },
                    { 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o' },
                    { 'y', 'y', 'y', 'y', 'y', 'y', 'y', 'y', 'y' }
            };

            String side = "UFLRBD";

            int[][][] dir = {
                {{ 4, 6, 7, 8 }, { 3, 2, 1, 0 }, { 1, 2, 1, 0 }, { 2, 2, 1, 0 }, { 4, 6, 7, 8 }},
                {{ 2, 8, 5, 2 }, { 0, 6, 7, 8 }, { 3, 6, 3, 0 }, { 5, 0, 1, 2 }, { 2, 8, 5, 2 }},
                {{ 4, 0, 3, 6 }, { 0, 0, 3, 6 }, { 1, 0, 3, 6 }, { 5, 0, 3, 6 }, { 4, 0, 3, 6 }}, 
                {{ 1, 2, 5, 8 }, { 0, 2, 5, 8 }, { 4, 2, 5, 8 }, { 5, 2, 5, 8 }, { 1, 2, 5, 8 }},
                {{ 3, 2, 5, 8 }, { 0, 0, 1, 2 }, { 2, 6, 3, 0 }, { 5, 8, 7, 6 }, { 3, 2, 5, 8 }},
                {{ 1, 6, 7, 8 }, { 3, 6, 7, 8 }, { 4, 2, 1, 0 }, { 2, 6, 7, 8 }, { 1, 6, 7, 8 }}
            };

            System.out.println();
            for (String m : move) {
                int[][] rotate = dir[side.indexOf(m.charAt(0))];
                if(m.charAt(1)=='+') {
                    for(int k=4; k>0; k--) {
                        cube[rotate[k][0]][0] = cube[rotate[k-1][0]][0];
                        cube[rotate[k][0]][1] = cube[rotate[k-1][0]][1];
                        cube[rotate[k][0]][2] = cube[rotate[k-1][0]][2];
                    }
                } else {
                    for(int k=1; k<=4; k++) {
                        cube[rotate[k-1][0]][0] = cube[rotate[k][0]][0];
                        cube[rotate[k-1][0]][1] = cube[rotate[k][0]][1];
                        cube[rotate[k-1][0]][2] = cube[rotate[k][0]][2];
                    }
                }
            }

            for (int i = 0; i < 9; i+=3) {
                sb.append(cube[0][i]);
                sb.append(cube[0][i+1]);
                sb.append(cube[0][i+2]);
                sb.append("\n");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

}

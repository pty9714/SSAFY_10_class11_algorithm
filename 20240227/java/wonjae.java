import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B20327 {

    static int n, r;
    static int[][] origin;
    static int origin_length;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        int m_size = (int) Math.pow(2, n);

        origin = new int[m_size][m_size];
        origin_length = origin.length;

        for(int i = 0; i < m_size; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m_size; j++){
                origin[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < r; i++){
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            Operations(k, l);
        }

        for(int i = 0; i < m_size; i++){
            for(int j = 0; j < m_size; j++){
                sb.append(origin[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    static void Operations(int k, int l){
        int length = (int)Math.pow(2,l);

        switch (k){
            case 1:
                Op1(length);
                break;
            case 2:
                Op2(length);
                break;
            case 3:
                Op3(length);
                break;
            case 4:
                Op4(length);
                break;
            case 5:
                Op5(length);
                break;
            case 6:
                Op6(length);
                break;
            case 7:
                Op7(length);
                break;
            case 8:
                Op8(length);
                break;
        }
    }

    static void Op1(int length){
        for(int i = 0; i < origin_length; i+=length){
            for(int j = 0; j < origin_length; j+=length){
                swap_up_down(i,j,length, 1);
            }
        }
    }

    static void Op2(int length){
        for(int i = 0; i < origin_length; i+=length){
            for(int j = 0; j < origin_length; j+=length){
                swap_left_right(i,j,length, 1);
            }
        }
    }

    static void Op3(int length){
        for(int i = 0; i < origin_length; i+=length){
            for(int j = 0; j < origin_length; j+=length){
                swap_diagonal(i,j,length, 1);
                swap_left_right(i, j, length, 1);
            }
        }

    }
    static void Op4(int length){
        for(int i = 0; i < origin_length; i+=length){
            for(int j = 0; j < origin_length; j+=length){
                swap_diagonal(i,j,length, 1);
                swap_up_down(i, j, length, 1);
            }
        }
    }
    static void Op5(int length){
        swap_up_down(0, 0, origin_length, length);
    }
    static void Op6(int length){
        swap_left_right(0,0, origin_length, length);

    }
    static void Op7(int length){
        swap_diagonal(0,0, origin_length, length);
        swap_left_right(0,0, origin_length, length);

    }
    static void Op8(int length){
        swap_diagonal(0,0,origin_length, length);
        swap_up_down(0,0,origin_length,length);
    }

    static void swap_up_down(int x, int y, int origin_length, int length){
        for(int i = x; i < x+(origin_length/2); i+=length){
            for(int j = y; j < y+origin_length; j+=length){
                int[][] temp = new int[length][length];
                for(int a = 0; a < length; a++){
                    for(int b = 0; b < length; b++){
                        temp[a][b] = origin[i+a][j+b];
                    }
                }
                for(int a= 0; a < length; a++){
                    for(int b = 0; b < length; b++){
                        origin[i+a][j+b] = origin[x*2+origin_length-i-length+a][j+b];
                    }
                }
                for(int a = 0; a < length; a++){
                    for(int b = 0; b < length; b++){
                        origin[x*2+origin_length-i-length+a][j+b] = temp[a][b];
                    }
                }
            }
        }
    }

    static void swap_left_right(int x, int y, int origin_length, int length){

        for(int i = x; i < x+(origin_length); i+=length){
            for(int j = y; j < y+(origin_length/2); j+=length){
                int[][] temp = new int[length][length];
                for(int a = 0; a < length; a++){
                    for(int b = 0; b < length; b++){
                        temp[a][b] = origin[i+a][j+b];
                    }
                }
                for(int a= 0; a < length; a++){
                    for(int b = 0; b < length; b++){
                        origin[i+a][j+b] = origin[i+a][y*2+origin_length-j-length+b];
                    }
                }
                for(int a = 0; a < length; a++){
                    for(int b = 0; b < length; b++){
                        origin[i+a][y*2+origin_length-j-length+b] = temp[a][b];
                    }
                }
            }
        }
    }

    static void swap_diagonal(int x, int y, int origin_length, int length){
        for(int i = 0; i < origin_length; i+=length){
            for(int j = i+length; j < origin_length; j+=length){
                int[][] temp = new int[length][length];
                for(int a = 0; a < length; a++){
                    for(int b = 0; b < length; b++){
                        temp[a][b] = origin[i+x+a][j+y+b];
                    }
                }
                for(int a= 0; a < length; a++){
                    for(int b = 0; b < length; b++){
                        origin[i+x+a][j+y+b] = origin[j+x+a][i+y+b];
                    }
                }
                for(int a = 0; a < length; a++){
                    for(int b = 0; b < length; b++){
                        origin[j+x+a][i+y+b] = temp[a][b];
                    }
                }
            }
        }
    }
}

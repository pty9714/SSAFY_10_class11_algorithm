import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B5373 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			int cube[][][] = {{{'w', 'w', 'w'}, {'w', 'w', 'w'}, {'w', 'w', 'w'}}, {{'y', 'y', 'y'}, {'y', 'y', 'y'}, {'y', 'y', 'y'}},
					{{'r', 'r', 'r'}, {'r', 'r', 'r'}, {'r', 'r', 'r'}}, {{'o', 'o', 'o'}, {'o', 'o', 'o'}, {'o', 'o', 'o'}},
					{{'g', 'g', 'g'}, {'g', 'g', 'g'}, {'g', 'g', 'g'}}, {{'b', 'b', 'b'}, {'b', 'b', 'b'}, {'b', 'b', 'b'}}};
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				String method = st.nextToken();
				switch(method.charAt(0)) {
				case 'U' : 
					spinUp(method.charAt(1), cube);
					break;
				case 'D' : 
					spinDown(method.charAt(1), cube);
					break;
				case 'F' : 
					spinFront(method.charAt(1), cube);
					break;
				case 'B' :
					spinBack(method.charAt(1), cube);
					break;
				case 'L' : 
					spinLeft(method.charAt(1), cube);
					break;
				case 'R' : 
					spinRight(method.charAt(1), cube);
					break;
				}
			}
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					bw.write(cube[0][i][j]);
				}
				bw.write("\n");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}


	private static void spinUp(char c, int[][][] cube) {
		int temp[] = new int[3];
		for (int i = 0; i < 3; i++) {
			temp[i] = cube[2][0][i];
		}
		int upTemp[][] = new int[3][3];
		if(c == '+') {
			for (int i = 0; i < 3; i++) {
				cube[2][0][i] = cube[5][0][i];
			}
			for (int i = 0; i < 3; i++) {
				cube[5][0][i] = cube[3][0][i];
			}
			for (int i = 0; i < 3; i++) {
				cube[3][0][i] = cube[4][0][i];
			}
			for (int i = 0; i < 3; i++) {
				cube[4][0][i] = temp[i];
			}
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					upTemp[i][j] = cube[0][2-j][i];
				}
			}
		}
		else {
			for (int i = 0; i < 3; i++) {
				cube[2][0][i] = cube[4][0][i];
			}
			for (int i = 0; i < 3; i++) {
				cube[4][0][i] = cube[3][0][i];
			}
			for (int i = 0; i < 3; i++) {
				cube[3][0][i] = cube[5][0][i];
			}
			for (int i = 0; i < 3; i++) {
				cube[5][0][i] = temp[i];
			}
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					upTemp[i][j] = cube[0][j][2-i];
				}
			}
		}	
		cube[0] = upTemp;
	}

	private static void spinDown(char c, int[][][] cube) {
		int temp[] = new int[3];
		for (int i = 0; i < 3; i++) {
			temp[i] = cube[2][2][i];
		}
		int downTemp[][] = new int[3][3];
		if(c == '-') {
			for (int i = 0; i < 3; i++) {				
				cube[2][2][i] = cube[5][2][i];
			}
			for (int i = 0; i < 3; i++) {
				cube[5][2][i] = cube[3][2][i];
			}
			for (int i = 0; i < 3; i++) {
				cube[3][2][i] = cube[4][2][i];
			}
			for (int i = 0; i < 3; i++) {
				cube[4][2][i] = temp[i];
			}
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					downTemp[i][j] = cube[1][j][2-i];
				}
			}
		}
		else {
			for (int i = 0; i < 3; i++) {
				cube[2][2][i] = cube[4][2][i];
			}
			for (int i = 0; i < 3; i++) {
				cube[4][2][i] = cube[3][2][i];
			}
			for (int i = 0; i < 3; i++) {
				cube[3][2][i] = cube[5][2][i];
			}
			for (int i = 0; i < 3; i++) {
				cube[5][2][i] = temp[i];
			}
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					downTemp[i][j] = cube[1][2-j][i];
				}
			}
		}
		cube[1] = downTemp;
	}
	
	private static void spinFront(char c, int[][][] cube) {
		int temp[] = new int[3];
		for (int i = 0; i < 3; i++) {
			temp[i] = cube[0][2][i];
		}
		int frontTemp[][] = new int[3][3];
		if(c == '+') {
			for (int i = 0; i < 3; i++) {
				cube[0][2][i] = cube[4][2-i][2];
			}
			for (int i = 0; i < 3; i++) {
				cube[4][i][2] = cube[1][2][2-i];
			}
			for (int i = 0; i < 3; i++) {
				cube[1][2][i] = cube[5][i][0];
			}
			for (int i = 0; i < 3; i++) {
				cube[5][i][0] = temp[i];
			}
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					frontTemp[i][j] = cube[2][2-j][i];
				}
			}
		}
		else {
			for (int i = 0; i < 3; i++) {
				cube[0][2][i] = cube[5][i][0];
			}
			for (int i = 0; i < 3; i++) {
				cube[5][i][0] = cube[1][2][i];
			}
			for (int i = 0; i < 3; i++) {
				cube[1][2][i] = cube[4][2-i][2];
			}
			for (int i = 0; i < 3; i++) {
				cube[4][i][2] = temp[2-i];
			}
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					frontTemp[i][j] = cube[2][j][2-i];
				}
			}
		}
		cube[2] = frontTemp;
	}

	private static void spinBack(char c, int[][][] cube) {
		int temp[] = new int[3];
		for (int i = 0; i < 3; i++) {
			temp[i] = cube[0][0][i];
		}
		int backTemp[][] = new int[3][3];
		if(c == '-') {
			for (int i = 0; i < 3; i++) {
				cube[0][0][i] = cube[4][2-i][0];
			}
			for (int i = 0; i < 3; i++) {
				cube[4][i][0] = cube[1][0][2-i];
			}
			for (int i = 0; i < 3; i++) {
				cube[1][0][i] = cube[5][i][2];
			}
			for (int i = 0; i < 3; i++) {
				cube[5][i][2] = temp[i];
			}
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					backTemp[i][j] = cube[3][j][2-i];
				}
			}
		}
		else {
			for (int i = 0; i < 3; i++) {
				cube[0][0][i] = cube[5][i][2];
			}
			for (int i = 0; i < 3; i++) {
				cube[5][i][2] = cube[1][0][i];
			}
			for (int i = 0; i < 3; i++) {
				cube[1][0][i] = cube[4][2-i][0];
			}
			for (int i = 0; i < 3; i++) {
				cube[4][i][0] = temp[2-i];
			}
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					backTemp[i][j] = cube[3][2-j][i];
				}
			}
		}
		cube[3] = backTemp;
	}

	private static void spinLeft(char c, int[][][] cube) {
		int temp[] = new int[3];
		for (int i = 0; i < 3; i++) {
			temp[i] = cube[0][i][0];
		}
		int leftTemp[][] = new int[3][3];
		if(c == '+') {
			for (int i = 0; i < 3; i++) {
				cube[0][i][0] = cube[3][2-i][2];
			}
			for (int i = 0; i < 3; i++) {
				cube[3][i][2] = cube[1][i][2];
			}
			for (int i = 0; i < 3; i++) {
				cube[1][i][2] = cube[2][2-i][0];
			}
			for (int i = 0; i < 3; i++) {
				cube[2][i][0] = temp[i];
			}
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					leftTemp[i][j] = cube[4][2-j][i];
				}
			}
		}
		else {
			for (int i = 0; i < 3; i++) {
				cube[0][i][0] = cube[2][i][0];
			}
			for (int i = 0; i < 3; i++) {
				cube[2][i][0] = cube[1][2-i][2];
			}
			for (int i = 0; i < 3; i++) {
				cube[1][i][2] = cube[3][i][2];
			}
			for (int i = 0; i < 3; i++) {
				cube[3][i][2] = temp[2-i];
			}
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					leftTemp[i][j] = cube[4][j][2-i];
				}
			}
		}
		cube[4] = leftTemp;
	}
	
	private static void spinRight(char c, int[][][] cube) {
		int temp[] = new int[3];
		for (int i = 0; i < 3; i++) {
			temp[i] = cube[0][i][2];
		}
		int rightTemp[][] = new int[3][3];
		if(c == '-') {
			for (int i = 0; i < 3; i++) {
				cube[0][i][2] = cube[3][2-i][0];
			}
			for (int i = 0; i < 3; i++) {
				cube[3][i][0] = cube[1][i][0];
			}
			for (int i = 0; i < 3; i++) {
				cube[1][i][0] = cube[2][2-i][2];
			}
			for (int i = 0; i < 3; i++) {
				cube[2][i][2] = temp[i];
			}
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					rightTemp[i][j] = cube[5][j][2-i];
				}
			}
		}
		else {
			for (int i = 0; i < 3; i++) {
				cube[0][i][2] = cube[2][i][2];
			}
			for (int i = 0; i < 3; i++) {
				cube[2][i][2] = cube[1][2-i][0];
			}
			for (int i = 0; i < 3; i++) {
				cube[1][i][0] = cube[3][i][0];
			}
			for (int i = 0; i < 3; i++) {
				cube[3][i][0] = temp[2-i];
			}
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					rightTemp[i][j] = cube[5][2-j][i];
				}
			}
		}
		cube[5] = rightTemp;
	}

}
// 29532KB,	228ms
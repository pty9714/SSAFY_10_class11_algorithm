import java.util.*;
import java.io.*;

public class Main {

	// 0 윗면
	// 1 앞면
	// 2 오른쪽 면
	// 3 뒷면
	// 4 왼쪽 면
	// 5 아래 면

	private static void rotationRight(int target, char[][][] q) {
		char[] temp = new char[3];
		temp[0] = q[target][0][0];
		temp[1] = q[target][1][0];
		temp[2] = q[target][2][0];

		q[target][0][0] = q[target][2][0];
		q[target][1][0] = q[target][2][1];
		q[target][2][0] = q[target][2][2];

		q[target][2][0] = q[target][2][2];
		q[target][2][1] = q[target][1][2];
		q[target][2][2] = q[target][0][2];

		q[target][2][2] = q[target][0][2];
		q[target][1][2] = q[target][0][1];
		q[target][0][2] = q[target][0][0];

		q[target][0][2] = temp[0];
		q[target][0][1] = temp[1];
		q[target][0][0] = temp[2];
	}

	private static void rotationLeft(int target, char[][][] q) {
		char[] temp = new char[3];
		temp[0] = q[target][2][0];
		temp[1] = q[target][1][0];
		temp[2] = q[target][0][0];
		
		q[target][2][0] = q[target][0][0];
		q[target][1][0] = q[target][0][1];
		q[target][0][0] = q[target][0][2];

		q[target][0][0] = q[target][0][2];
		q[target][0][1] = q[target][1][2];
		q[target][0][2] = q[target][2][2];

		q[target][0][2] = q[target][2][2];
		q[target][1][2] = q[target][2][1];
		q[target][2][2] = q[target][2][0];

		q[target][2][2] = temp[0];
		q[target][2][1] = temp[1];
		q[target][2][0] = temp[2];
		

	}

	private static void swapRight(int target, char[][][] q) {
		if (target == 0) {
			char[] temp = new char[3];
			temp[0] = q[1][0][0];
			temp[1] = q[1][0][1];
			temp[2] = q[1][0][2];
			for (int i = 0; i < 3; i++) {
				q[1][0][i] = q[2][0][i];
			}
			for (int i = 0; i < 3; i++) {
				q[2][0][i] = q[3][0][i];
			}
			for (int i = 0; i < 3; i++) {
				q[3][0][i] = q[4][0][i];
			}
			for (int i = 0; i < 3; i++) {
				q[4][0][i] = temp[i];
			}
		} else if (target == 1) {
			char[] temp = new char[3];
			temp[0] = q[0][2][0];
			temp[1] = q[0][2][1];
			temp[2] = q[0][2][2];
			for (int i = 0; i < 3; i++) {
				q[0][2][i] = q[4][2 - i][2];
			}
			for (int i = 0; i < 3; i++) {
				q[4][2 - i][2] = q[5][0][2 - i];
			}
			for (int i = 0; i < 3; i++) {
				q[5][0][2 - i] = q[2][i][0];
			}
			for (int i = 0; i < 3; i++) {
				q[2][i][0] = temp[i];
			}
		} else if (target == 2) {
			char[] temp = new char[3];
			temp[0] = q[0][2][2];
			temp[1] = q[0][1][2];
			temp[2] = q[0][0][2];

			for (int i = 0; i < 3; i++) {
				q[0][2 - i][2] = q[1][2 - i][2];
			}

			for (int i = 0; i < 3; i++) {
				q[1][2 - i][2] = q[5][2 - i][2];
			}
			for (int i = 0; i < 3; i++) {
				q[5][2 - i][2] = q[3][i][0];
			}
			for (int i = 0; i < 3; i++) {
				q[3][i][0] = temp[i];
			}
		} else if (target == 3) {

			char[] temp = new char[3];
			temp[0] = q[0][0][2];
			temp[1] = q[0][0][1];
			temp[2] = q[0][0][0];

			for (int i = 0; i < 3; i++) {
				q[0][0][2 - i] = q[2][2 - i][2];
			}
			for (int i = 0; i < 3; i++) {
				q[2][2 - i][2] = q[5][2][i];
			}
			for (int i = 0; i < 3; i++) {
				q[5][2][i] = q[4][i][0];
			}
			for (int i = 0; i < 3; i++) {
				q[4][i][0] = temp[i];
			}

		} else if (target == 4) {

			char[] temp = new char[3];
			temp[0] = q[0][0][0];
			temp[1] = q[0][1][0];
			temp[2] = q[0][2][0];

			for (int i = 0; i < 3; i++) {
				q[0][i][0] = q[3][2 - i][2];
			}
			for (int i = 0; i < 3; i++) {
				q[3][2 - i][2] = q[5][i][0];
			}
			for (int i = 0; i < 3; i++) {
				q[5][i][0] = q[1][i][0];
			}
			for (int i = 0; i < 3; i++) {
				q[1][i][0] = temp[i];
			}

		} else if (target == 5) {
			char[] temp = new char[3];
			temp[0] = q[1][2][0];
			temp[1] = q[1][2][1];
			temp[2] = q[1][2][2];

			for (int i = 0; i < 3; i++) {
				q[1][2][i] = q[4][2][i];
			}
			for (int i = 0; i < 3; i++) {
				q[4][2][i] = q[3][2][i];
			}
			for (int i = 0; i < 3; i++) {
				q[3][2][i]= q[2][2][i];
			}
			for (int i = 0; i < 3; i++) {
				q[2][2][i] = temp[i];
			}
		}
	}

	private static void swapLeft(int target, char[][][] q) {
		if (target == 0) {
			char[] temp = new char[3];
			temp[0] = q[1][0][0];
			temp[1] = q[1][0][1];
			temp[2] = q[1][0][2];
			for (int i = 0; i < 3; i++) {
				q[1][0][i] = q[4][0][i];
			}
			for (int i = 0; i < 3; i++) {
				q[4][0][i] = q[3][0][i];
			}
			for (int i = 0; i < 3; i++) {
				q[3][0][i] = q[2][0][i];
			}
			for (int i = 0; i < 3; i++) {
				q[2][0][i] = temp[i];
			}
		} else if (target == 1) {
			char[] temp = new char[3];
			temp[0] = q[0][2][0];
			temp[1] = q[0][2][1];
			temp[2] = q[0][2][2];
			for (int i = 0; i < 3; i++) {
				q[0][2][i] = q[2][i][0];
			}
			for (int i = 0; i < 3; i++) {
				q[2][i][0] = q[5][0][2 - i];
			}
			for (int i = 0; i < 3; i++) {
				q[5][0][2 - i] = q[4][2 - i][2];
			}
			for (int i = 0; i < 3; i++) {
				q[4][2 - i][2] = temp[i];
			}
		} else if (target == 2) {
			char[] temp = new char[3];
			temp[0] = q[0][2][2];
			temp[1] = q[0][1][2];
			temp[2] = q[0][0][2];

			for (int i = 0; i < 3; i++) {
				q[0][2 - i][2] = q[3][i][0];
			}

			for (int i = 0; i < 3; i++) {
				q[3][i][0] = q[5][2 - i][2];
			}
			for (int i = 0; i < 3; i++) {
				q[5][2 - i][2] = q[1][2 - i][2];
			}
			for (int i = 0; i < 3; i++) {
				q[1][2 - i][2] = temp[i];
			}

		} else if (target == 3) {
			char[] temp = new char[3];
			temp[0] = q[0][0][2];
			temp[1] = q[0][0][1];
			temp[2] = q[0][0][0];
			for (int i = 0; i < 3; i++) {
				q[0][0][2 - i] = q[4][i][0];
			}
			for (int i = 0; i < 3; i++) {
				q[4][i][0] = q[5][2][i];

			}
			for (int i = 0; i < 3; i++) {
				q[5][2][i] = q[2][2 - i][2];
			}
			for (int i = 0; i < 3; i++) {
				q[2][2 - i][2] = temp[i];
			}
		} else if (target == 4) {

			char[] temp = new char[3];
			temp[0] = q[0][0][0];
			temp[1] = q[0][1][0];
			temp[2] = q[0][2][0];

			for (int i = 0; i < 3; i++) {
				q[0][i][0] = q[1][i][0];
			}
			for (int i = 0; i < 3; i++) {
				q[1][i][0] = q[5][i][0];
			}
			for (int i = 0; i < 3; i++) {
				q[5][i][0] = q[3][2 - i][2];
			}
			for (int i = 0; i < 3; i++) {
				q[3][2 - i][2] = temp[i];
			}

		} else if (target == 5) {
			char[] temp = new char[3];
			temp[0] = q[1][2][0];
			temp[1] = q[1][2][1];
			temp[2] = q[1][2][2];

			for (int i = 0; i < 3; i++) {
				q[1][2][i] = q[2][2][i];
			}
			for (int i = 0; i < 3; i++) {
				q[2][2][i] = q[3][2][i];
			}
			for (int i = 0; i < 3; i++) {
				q[3][2][i]= q[4][2][i];
			}
			for (int i = 0; i < 3; i++) {
				q[4][2][i] = temp[i];
			}
		}
	}

	private static void rotationTarget(char[][][] q, String command) {
		String[] c = command.split("");
		if (c[0].equals("U")) { // 윗면이 회전해야함
			if (c[1].equals("+")) { // 시계방향 회전
				rotationRight(0, q);
				swapRight(0, q);
			} else {
				rotationLeft(0, q);
				swapLeft(0, q);
			}
		} else if (c[0].equals("F")) {
			if (c[1].equals("+")) {
				rotationRight(1, q);
				swapRight(1, q);
			} else {
				rotationLeft(1, q);
				swapLeft(1, q);
			}
		} else if (c[0].equals("R")) {
			if (c[1].equals("+")) {
				rotationRight(2, q);
				swapRight(2, q);
			} else {
				rotationLeft(2, q);
				swapLeft(2, q);
			}
		} else if (c[0].equals("B")) {
			if (c[1].equals("+")) {
				rotationRight(3, q);
				swapRight(3, q);
			} else {
				rotationLeft(3, q);
				swapLeft(3, q);
			}
		} else if (c[0].equals("L")) {
			if (c[1].equals("+")) {
				rotationRight(4, q);
				swapRight(4, q);
			} else {
				rotationLeft(4, q);
				swapLeft(4, q);
			}
		} else if (c[0].equals("D")) {
			if (c[1].equals("+")) {
				rotationRight(5, q);
				swapRight(5, q);
			} else {
				rotationLeft(5, q);
				swapLeft(5, q);
			}
		}
	}

	private static void init(int index, char[][][] q, char c) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				q[index][i][j] = c;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= N; t++) {

			char[][][] q = new char[6][3][3];
			char[] color = { 'w', 'r', 'b', 'o', 'g', 'y' };
			// 큐브 초기화
			for (int i = 0; i < 6; i++) {
				init(i, q, color[i]);
			}
			int C = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			String[] string = new String[C];
			for (int i = 0; i < C; i++) {
				string[i] = st.nextToken();
			}

			// 입력 끝

			for (int i = 0; i < string.length; i++) {
				rotationTarget(q, string[i]);
				
			}

			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					sb.append(q[0][i][j]);
				}
				sb.append("\n");
			}
		}
		
		System.out.println(sb);

	}
}

71816kb	456ms

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 11620KB, 76ms
public class B11444 {
	
	public static long div = 1000000007;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		long n = Long.parseLong(br.readLine());
		
		long[][] matrix = {{1, 1}, {1, 0}};
		
		long ans = pow(matrix, n)[0][1];
		
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static long[][] pow(long[][] matrix, long n) {
		if(n == 1) {
			long[][] start = {{1, 1}, {1, 0}};
			return start;
		}
		
		long[][] temp = pow(matrix, n / 2);
	
		if(n % 2 == 1) {
			return matrixMul(matrixMul(temp, temp), matrix);
		}
		else {
			return matrixMul(temp, temp);
		}
	}
	
	public static long[][] matrixMul(long[][] op1, long[][] op2) {
		long[][] result = new long[2][2];
		
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				for (int k = 0; k < 2; k++) {
					result[i][j] += op1[i][k] * op2[k][j];
					result[i][j]  %= div;
				}
			}
		}
		
		return result;
	}

}
/*
 행렬곱 문제
 |f(n+1) f(n)|   |1 1|^n
 |f(n) f(n-1)| = |1 0|
 
 -> |a1 a2|   |b1 b2|
 	|a2 a3| * |b3 b4|
 	= |a1*b1+a1*b3 a1*b2+a2*b4|
 	  |a2*b1+a3*b3 a2*b2+a3*b4|
*/

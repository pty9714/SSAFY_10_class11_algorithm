import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
	public static void main(String args[]) throws Exception
	{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int t=1; t<=tc; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            long n = Integer.parseInt(st.nextToken());
            long a = Integer.parseInt(st.nextToken());
            long b = Integer.parseInt(st.nextToken());

            long minValue = Integer.MAX_VALUE;
            for(int r=1; r<=Math.sqrt(n); r++) {
                for(int c=r; c<=n/r; c++) {
                    long value = a * Math.abs(r-c) + b * (n - r * c);
                    if (value < minValue) minValue = value;
                }
            }
			System.out.printf("#%d %d%n", t, minValue);

        }
	}
}
// 22,124 kb 828 ms

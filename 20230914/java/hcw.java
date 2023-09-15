import java.util.*;
import java.io.*;

public class Main {

	// 움직이는 칸수
	static int[] arr;
	// 맵 점수
	static int[] map = {0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 13, 16, 19, 22, 24, 28, 27, 26, 25, 30, 35, 40, 0};
	// static 			0  1  2  3  4  5   6   7   8   9   10  11  12  13  14  15  16  17  18  19  20  21  22  23  24  25  26  27  28  29  30  31  32
	// 말들의 현재 위치
	static int[] current;
	static int max = 0;

	private static void search(int count, int score) {
		if (count == 10) {
//			System.out.println(score);
			max = Math.max(max, score);
			return;
		} else {
			label:for(int i = 0; i < 4; i++) { //말이 네개
				if(current[i] != 32) { //32가 아니라면 
					int temp = current[i]; //현재 위치 저장
					if (current[i] == 5) { // 분기점에서 시작한다면
						current[i] = 20; //한칸갔음
						for (int j = 0; j < arr[count] - 1; j++) { //가야되는 칸수만큼 이동
							if(current[i] == 32) { //32라면 도착임
								break;
							}
							
							//이동해야한다면
							if (current[i] == 22) { //19에 도착하면 다음 칸은 25로 가야함 
								current[i] = 28; //한칸옴
							}else {
								current[i]++; //그게 아니라면 
							}
						}
						
						if(current[i] != 32) { //32이하일때
							for(int j = 0; j< 4; j++) {  // 그 자리에 말이 있는지
								if(i != j && current[j] == current[i]) { //있다면
									current[i] = temp; //초기 위치로 돌리고
									continue label; //label 진행시킴
								}
							}
						}
					} else if (current[i] == 10) { // 분기점
						current[i] = 23; //한칸옴
						
						for (int j = 0; j < arr[count] - 1; j++) {
							if(current[i] == 32) {
								break;
							}

							if (current[i] == 24) { // 무조건 이동
								current[i] = 28;
							}else {
								current[i]++;
							}
						}
						
						if(current[i] != 32) {
							for(int j = 0; j< 4; j++) {  // 그 자리에 말이 있는지
								if(i != j && current[j] == current[i]) { //i와 j가 같지 않은데 있는 위치가 같을때 놓을 수 없음 
									current[i] = temp;
									continue label;
								}
							}
						}
					} else if (current[i] == 15) { // 분기점
						current[i] = 25; //한칸 옴
						
						for (int j = 0; j < arr[count]-1; j++) {
							if(current[i] == 32) {
								break;
							}
							current[i]++;
						}
						
						if(current[i] != 32) {
							for(int j = 0; j< 4; j++) {  // 그 자리에 말이 있는지
								if(i != j && current[j] == current[i]) {
									current[i] = temp;
									continue label;
								}
							}
						}
					}else { //아무것도 아닐
						for (int j = 0; j < arr[count]; j++) { 
							if(current[i] == 32) {
								break;
							}
							if (current[i] == 19) { // 무조건 이동
								current[i] = 31;
							}else {
								current[i]++;
							}
						}

						if(current[i] != 32) {
							for(int j = 0; j< 4; j++) {  // 그 자리에 말이 있는지
								if(i != j && current[j] == current[i]) {
									current[i] = temp;
									continue label;
								}
							}
						}
					}
					
//					System.out.println(i + " "+ map[current[i]]);
//					System.out.println(score + map[current[i]]);
					search(count+1, score + map[current[i]]);
//					System.out.println(temp);
					current[i] = temp;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		current = new int[4];

		search(0, 0);

		System.out.print(max);

	}
}

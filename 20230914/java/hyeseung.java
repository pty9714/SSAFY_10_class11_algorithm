package com.ssafy.hw;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B17825 {
	
	public static int ans = 0;
	public static ArrayList<ArrayList<Integer>> route = new ArrayList<ArrayList<Integer>>();
	public static int[][] horse = new int[4][2];
	public static int[] dice;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		dice = new int[10];
		
		for (int i = 0; i < 10; i++) {
			dice[i] = Integer.parseInt(st.nextToken());
		}
		
		// 빨간색 route
		route.add(new ArrayList<>());
		for(int i = 0; i <= 40; i+=2) {
			route.get(0).add(i);
		}
		// 파란색 route
		route.add(new ArrayList<>(Arrays.asList(0, 13, 16, 19, 25, 30, 35, 40)));
		route.add(new ArrayList<>(Arrays.asList(0, 22, 24, 25, 30, 35, 40)));
		route.add(new ArrayList<>(Arrays.asList(0, 28, 27, 26, 25, 30, 35, 40)));

		dfs(0, 0);
		bw.write(ans + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static void dfs(int cnt, int score) {
		if(cnt == 10) {
			ans = Math.max(ans, score);
			return;
		}
		for (int i = 0; i < 4; i++) {
			int tempIndex = horse[i][0];
			int tempArrive = horse[i][1];
			int tempScore = 0; // 더해질 점수
			if(horse[i][1] == -1) continue; // 이미 도착한 말인 경우 pass
			int arrive = horse[i][1] + dice[cnt]; // 말이 마칠 인덱스
			boolean flag = false;
			if(arrive >= route.get(horse[i][0]).size()) { // 이동을 마치는 칸이 도착인 경우
				horse[i][1] = -1; 
			}
			else { // 마칠 수 있는 경우
				for (int j = 0; j < 4; j++) { // 이동을 마치는 칸에 다른 말이 있으면 pass 
					if(i != j && horse[j][1] != -1) { // 도착칸일 경우 pass
						if(horse[j][0] == 0 && horse[j][1] == 0) continue; // 시작칸일 경우 pass
						if(route.get(horse[i][0]).get(arrive) == 40 && route.get(horse[j][0]).get(horse[j][1]) == 40) { // 40인 칸이 겹치는 경우
							flag = true;
							break;
						}
						// 10, 20, 30인 칸이 겹치는 경우
						if(horse[j][0] != 0 && horse[j][1] == 0 && route.get(horse[i][0]).get(arrive) % 10 == 0 
								&& route.get(horse[i][0]).get(arrive) != 40 && horse[i][0] == 0 && route.get(horse[i][0]).get(arrive) / 10 == horse[j][0]) {
							flag = true;
							break;
						}
						// 같은 칸인 경우
						if(horse[i][0] == horse[j][0] && arrive == horse[j][1]) { 
							flag = true;
							break;
						}
						// 25, 30, 35인 칸이 겹치는 경우
						if(horse[i][0] != 0 && horse[j][0] != 0 && route.get(horse[i][0]).get(arrive) == route.get(horse[j][0]).get(horse[j][1])) {
							flag = true;
							break;
						}
					}
				}
				if(flag) continue;
				horse[i][1] = arrive; // 해당 말로 갈 수 있으면 마치는 칸 update
				tempScore = route.get(horse[i][0]).get(horse[i][1]);
				if(horse[i][0] == 0 && (horse[i][1] == 5 || horse[i][1] == 10 || horse[i][1] == 15)) { // 파란 route로 이동
					horse[i][0] = horse[i][1] / 5;
					horse[i][1] = 0;
				}
			}
			dfs(cnt + 1, score + tempScore);
			horse[i][0] = tempIndex;
			horse[i][1] = tempArrive;
		}
	}
}
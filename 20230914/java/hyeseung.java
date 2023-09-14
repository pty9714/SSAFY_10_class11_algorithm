package com.ssafy.hw;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B17825 {
	
	public static int[] blue = {13, 22, 28};
	public static int[] board = {2, -1, -1, 4, -1, 6, -1, 10, -1, 12, -1, 14, -1, 16, -1, 18, 25;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] dice = new int[10];
		
		for (int i = 0; i < 10; i++) {
			dice[i] = Integer.parseInt(st.nextToken());
		}
		
		
		
		bw.flush();
		bw.close();
		br.close();
	}

}

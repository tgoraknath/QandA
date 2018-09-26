package com.gogo.arrays;

public class Spiral2D {

	public static void main(String[] args) {
		int[][] values = spiral(2);
		printMetrix(values);
		printSpiral(values);
	
	}
	private static void printSpiral(int[][] values) {
		int total = values[0].length * values[1].length;
		int row = 0;
		int col = 0;
		int dir = 0;
		int row_dir[] = {0, 1, 0, -1};
		int col_dir[] = {1, 0, -1, 0}; 
		int count = 0;
		while(count < total) {
			System.out.println(values[row][col]);
			row += row_dir[dir];
			col += col_dir[dir];
			if(isValid(values, row, col)) {
				row -= row_dir[dir];
				col -= col_dir[dir];
				dir = (dir+1)%4;
				row += row_dir[dir];
				col += col_dir[dir];
			}
			count++;
		}
		
	}
	private static void printMetrix(int[][] values) {
		int r_l = values[0].length;
		int c_l = values[1].length;
		for(int i = 0; i < r_l; i++) {
			for (int j =0; j < c_l; j++) {
				System.out.print(values[i][j]+ " ");
			}
			System.out.println();
		}
	}
	public static int[][] spiral(int n) {
		int[][] retArray = new int[n][n];
		int count = 0;
		int row = 0;
		int col = 0;
		int dir = 0;
		int totalVol = n * n;
		int[] dc = {1, 0, -1, 0};
		int[] dr = {0, 1, 0, -1};
		while(count++ < totalVol) {
			retArray[row][col] = count;
			row += dr[dir];
			col += dc[dir];
			if(isValid(retArray, row, col)) {
				row -= dr[dir];
			     col -= dc[dir];
			     dir = (dir+1)%4;
			     row += dr[dir];
			     col += dc[dir];
			}
		}
		return retArray;
	}
	
	public static boolean isValid(int[][] arr, int row, int col) {
		//return row < 0 || col < 0 || row >= arr.length || 
		//		col >= arr.length || arr[row][col] != 0 ;
		return row < 0 || col < 0 || row >= arr.length || 
			col >= arr.length;
	}

}

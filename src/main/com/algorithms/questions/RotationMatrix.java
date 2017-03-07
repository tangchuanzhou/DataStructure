/**
 * 
 */
package com.algorithms.questions;

import static java.lang.Math.max;

import com.algorithms.util.StdOut;
/**
 * @author tangchuanzhou
 * 给定一个整数，输出一个方阵的顺时针矩阵
 * N = 2
 * 输出 
 * 1 2
 * 4 3
 * N = 4
 * 输出
 * 1   2  3  4
 * 12 13 14  5
 * 11 16 15  6
 * 10  9  8  7 
 */
public class RotationMatrix {
	private static int N;
	int[][] matrix;
	public RotationMatrix(int n) {
		N = n;
		matrix = new int[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				matrix[i][j] = 0;
			}
		}
	}
	
	public void generate() {
		int left = 0, right = N-1, bottom = N-1, top = 0, num =1;
		while(left < right && top < bottom) {
			//first line
			for(int i = left; i < right; i++) {
				matrix[top][i] = num++;
			}
			//right column
			for(int i = top; i < bottom; i++) {
				matrix[i][right] = num++;
			}
			//last line
			for(int i = right; i > left; i--) {
				matrix[bottom][i] = num++;
			}
			//left column
			for(int i = bottom; i > top; i--) {
				matrix[i][left] = num++;
			}
			top++;
			bottom--;
			left++;
			right--;
			
			if(N%2 == 1) {
				matrix[N/2][N/2] = num;
			}
		}
	}

	
	public void print() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				StdOut.print(matrix[i][j] + " ");
			}
			StdOut.print("\n");
		}		
	}
	
	public static void main(String[] args) {
		StdOut.println(max(2,1)); //import static class method
		RotationMatrix matrix = new RotationMatrix(4);
		matrix.generate();
		matrix.print();
	}
}
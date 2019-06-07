// Copyright (c) 2019, Matthew Chalifoux.

/*
 * program to build magic n x n squares, n must be odd
 */
import java.util.Scanner;
public class psixnineteen {
	
	
	public static void main(String[] args) {
		
	
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter odd number : ");
		
		int n = in.nextInt();
		
		int[][] cube = new int[n][n];
		
		int row = n - 1;
		int column = n / 2;
		
		int maxLength = 0;
		
		for(int i = 1; i < n*n; ++i) {
			
			cube[row][column] = i;
			String sub = "" + i;
			
			if(sub.length() > maxLength) {
				maxLength = sub.length();
			}
			
			
			
			
			System.out.println(cube[row][column]);
			
			int lastRow = row;
			int lastColumn = column;
			
			++row;
			++column;
			 
			if(n == row) {
				row = 0;
			}
			if(n == column) {
				column = 0;
			}
			if(0 != cube[row][column]) {
				row = lastRow; 
				column = lastColumn;
				--row;
			}			
		}
		
		for(int i = 0; i < cube.length; ++i) {
			for(int j = 0; j < cube[0].length; ++j) {
				
				System.out.print(cube[i][j]);
				String sub = "" + cube[i][j];
				int spaces = maxLength - sub.length();
				for(int b = 0; b < spaces; ++b) {
					System.out.print(" ");
				}
				System.out.print(" ");
				
			}
			System.out.println(" ");
		}
		
		
	}
}

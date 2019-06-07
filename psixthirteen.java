// Copyright (c) 2019, Matthew Chalifoux.

/**
 * Program to generate 20 random die tosses in an array, and print die values, marking the longest one
 * 
 * @author Matt
 *
 */



public class psixthirteen {

	
	public static void main(String[] args) {
		
		
		int[] combo = new int[20];
		
		
		int currentIndexStart = 0;
		int currentLength = 1;
		int maxLength = 1;
		int maxIndexStart = 0;
		int maxIndexEnd = 0;
		int currentIndexEnd = 0;
		boolean consecutive = false;
		
		combo[0] = (int) (Math.random()*6) + 1;	
		System.out.println("combo[0] = " + combo[0]);
		
		for(int i = 1; i < 20; ++i) {
			combo[i] = (int) (Math.random()*6) + 1;			
			System.out.println("combo[" + i + "] = " + combo[i]);
			
			//this item equals the last item
			if(combo[i] == combo[i-1]) {
				
				//this means consecutive more than two in a row
				if(consecutive == true) {
					currentLength += 1;
					currentIndexEnd = i;
					if(currentLength > maxLength) {
						maxLength = currentLength;
						maxIndexStart = currentIndexStart;
						maxIndexEnd = currentIndexEnd;
					}
				}
				//this means this is the second in a row
				else {
					consecutive = true;
					currentLength = 2;
					currentIndexStart = i - 1;
					currentIndexEnd = i;
					if(currentLength > maxLength) {
						maxLength = currentLength;
						maxIndexStart = currentIndexStart;
						maxIndexEnd = currentIndexEnd;
					}
				}
				
			}
			//this item does not equal the last item
			else {
				if(consecutive == true) {
					consecutive = false;
					currentLength = 1;
					currentIndexStart = i;
					currentIndexEnd = i;
				}
				else {
					currentLength = 1;
					currentIndexStart = i;
					currentIndexEnd = i;
				}
			}
		}
		
		//print out list
		for(int i = 0; i < 20; ++i) {
			
			//if maxIndexStart == i
			if(i == maxIndexStart && maxLength > 1) {
				System.out.print("(" + combo[i] + " ");
				
			}
			//if maxIndexEnd == i
			else if(i == maxIndexEnd && maxLength > 1) {
				System.out.print(combo[i] + ") ");
			}
			//if normal
			else {
				System.out.print(combo[i] + " ");
			}			
		}				
	}	
}

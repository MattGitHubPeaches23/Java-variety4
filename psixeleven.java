// Copyright (c) 2019, Matthew Chalifoux.

/**
 * program to see if two arrays have the same element sequence in the same order
 * @author Matt
 *
 */
public class psixeleven {
	
	public static boolean sameElements(int[] a, int[] b){
		
		boolean itsOver = false;
		boolean subOver = false;
		int p = 0;
				
		if(a.length == b.length) {
			
			
			for(int i = 0; i < a.length; ++i) {			
				
				
				if(b[0] == a[i]) {
					
					int b2 = 1;
					int a2 = 0;
					
					if(i + 1 != a.length) {
						a2 = i + 1;
					}
					else {
						a2 = 0;
					}
					
					boolean inner = false;
					int count = 1;
					boolean match = false;
					
					//checkArray
					while(inner == false) {
						
						if(b[b2] == a[a2]) {
							++b2;
							if(a2 + 1 != a.length) {
								a2 = a2 + 1;
							}
							else {
								a2 = 0;
							}
							count += 1;
						}
						else {
							inner = true;
						}
						if(count == a.length) {
							
							match = true;
							inner = true;
							return true;
							
						}
					}
					
					
				}
				else {
					
				}
				
			}
			
			
			
		}
		else {
			System.out.println("Inproper Input!");
		}
			
		
		
		return false;
	}
	
	public static void main(String[] args) {
		
		int[] a = {1,4,9,16,9,7,4,9,11};
		int[] b = {11,1,4,9,16,9,7,4,9};
		int[] c = {11,11,7,9,16,4,1,4,9};

//		int[] a = {1,5,6,2,4,5};
//		int[] b = {2,4,5,1,5,6};
//		int[] c = {5,6,2,4,5,8};
		
		//first test
		if(sameElements(a,c)) {
			System.out.println("FIRST TEST!");
			System.out.println("Same sequence!");
		}
		else {
			System.out.println("Not the same sequence!");
		}		
		
		
		//second test
		if(sameElements(a,b)) {
			System.out.println("SECOND TEST!");
			System.out.println("Same sequence!");
		}
		else {
			System.out.println("Not the same sequence!");
		}	
		
	}
}

// Copyright (c) 2019, Matthew Chalifoux.

/**
 * Program that does stuff p.306 p6.2
 * @author Matt
 *
 */
public class psixtwo {
	
	public static void swapFirstandLast(int[] a) {
		
		int sub = a[0];
		int sub2 = a[a.length - 1];
		
		a[0] = sub2;
		a[a.length - 1] = sub;
		
	}
	
	public static void print(int[] a) {
		for(int i = 0; i < a.length; ++i) {
			System.out.print(a[i] + " ");
		}
		System.out.println(" ");
	}
	
	public static void shiftToRight(int[] a) {
		
		int sub = a[a.length - 1];
		
		for(int i = a.length - 1; i > 0; --i) {
			
			a[i] = a[i-1];
			
		}
		a[0] = sub;
	}
	
	public static void evenToZero(int[] a) {
		
		for(int i = 0; i < a.length; ++i) {
			
			if(0 == (a[i] % 2)) {
				a[i] = 0;
			}			
		}		
	}
	
	
	public static void replaceLargerNeighbor(int[] a) {
		
		
		int[] b = new int[a.length];
		
		b[0] = a[0];
		b[a.length - 1] = a[a.length - 1];
		
		for(int i = 1; i < a.length - 1; ++i) {
			
			if(a[i-1] >= a[i+1]) {
				
				b[i] = a[i-1];
			}
			else {
				b[i] = a[i+1];
			}			
		}
		
		for(int i = 1; i < a.length - 1; ++i) {
			
			a[i] = b[i];
			
		}		
	}
	
	public static void replaceMiddleOdd(int[] a, int[] b) {
		
		int p = 0;
		for(int i = 0; i < a.length; ++i) {
			
			if((a.length / 2) == i) {
				
			}
			else {
				b[p] = a[i];
				++p;
			}
		}		
	}
	
	public static void replaceMiddleEven(int[] a, int[] b) {
		
		int p = 0;
		int sub = a.length / 2;
		int sub2 = sub - 1;
		
		for(int i = 0; i < a.length; ++i) {
			
			if(i == sub || i == sub2) {
				
			}
			else {
				b[p] = a[i];
				++p;
			}
		}			
	}
	
	public static void moveEvenToFront(int[] a) {
		
		
		int[] even = new int[100];
		int[] odd = new int[100];
		int evenCount = 0;
		int oddCount = 0;
		
		for(int i = 0; i < a.length; ++i) {
			
			if(((0 == (a[i] % 2)) && (1 != a[i])) || 0 == a[i]) {
				
				even[evenCount] = a[i];			
				evenCount += 1;
			}
			else {
				odd[oddCount] = a[i];
				oddCount += 1;
			}								
		}
		
		for(int i = 0; i < evenCount; ++i) {
			
			a[i] = even[i];			
		}
		int p = 0;
		for(int i = evenCount; i < a.length; ++i) {
			a[i] = odd[p];
			++p;
		}
	}
	
	public static int getSecond(int[] a) {
				
		
		int max = 0;
		int secondMax = 0;
		
		for(int i = 0; i < a.length; ++i) {
			
			if(a[i] > max) {
				secondMax = max;
				max = a[i];
			}			
			else if(a[i] > secondMax && a[i] < max) {
				secondMax = a[i];
			}
		}
		
		return secondMax;
	}
	
	public static boolean isItInOrder(int[] a) {
		
		int last = a[0];
		
		for(int i = 1; i < a.length; ++i) {
			
			if(a[i] >= last) {
				last = a[i];
			}
			else {
				return false;
			}
			
		}
		
		
		return true;
	}
	
	
	public static boolean anyDuplicate(int[] a) {
		
		int max = a[0];
		
		for(int i = 1; i < a.length; ++i) {			
			if(a[i] > max) {
				max = a[i];
			}			
		}
		
		int[] here = new int[max + 1];
		
		for(int i = 0; i < here.length; ++i) {
			here[i] = 0;
		}
				
		for(int i = 0; i < a.length; ++i) {
			int sub = a[i];
			here[sub] += 1;
			if(here[sub] > 1) {
				return true;
			}						
		}		
		
		
		return false;
	}
	
	
	public static boolean isDuplicate(int[] a) {
		
		int last = a[0];
		
		for(int i = 1; i < a.length; ++i) {
			
			if(a[i] == last) {
				return true;
			}
			else {
				last = a[i];
			}			
		}		
		return false;
	}
	
	
	public static void main(String[] args) {
		
		
		int[] odd = {1,4,9,16,25,54,13,17,12,14,30};
		int[] even = {7,4,0,2,5,6,8,0};
		
		//print original odd array
		System.out.println("ORIGINAL ODD ARRAY ");
		print(odd);
		
		//test for swapFirstandLast
		System.out.println("SWAP FIRST AND LAST ");
		swapFirstandLast(odd);
		print(odd);
		
		//test for shiftToRight
		System.out.println("SHIFT to RIGHT ");
		shiftToRight(odd);
		print(odd);		
		
		//test for shiftToRight
		System.out.println("EVEN ELEMENTS TO ZERO ");
		evenToZero(odd);
		print(odd);					
	
		//test for replace larger of two neighbors
		System.out.println("Replace elements except first and last with larger of it's neighbor");
		replaceLargerNeighbor(odd);
		print(odd);			
		
		
		int[] oddToEven = new int[odd.length - 1];
		
		//test for removing middle element if array is odd
		System.out.println("Replace middle element if array is odd");
		replaceMiddleOdd(odd, oddToEven);
		print(oddToEven);	
		

		int[] evenToEven = new int[oddToEven.length - 2];
		
		//test for removing middle element if array is even
		System.out.println("Replace middle element if array is even");
		replaceMiddleEven(oddToEven,evenToEven);
		print(evenToEven);
		
		//Move all even elements to the front, preserving order of odd
		System.out.println("Move even elements to the front, preserving order of elements");
		moveEvenToFront(evenToEven);
		print(evenToEven);
		
		//Return second largest element in array
		System.out.println("Return second largest element in array");
		int secondLargest = getSecond(evenToEven); 
		System.out.println("second largest element = " + secondLargest);
		
		//returns true if array is currently sorted in increasing order
		System.out.println("Test to see is array is in order (array is not in order) ");
		if(isItInOrder(evenToEven)) {
			System.out.println("Array is in order!");
		}
		else {
			System.out.println("Array is not in order!");
		}
		
		//test to see if array is in increasing order (in order test)
		int [] order = {1,5,7,8,14};
		System.out.println("Print array in order : ");	
		print(order);
		System.out.println("Test to see is array is in order (array is in order) ");
		if(isItInOrder(order)) {
			System.out.println("Array is in order!");
		}
		else {
			System.out.println("Array is not in order!");
		}
		
		//returns true is array has two adjacent duplicate items
		System.out.println("Test to see if array contains two adjacent duplicate items (array has two adjacent dups) ");
		if(isDuplicate(evenToEven)) {
			System.out.println("Array has two adjacent duplicate items!");
		}
		else {
			System.out.println("Array does not have two adjacent duplicate items!");
		}
		System.out.println("Print array without adjacent dups : ");	
		print(order);
		System.out.println("Test to see is array contains two adjacent duplicate items (array does not have two adjacent dups)  ");
		if(isDuplicate(order)) {
			System.out.println("Array has two adjacent duplicate items!");
		}
		else {
			System.out.println("Array does not have two adjacent duplicate items!");
		}
		
		//returns true if array contains any duplicate items
		System.out.println("Test to see if array contains any duplicate items (it does)");
		if(anyDuplicate(evenToEven)) {			
			System.out.println("Array does contain duplicate items");			
		}
		else {
			System.out.println("Array does not contain duplicate items");			
		}
		System.out.println("Print array without any dups : ");	
		print(order);
		System.out.println("Test to see is array has any dups (array does not have dups)  ");
		if(anyDuplicate(order)) {			
			System.out.println("Array does contain duplicate items");			
		}
		else {
			System.out.println("Array does not contain duplicate items");			
		}
	}

}
